package ac.sict.yulong.pojo;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "game")
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer game_id;
    private Timestamp time;
    private Integer type;
    private String office;
    private String registrar;

    @Transient
    private List<GameData> dataList;
}
