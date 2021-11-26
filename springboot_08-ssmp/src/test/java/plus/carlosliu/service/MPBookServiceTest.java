package plus.carlosliu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import plus.carlosliu.domain.Book;

@SpringBootTest
public class MPBookServiceTest {
    @Autowired
    private IBookService iBookService;

    @Test
    public void testGetById(){
        System.out.println(iBookService.getById(3));
    }

    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("测试数据0");
        book.setType("测试类型0");
        book.setDescription("测试描述数据0");
        iBookService.save(book);
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(3);
        book.setName("测试数据0");
        book.setType("测试类型0");
        book.setDescription("测试描述数据0");
        iBookService.updateById(book);
    }

    @Test
    public void testDelete(){
        iBookService.removeById(8);
    }

    @Test
    public void testGetAll(){
        System.out.println(iBookService.list());
    }

    @Test
    public void testGetPage(){
        IPage<Book> page = new Page<>(2, 4);
        iBookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
