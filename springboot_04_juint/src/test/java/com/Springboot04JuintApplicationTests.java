package com;

import com.example.Springboot04JuintApplication;
import com.example.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = Springboot04JuintApplication.class)
//@ContextConfiguration(classes = Springboot04JuintApplication.class)
class Springboot04JuintApplicationTests {
    //1、注入要测试的对象
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        //2、测试方法
        bookDao.save();
    }

}
