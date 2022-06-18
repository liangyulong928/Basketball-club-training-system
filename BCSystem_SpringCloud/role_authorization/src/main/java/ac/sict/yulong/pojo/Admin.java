package ac.sict.yulong.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "admin")
public class Admin {
    @Id
    private String id;
    private String name;
    private String office;
    private String keyword;
    private String phone;
    private Integer actor;
    private Integer status;
}