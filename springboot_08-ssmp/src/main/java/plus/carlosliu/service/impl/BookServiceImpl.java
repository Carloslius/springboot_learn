package plus.carlosliu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plus.carlosliu.dao.BookMapper;
import plus.carlosliu.domain.Book;
import plus.carlosliu.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public IPage<Book> getByPage(int currentPage, int size) {
        IPage<Book> page = new Page<>(currentPage, size);
        bookMapper.selectPage(page, null);
        return page;
    }
}
