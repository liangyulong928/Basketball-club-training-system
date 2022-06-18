package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.Admin;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminMapper extends Mapper<Admin> {

    @Select("select * from admin where phone = #{id}")
    public Admin queryByPhone(String id);

    @Select("select * from admin where office=#{office} and (actor=3 OR actor=5 or actor=6)")
    public List<Admin> getRegistrarList(String office);

}
