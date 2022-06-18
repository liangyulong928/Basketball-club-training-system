package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.NoticeForMena;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NoticeForMenaMapper extends Mapper<NoticeForMena> {

    @Select("SELECT type,name,COUNT(*) AS count,apply_time,rounter\n" +
            "FROM notice_main,admin,`function`\n" +
            "WHERE accept_id = #{id} \n" +
            "AND accept_time is NULL\n" +
            "AND notice_main.apply_id = admin.id\n" +
            "AND notice_main.func = `function`.func_id\n" +
            "GROUP BY type,name,apply_time,rounter")
    public List<NoticeForMena> getNoticeList(String id);
}
