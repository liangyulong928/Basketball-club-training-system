package ac.sict.yulong.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class GameShow {

    private Integer game_id;
    private Timestamp time;
    private Integer type;
    private String office;
    private String office_name;
    private String registrar;
    private String registrar_name;
}
