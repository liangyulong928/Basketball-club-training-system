package ac.sict.yulong.pojo;

import lombok.Data;

import javax.persistence.Column;
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

    public Admin(String id, String name, String office, String keyword, String phone,Integer status) {
        this.id = id;
        this.name = name;
        this.office = office;
        this.keyword = keyword;
        this.phone = phone;
        this.status = status;
    }
}
