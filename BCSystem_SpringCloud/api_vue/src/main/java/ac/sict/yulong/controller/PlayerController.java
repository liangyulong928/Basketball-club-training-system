package ac.sict.yulong.controller;

import ac.sict.yulong.api.PlayerClient;
import ac.sict.yulong.pojo.ClubPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("player-management")
public class PlayerController {

    @Autowired
    private PlayerClient playerClient;

    @RequestMapping("selectAllPlayer")
    public List<ClubPlayer> selectAllPlayer(@RequestParam String office){
        return playerClient.selectAllPlayer(office);
    }

    @PostMapping("/updatePlayer")
    public int updatePlayer(@RequestParam String playerString){
        return playerClient.updatePlayer(playerString);
    }

    @PostMapping("/addPlayer")
    public int addPlayer(@RequestParam String playerString){
        return playerClient.addPlayer(playerString);
    }

    @RequestMapping("/selectCbaPlayer")
    public List<ClubPlayer> selectCBAPlayer(){
        return playerClient.selectCBAPlayer();
    }

    @RequestMapping("/signContract")
    public int signContract(@RequestParam String player_id,@RequestParam String id){
        return playerClient.signContract(player_id, id);
    }

    @GetMapping("/signOutCBA")
    public int signOutCBA(@RequestParam String id){
        return playerClient.signOutCBA(id);
    }
}
