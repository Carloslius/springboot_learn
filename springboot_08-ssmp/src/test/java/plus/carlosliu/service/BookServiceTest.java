package plus.carlosliu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import plus.carlosliu.domain.Book;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testGetById(){
        System.out.println(bookService.getById(3));
    }

    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("测试数据5");
        book.setType("测试类型5");
        book.setDescription("测试描述数据5");
        bookService.save(book);
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(3);
        book.setName("测试数据1");
        book.setType("测试类型1");
        book.setDescription("测试描述数据1");
        bookService.update(book);
    }

    @Test
    public void testDelete(){
        bookService.delete(9);
    }

    @Test
    public void testGetAll(){
        System.out.println(bookService.getAll());
    }

    @Test
    public void testGetPage(){
        IPage<Book> page = bookService.getByPage(2,4);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
