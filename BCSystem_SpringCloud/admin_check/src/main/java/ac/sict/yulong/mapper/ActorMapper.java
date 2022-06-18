package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.Actor;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ActorMapper extends Mapper<Actor> {

    @Select("SELECT actor_id,actor_name FROM actor,admin " +
            "WHERE actor.actor_id = admin.actor " +
            "AND admin.id = #{id}")
    public List<Actor> searchActorById(String id);

}
