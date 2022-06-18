package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.Admin;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminMapper extends Mapper<Admin> {

    @Select("SELECT * FROM admin " +
            "WHERE office = #{office} " +
            "AND actor = 1")
    public List<Admin> getAccpet(String office);
}
