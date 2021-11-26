package plus.carlosliu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
}
