package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.GameData;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GameDataMapper extends Mapper<GameData> {

    @Select("SELECT game_data.player_id,club_player.`name` as player_name,score,backboard,shooting,shooting_shot,\n" +
            "three_point_hit,three_point_shot,free_throw_hit,free_throw_shot,assists,time,`value`\n" +
            "FROM game_data,club_player WHERE game_id = #{game_id} AND club_player.id = game_data.player_id\n" +
            "ORDER BY score DESC")
    public List<GameData> getGameDataList(Integer game_id);

    @Insert("INSERT INTO game_data SET game_id=#{game_id},player_id=#{player_id},type=#{type}")
    public int insertGameData(Integer game_id,Integer player_id,Integer type);

    @Delete("DELETE FROM game_data WHERE game_id = #{game_id}")
    public int deletePlan(Integer game_id);

}
