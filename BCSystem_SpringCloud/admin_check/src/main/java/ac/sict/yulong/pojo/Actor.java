package ac.sict.yulong.pojo;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "actor")
public class Actor {

    @Id
    private Integer actor_id;
    private String actor_name;
}
