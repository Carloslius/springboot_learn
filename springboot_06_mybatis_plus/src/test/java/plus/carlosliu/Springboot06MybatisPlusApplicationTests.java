package plus.carlosliu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import plus.carlosliu.dao.UserDao;

@SpringBootTest
class Springboot06MybatisPlusApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println(userDao.selectById(2));
    }

    @Test
    void findAll(){
        System.out.println(userDao.selectList(null));
    }

}
