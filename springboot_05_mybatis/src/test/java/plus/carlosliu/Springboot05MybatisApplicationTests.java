package plus.carlosliu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import plus.carlosliu.dao.UserDao;
import plus.carlosliu.domain.User;

@SpringBootTest
class Springboot05MybatisApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        User user = userDao.getById(1);
        System.out.println(user);
    }

}
