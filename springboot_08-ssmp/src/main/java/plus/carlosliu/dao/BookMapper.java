package plus.carlosliu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import plus.carlosliu.domain.Book;

@Mapper
public interface BookMapper {

    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);
}
