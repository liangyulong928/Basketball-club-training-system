package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.ClubPlayer;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PlayerMapper extends Mapper<ClubPlayer> {

    @Select("select * from club_player where office like concat(#{office},'%') order by office")
    public List<ClubPlayer> selectByOffice(String office);

    @Select("SELECT * FROM club_player WHERE player_id is NOT NULL")
    public List<ClubPlayer> selectCBAPlayer();

    @Update("UPDATE club_player SET player_id = #{player_id} WHERE id = #{id}")
    public int signContract(String player_id,String id);

    @Select("select * from club_player where office = 2 OR office is null")
    public List<ClubPlayer> selectAllPlayer2();

    @Select("select * from club_player where office = #{office}")
    public List<ClubPlayer> selectAllPlayerOther(String office);


}
