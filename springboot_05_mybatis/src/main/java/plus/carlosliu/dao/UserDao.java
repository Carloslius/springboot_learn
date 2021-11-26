package plus.carlosliu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import plus.carlosliu.domain.User;
//3、在mapper层类上加注释，被spring容器识别到，自动代理
@Mapper
public interface UserDao {
    @Select("select * from user where id = #{id}")
    User getById(Integer id);
}
