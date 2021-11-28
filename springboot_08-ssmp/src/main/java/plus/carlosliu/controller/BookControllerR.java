package plus.carlosliu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plus.carlosliu.controller.util.R;
import plus.carlosliu.domain.Book;
import plus.carlosliu.service.IBookService;

import java.util.List;

/*
    update和save用异步提交发送，参数通过请求体传json数据
    delete和select单个一般使用路径变量来传参

    形参位置注释表明参数来源
 */

@RestController
@RequestMapping("/books")
public class BookControllerR {
    @Autowired
    private IBookService bookService;

    @PostMapping
    public R save(@RequestBody Book book){
//        R r = new R();
//        boolean flag = bookService.save(book);
//        r.setFlag(flag);
        Boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        boolean flag = bookService.removeById(id);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, bookService.getById(id));
    }

    @GetMapping
    public R getAll(){
        return new R(true, bookService.list());
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, Book book){
        System.out.println("参数 ====> " + book);
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        if (currentPage > page.getCurrent()){
            page = bookService.getPage((int)page.getCurrent(), pageSize, book);
        }
        return new R(true, page);
    }
}
