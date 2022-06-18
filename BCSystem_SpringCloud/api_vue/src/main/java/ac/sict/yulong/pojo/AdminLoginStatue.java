package ac.sict.yulong.pojo;

import lombok.Data;

@Data
public class AdminLoginStatue {
    private String adminId;
    private int keywordType;
    private Integer status;

    public AdminLoginStatue(String adminId, int keywordType,Integer status) {
        this.adminId = adminId;
        this.keywordType = keywordType;
        this.status = status;
    }
}
