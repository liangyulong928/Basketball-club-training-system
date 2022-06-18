package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.Game;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.sql.Timestamp;
import java.util.List;

public interface GameMapper extends Mapper<Game> {


    @Select("SELECT game_id,time,type,game.office,`name` AS registrar FROM game,admin \n" +
            "WHERE registrar = admin.id\n" +
            "AND game.office LIKE concat(#{office},'%')\n" +
            "AND time >=#{start}\n" +
            "AND time <=#{end}\n" +
            "ORDER BY time DESC")
    public List<Game> selectGameList(String office, Timestamp start, Timestamp end);

    @Delete("DELETE FROM game WHERE game_id = #{game_id}")
    public int deletePlan(Integer game_id);
}
