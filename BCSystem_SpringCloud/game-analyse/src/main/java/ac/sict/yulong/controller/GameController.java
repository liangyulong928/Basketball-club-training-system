package ac.sict.yulong.controller;

import ac.sict.yulong.pojo.Game;
import ac.sict.yulong.pojo.GameShow;
import ac.sict.yulong.service.GameService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/getGameList")
    public List<Game> getGameList(@RequestParam String office, @RequestParam Timestamp start, @RequestParam Timestamp end){
        return gameService.getGameList(office,start,end);
    }

    @RequestMapping("/getPlayerAnalyseData")
    public JSONObject getPlayerAnalyseData(@RequestParam Integer player_id){
        return gameService.getPlayerAnalyseData(player_id);
    }

    @RequestMapping("/setNewPlan")
    public int setNewPlan(@RequestParam String plan){
        return gameService.setNewGame(plan);
    }

    @RequestMapping("/getAllPlan")
    public List<GameShow> getAllPlan(@RequestParam String office){
        return gameService.getAllPlan(office);
    }

    @RequestMapping("/deletePlan")
    public int deletePlan(@RequestParam Integer game_id){
        return gameService.deletePlan(game_id);
    }
}
