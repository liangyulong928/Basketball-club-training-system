package ac.sict.yulong.pojo;


import lombok.Data;

import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "tag")
@Data
public class Tag {
    private String player_id;
    private Timestamp date;
    private String type;
    private String msg;
    private String req_id;
}
