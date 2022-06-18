package ac.sict.yulong.pojo;


import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ClubPlayer {
    private Integer id;
    private String name;
    private Integer player_id;
    private String password;
    private String phone;
    private String wechat_pid;
    private String office;
    private Timestamp birthday;
    private String position_1;
    private String position_2;
    private List<Tag> tags;
}
