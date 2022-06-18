package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.GameShow;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.sql.Timestamp;
import java.util.List;

public interface GameShowMapper extends Mapper<GameShow> {

    @Select("SELECT game_id,time,type,game.office,office_name,registrar,`name` AS registrar_name FROM game,office,admin \n" +
            "WHERE game.registrar = admin.id AND office.office_id = game.office AND game.office LIKE concat(#{office},'%') \n" +
            "AND game.time > #{time}")
    public List<GameShow> getAllPlan(Timestamp time,String office);
}
