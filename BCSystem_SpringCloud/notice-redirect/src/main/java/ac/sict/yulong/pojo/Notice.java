package ac.sict.yulong.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Table(name = "notice_main")
public class Notice {
    private Integer func;
    private String type;
    private String apply_id;
    private String accept_id;
    private Timestamp apply_time;
    private Timestamp accept_time;

    public Notice(Integer function, String type, String apply_id, String accept_id, Timestamp apply_date, Timestamp accept_date) {
        this.func = function;
        this.type = type;
        this.apply_id = apply_id;
        this.accept_id = accept_id;
        this.apply_time = apply_date;
        this.accept_time = accept_date;
    }
}
