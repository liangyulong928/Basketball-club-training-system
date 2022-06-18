package ac.sict.yulong.service;

import ac.sict.yulong.mapper.*;
import ac.sict.yulong.pojo.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private GameDataMapper gameDataMapper;

    @Autowired
    private PlayerAverageDataMapper averageDataMapper;

    @Autowired
    private PlayerDataMapper dataMapper;

    @Autowired
    private GameShowMapper gameShowMapper;

    public List<Game> getGameList(String office, Timestamp start, Timestamp end){
        /**
         * @Select("SELECT game_id, time, type, game.office,`name` AS registrar FROM game,admin \n" +
         *             "WHERE registrar = admin.id\n" +
         *             "AND game.office LIKE concat(#{office},'%')\n" +
         *             "AND time >=#{start}\n" +
         *             "AND time <=#{end}\n" +
         *             "ORDER BY time DESC")
         *     public List<Game> selectGameList(String office, Timestamp start, Timestamp end);
         * */
        List<Game> games = gameMapper.selectGameList(office, start, end);
        for (Game game : games){
            /**
             * @Select("SELECT game_id, time, type, game.office, office_name, registrar,`name` AS registrar_name FROM game,office,admin \n" +
             *             "WHERE game.registrar = admin.id AND office.office_id = game.office AND game.office LIKE concat(#{office},'%') \n" +
             *             "AND game.time > #{time}")
             *     public List<GameShow> getAllPlan(Timestamp time,String office);
             * */
            game.setDataList(gameDataMapper.getGameDataList(game.getGame_id()));
        }
        return games;
    }

    public int setNewGame(String plan){
        Game game = JSONObject.parseObject(plan, Game.class);
        int insert = gameMapper.insert(game);
        Integer game_id = game.getGame_id();
        JSONObject jsonObject = JSONObject.parseObject(plan);
        JSONArray player = jsonObject.getJSONArray("player");
        List<GameData> gameData = null;
        for (Object i : player){
            gameDataMapper.insertGameData(game_id, (Integer) i,game.getType());
        }
        return insert;
    }

    public JSONObject getPlayerAnalyseData(Integer player_id){
        Date date = new Date();
        date.setYear(date.getYear()-1);
        Timestamp timestamp1 = new Timestamp(date.getTime());
        List<PlayerAverageData> playerDataList1 = averageDataMapper.getPlayerDataList(player_id, timestamp1);
        PlayerAverageData playerAverageData = playerDataList1.get(0);
        ArrayList<Float> floats = new ArrayList<>();
        if (playerAverageData==null){
            for (int i=0;i<6;i++){
                floats.add((float) 0);
            }
        }
        else{
            if (playerAverageData.getScore()!=null){
                floats.add(playerAverageData.getScore());
            }
            else {
                floats.add((float) 0);
            }
            if (playerAverageData.getBackboard()!=null){
                floats.add(playerAverageData.getBackboard());
            }
            else {
                floats.add((float) 0);
            }
            if (playerAverageData.getAssists()!=null){
                floats.add(playerAverageData.getAssists());
            }
            else {
                floats.add((float) 0);
            }
            if (playerAverageData.getShooting_average()!=null){
                floats.add(playerAverageData.getShooting_average());
            }
            else {
                floats.add((float) 0);
            }
            if (playerAverageData.getThree_point_average()!=null){
                floats.add(playerAverageData.getThree_point_average());
            }
            else {
                floats.add((float) 0);
            }
            if (playerAverageData.getFree_throw_average()!=null){
                floats.add(playerAverageData.getFree_throw_average());
            }
            else {
                floats.add((float) 0);
            }
        }
        List<PlayerData> playerDataList3 = dataMapper.getPlayerDataList(player_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("averageDataYear",floats);
        jsonObject.put("averageDataTen",playerDataList3);
        return jsonObject;
    }

    public List<GameShow> getAllPlan(String office){
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        return gameShowMapper.getAllPlan(time, office);
    }

    public int deletePlan(Integer game_id){
        gameDataMapper.deletePlan(game_id);
        return gameMapper.deletePlan(game_id);
    }
}
