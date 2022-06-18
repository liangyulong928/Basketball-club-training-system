package ac.sict.yulong.api;

import ac.sict.yulong.pojo.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.List;

@FeignClient("game-analyse")
@RequestMapping("game")
public interface GameClient {

    @PostMapping("getGameList")
    public List<Game> getGameList(@RequestParam("office") String office,
                                  @RequestParam("start") Timestamp start,
                                  @RequestParam("end") Timestamp end);

    @PostMapping("/getPlayerAnalyseData")
    public JSONObject getPlayerAnalyseData(@RequestParam Integer player_id);

    @PostMapping("/setNewPlan")
    public int setNewPlan(@RequestParam String plan);

    @PostMapping("/getAllPlan")
    public List<GameShow> getAllPlan(@RequestParam String office);

    @PostMapping("/deletePlan")
    public int deletePlan(@RequestParam Integer game_id);
}
