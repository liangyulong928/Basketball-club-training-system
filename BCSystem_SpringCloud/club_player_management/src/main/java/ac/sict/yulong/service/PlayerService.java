package ac.sict.yulong.service;


import ac.sict.yulong.mapper.PlayerMapper;
import ac.sict.yulong.mapper.TagMapper;
import ac.sict.yulong.pojo.ClubPlayer;
import ac.sict.yulong.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private TagMapper tagMapper;

    public List<ClubPlayer> getAllPlayer(String office){
        List<ClubPlayer> clubPlayers = playerMapper.selectByOffice(office);
        return clubPlayers;
    }

    public int updatePlayer(ClubPlayer player){
        return playerMapper.updateByPrimaryKey(player);
    }

    public int addPlayer(ClubPlayer player){
        player.setPassword("871e40437a3a623530d807586fdda8ac");
        return playerMapper.insert(player);
    }

    public List<ClubPlayer> selectCBAPlayer(){
        List<ClubPlayer> clubPlayers = playerMapper.selectCBAPlayer();
        for( ClubPlayer player : clubPlayers){
            List<Tag> tags = tagMapper.selectTagsByPlayer(player.getId());
            player.setTags(tags);
        }
        return clubPlayers;
    }

    public int signContract(String player_id,String id){
        return playerMapper.signContract(player_id,id);
    }

    public int signOutCBA(String id){
        ClubPlayer player = playerMapper.selectByPrimaryKey(id);
        player.setPlayer_id(null);
        return playerMapper.updateByPrimaryKey(player);
    }

    public List<ClubPlayer> getPlayer(String office){
        if (office=="2"){
            return playerMapper.selectAllPlayer2();
        }
        else {
            return playerMapper.selectAllPlayerOther(office);
        }
    }

}
