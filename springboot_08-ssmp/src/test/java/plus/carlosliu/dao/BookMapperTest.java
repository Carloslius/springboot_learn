package plus.carlosliu.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import plus.carlosliu.domain.Book;

@SpringBootTest
public class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;

/*    @Test
    public void test_Mybatis(){
        System.out.println(bookMapper.getById(1));
    }*/

    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("测试数据4");
        book.setType("测试类型4");
        book.setDescription("测试描述数据4");
        bookMapper.insert(book);
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(4);
        book.setName("测试数据00");
        book.setType("测试类型");
        book.setDescription("测试描述数据");
        bookMapper.updateById(book);
    }

    @Test
    public void testDelete(){
        bookMapper.deleteById(4);
    }

    @Test
    public void testGetAll(){
        System.out.println(bookMapper.selectList(null));
    }

    @Test
    public void testGetPage(){
        IPage page = new Page(2,2);
        bookMapper.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    @Test
    public void testGetByCondition(){
        String name = "测试";
        IPage page = new Page(1, 3);
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("name", name);
        bookMapper.selectPage(page, wrapper);
    }
    @Test
    public void testGetByCondition2(){
        String name = "Spring";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Book::getName, name);
        bookMapper.selectList(lambdaQueryWrapper);
    }
    @Test
    public void testGetByCondition3(){
        String name = null;
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name != null, Book::getName, name);
        bookMapper.selectList(lambdaQueryWrapper);
    }
}
