package plus.carlosliu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import plus.carlosliu.domain.User;

//3、在mapper层类上加注释，被spring容器识别到，自动代理
@Mapper
public interface UserDao extends BaseMapper<User> {
}
