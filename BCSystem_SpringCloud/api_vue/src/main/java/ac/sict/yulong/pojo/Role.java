package ac.sict.yulong.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Role {

    private String id;
    private String name;
    private String office_name;
    private String phone;
    private Integer actor;
    private Integer status;
}
