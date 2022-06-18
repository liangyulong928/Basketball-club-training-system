package ac.sict.yulong.mapper;


import ac.sict.yulong.pojo.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.sql.Timestamp;

public interface NoticeMapper extends Mapper<Notice> {

    @Update("UPDATE notice_main SET accept_time = #{time} WHERE apply_id=#{id} AND type=\"新用户注册\"")
    public int acceptNewRole(String id, Timestamp time);

    @Delete("DELETE FROM notice_main\n" +
            "WHERE type=\"新用户注册\"\n" +
            "AND apply_id=#{id}")
    public int confuseRoleApply(String id);
}
