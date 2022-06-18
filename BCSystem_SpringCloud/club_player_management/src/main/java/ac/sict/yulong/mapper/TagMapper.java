package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.ClubPlayer;
import ac.sict.yulong.pojo.Tag;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TagMapper extends Mapper<Tag> {

    @Select("select player_id,date,type,msg,name as req_id from tag,admin WHERE player_id = #{player_id} and tag.req_id=admin.id order by date DESC")
    public List<Tag> selectTagsByPlayer(Integer player_id);
}
