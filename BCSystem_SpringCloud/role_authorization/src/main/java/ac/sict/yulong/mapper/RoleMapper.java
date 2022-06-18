package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.Role;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<Role> {


    @Select("SELECT id,`name`,office.office_name,phone,actor,`status`\n" +
            "FROM admin,office\n" +
            "WHERE office.office_id = admin.office\n" +
            "AND office_id LIKE concat(#{office},'%') \n" +
            "AND id!= #{id} \n" +
            "ORDER BY office_id,actor")
    public List<Role> getRoleList(String id,String office);

}
