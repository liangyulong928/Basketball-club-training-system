package ac.sict.yulong.api;

import ac.sict.yulong.pojo.ClubPlayer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("club-player-management")
@RequestMapping("player-management")
public interface PlayerClient {

    /*
    * 功能：查询管理员管辖范围内所有球员
    * 参数：管理员所属单位
    * */
    @GetMapping("/selectAllPlayer/{office}")
    public List<ClubPlayer> selectAllPlayer(@PathVariable String office);

    @GetMapping("/updatePlayer/{playerString}")
    public int updatePlayer(@PathVariable String playerString);

    @GetMapping("/addPlayer/{playerString}")
    public int addPlayer(@PathVariable String playerString);

    @GetMapping("/selectCBAPlayer")
    public List<ClubPlayer> selectCBAPlayer();

    @GetMapping("/signContract/{player_id}/{id}")
    public int signContract(@PathVariable String player_id,@PathVariable String id);

    @GetMapping("/signOutCBA/{id}")
    public int signOutCBA(@PathVariable String id);

    @GetMapping("/addTag/{tagString}")
    public int addTag(@PathVariable String tagString);

    @GetMapping("/getPlayer/{office}")
    public List<ClubPlayer> getPlayer(@PathVariable String office);
}
