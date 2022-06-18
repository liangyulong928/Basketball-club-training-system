package ac.sict.yulong.pojo;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "office")
public class Office {

    @Id
    private String office_id;
    private String office_name;
}
