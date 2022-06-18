package ac.sict.yulong.service;

import ac.sict.yulong.api.AdminClient;
import ac.sict.yulong.api.PlayerClient;
import ac.sict.yulong.pojo.Admin;
import ac.sict.yulong.pojo.ClubPlayer;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewPlanData {

    @Autowired
    private AdminClient adminClient;
    @Autowired
    private PlayerClient playerClient;

    public JSONObject getNewPlanList(String office){
        List<Admin> registrarList = adminClient.getRegistrarList(office);
        List<ClubPlayer> player = playerClient.getPlayer(office);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("registrar",registrarList);
        jsonObject.put("playerList",player);
        return jsonObject;
    }
}
