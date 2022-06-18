package ac.sict.yulong.pojo;


import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Game {
    private Integer game_id;
    private Timestamp time;
    private Integer type;
    private String office;
    private String registrar;

    private List<GameData> dataList;

}
