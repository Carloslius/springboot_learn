package plus.carlosliu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import plus.carlosliu.domain.Book;

/*@Mapper
public interface BookMapper {

    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);
}*/

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
