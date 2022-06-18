package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.Function;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AFMapper extends Mapper<Function> {

    @Select("SELECT func_name,icon,rounter,select_key,update_key,add_key \n" +
            "\tFROM actor,actor_method_list,`function`,admin\n" +
            "WHERE actor.actor_id = actor_method_list.actor_id \n" +
            "\tAND actor_method_list.function_id = `function`.func_id \n" +
            "\tAND actor.actor_id = admin.actor\n" +
            "\tAND admin.id = #{id} ")
    public List<Function> getFunctionListById(String id);
}
