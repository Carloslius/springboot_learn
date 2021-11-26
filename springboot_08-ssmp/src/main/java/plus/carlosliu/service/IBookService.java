package plus.carlosliu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import plus.carlosliu.domain.Book;

public interface IBookService extends IService<Book> {
    // 自定义方法、功能追加：
    Boolean saveBook(Book book);
    Boolean modify(Book book);
    Boolean delete(Integer id);
    IPage<Book> getPage(Integer currentPage, Integer size);
}
