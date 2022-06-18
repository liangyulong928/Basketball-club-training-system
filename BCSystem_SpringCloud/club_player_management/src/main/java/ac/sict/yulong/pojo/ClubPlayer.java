package ac.sict.yulong.pojo;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Table(name = "club_player")
public class ClubPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Transient
    private List<Tag> tags;
}
