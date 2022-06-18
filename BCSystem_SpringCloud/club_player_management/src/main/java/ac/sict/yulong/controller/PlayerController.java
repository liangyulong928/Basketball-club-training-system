package ac.sict.yulong.controller;


import ac.sict.yulong.mapper.TagMapper;
import ac.sict.yulong.pojo.ClubPlayer;
import ac.sict.yulong.pojo.Tag;
import ac.sict.yulong.service.PlayerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player-management")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/selectAllPlayer/{office}")
    public List<ClubPlayer> selectAllPlayer(@PathVariable String office){
        return playerService.getAllPlayer(office);
    }

    @GetMapping("/updatePlayer/{playerString}")
    public int updatePlayer(@PathVariable String playerString){
        ClubPlayer player = JSONObject.parseObject(playerString, ClubPlayer.class);
        return playerService.updatePlayer(player);
    }

    @GetMapping("/selectCBAPlayer")
    public List<ClubPlayer> selectCBAPlayer(){
        return playerService.selectCBAPlayer();
    }

    @GetMapping("/addPlayer/{playerString}")
    public int addPlayer(@PathVariable String playerString){
        ClubPlayer player = JSONObject.parseObject(playerString,ClubPlayer.class);
        return playerService.addPlayer(player);
    }

    @GetMapping("/signContract/{player_id}/{id}")
    public int signContract(@PathVariable String player_id,@PathVariable String id){
        return playerService.signContract(player_id,id);
    }

    @GetMapping("/signOutCBA/{id}")
    public int signOutCBA(@PathVariable String id){
        return playerService.signOutCBA(id);
    }

    @Autowired
    private TagMapper mapper;

    @GetMapping("/addTag/{tagString}")
    public int addTag(@PathVariable String tagString){
        Tag tag = JSONObject.parseObject(tagString, Tag.class);
        return mapper.insert(tag);
    }

    @GetMapping("/getPlayer/{office}")
    public List<ClubPlayer> getPlayer(@PathVariable String office){
        return playerService.getPlayer(office);
    }
}
