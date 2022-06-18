package ac.sict.yulong.controller;

import ac.sict.yulong.api.GameClient;
import ac.sict.yulong.pojo.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("game")
@CrossOrigin
public class GameController {

    @Autowired
    private GameClient gameClient;

    @RequestMapping("getGameList")
    public List<Game> getGameList(@RequestParam String office, @RequestParam Timestamp start, @RequestParam Timestamp end){
        return gameClient.getGameList(office,start,end);
    }

    @RequestMapping("/getPlayerAnalyseData")
    public JSONObject getPlayerAnalyseData(@RequestParam Integer player_id){
        return gameClient.getPlayerAnalyseData(player_id);
    }

    @RequestMapping("/setNewTrain")
    public int setNewTrain(@RequestParam String plan){
        return gameClient.setNewPlan(plan);
    }

    @RequestMapping("/getAllPlan")
    public List<GameShow> getAllPlan(@RequestParam String office){
        return gameClient.getAllPlan(office);
    }

    @RequestMapping("/deletePlan")
    public int deletePlan(@RequestParam Integer game_id){
        return gameClient.deletePlan(game_id);
    }
}
