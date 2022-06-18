package ac.sict.yulong.pojo;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class NoticeForMena {
    private String type;
    private String name;
    private int count;
    private Timestamp apply_time;
    private String rounter;
}
