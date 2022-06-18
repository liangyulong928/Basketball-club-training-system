package ac.sict.yulong.pojo;

import lombok.Data;

import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "game_data")
@Data
public class PlayerData {
    private Integer game_id;
    private Timestamp game_date;
    private Integer score;
    private Integer backboard;
    private Integer shooting;
    private Integer shooting_shot;
    private Integer three_point_hit;
    private Integer three_point_shot;
    private Integer free_throw_hit;
    private Integer free_throw_shot;
    private Integer assists;
    private Integer time;
    private Integer value;
}