package ac.sict.yulong.pojo;

import lombok.Data;

import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "game_data")
@Data
public class PlayerAverageData {
    private Float score;
    private Float backboard;
    private Float shooting_average;
    private Float three_point_average;
    private Float free_throw_average;
    private Float assists;
}