package plus.carlosliu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plus.carlosliu.dao.BookMapper;
import plus.carlosliu.domain.Book;
import plus.carlosliu.service.IBookService;

@Service
public class MPBookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Autowired
    private BookMapper bookMapper;

    // 自定义方法、功能追加： 与MP框架混合使用，进来不要重名覆盖
    @Override
    public Boolean saveBook(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Boolean modify(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer size) {
        IPage<Book> page = new Page<>(currentPage, size);
        bookMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int current, Integer pageSize, Book book){
        IPage<Book> page = new Page<>(current, pageSize);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        return bookMapper.selectPage(page, lqw);
    }
}
