package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.PlayerAverageData;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.sql.Timestamp;
import java.util.List;

public interface PlayerAverageDataMapper extends Mapper<PlayerAverageData> {

    /*
     * 计算选手本赛季平均值
     * */
    @Select("SELECT AVG(score) AS score,AVG(backboard) AS backboard,\n" +
            "AVG(shooting)/AVG(shooting_shot) AS shooting_average, \n" +
            "AVG(three_point_hit)/AVG(three_point_shot) AS three_point_average,\n" +
            "AVG(free_throw_hit)/AVG(free_throw_shot) AS free_throw_average,AVG(assists) AS assists\n" +
            "FROM game_data,game WHERE game_data.game_id = game.game_id \n" +
            "AND player_id = #{player_id} AND game.time >= #{date}")
    public List<PlayerAverageData> getPlayerDataList(Integer player_id, Timestamp date);

}
