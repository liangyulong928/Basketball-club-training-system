package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.GameData;
import ac.sict.yulong.pojo.PlayerData;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PlayerDataMapper extends Mapper<PlayerData> {


    /*
    * 查询选手近10场比赛的记录
    * */
    @Select("SELECT game.game_id,game.time AS game_date,score,backboard,shooting,shooting_shot,\n" +
            "three_point_hit,three_point_shot,free_throw_hit,free_throw_shot,assists,game_data.time,`value`\n" +
            "FROM game_data,game WHERE game_data.game_id = game.game_id AND player_id = #{player_id}\n" +
            "ORDER BY game_date DESC LIMIT 10")
    public List<PlayerData> getPlayerDataList(Integer player_id);

}
