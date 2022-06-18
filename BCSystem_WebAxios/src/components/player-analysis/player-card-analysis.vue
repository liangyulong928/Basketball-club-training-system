<template>
  <div class="col-6 d-flex">
    <div class="card radius-10 w-100">
      <div class="card-body">
        <div class="d-flex align-items-center">
          <el-link type="primary" style="font-size: 17px" @click="dialogFormVisible = true">{{player.name}}</el-link>
          <el-dialog :title="player.name" :visible.sync="dialogFormVisible">
            <table class="table table-striped table-bordered dataTable" style="width: 100%;" role="grid" aria-describedby="example_info">
              <thead>
              <tr role="row">
                <th class="sorting_asc">比赛时间</th>
                <th class="sorting">得分</th>
                <th class="sorting">篮板</th>
                <th class="sorting">助攻</th>
                <th class="sorting">出场时间</th>
                <th class="sorting">投篮命中率</th>
                <th class="sorting">三分球命中率</th>
                <th class="sorting">罚球命中率</th>
                <th class="sorting">竞技状态</th>
              </tr>
              </thead>
              <tbody v-for="game_data in averageDataTen" :key="game_data.game_id">
                <player_tr v-bind:game_data="game_data"></player_tr>
              </tbody>
            </table>
          </el-dialog>
        </div>
        <br/>
        <div class="traffic-widget">
          <div class="progress-wrapper mb-3">
            <p class="mb-1">球员面板</p>
            <div :id="player.id" style="width: 100%;height: 400px"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import * as echarts from 'echarts';
import Player_tr from "../game_data/player_tr";
export default {
  name: "player-card-analysis",
  // eslint-disable-next-line vue/no-unused-components
  components: { Player_tr },
  data(){
    return{
      averageDataYear:[],
      averageDataTen:[],
      dataList:{},
      dialogFormVisible:false
    }
  },
  props:{
    player:JSON
  },
  mounted() {
    this.axios.get("http://localhost:8086/game/getPlayerAnalyseData",{params:{player_id:this.player.id}}).then(
      (res)=>{
        let playerData = JSON.parse(JSON.stringify(res.data));
        this.averageDataYear = playerData.averageDataYear;
        this.averageDataTen = playerData.averageDataTen;
        this.drawLine(this.averageDataYear);
      }
    )
  },
  created() {

  },
  methods:{
    drawLine(data) {
      console.log(data)
      var myChart = echarts.init(document.getElementById(this.player.id));
      var option = {
        radar: {
          // shape: 'circle',
          indicator: [
            { name: '场均得分得分', max: 25 },
            { name: '场剧篮板', max: 10 },
            { name: '场均助攻', max: 10 },
            { name: '投篮命中率', max: 1 },
            { name: '三分球命中率', max: 0.7 },
            { name: '罚球命中率', max: 1 }
          ]
        },
        series: [
          {
            name: '本赛季数据',
            type: 'radar',
            data: [
              {
                value: data,
                name: '本赛季'
              }
            ]
          }
        ]
      };
      option && myChart.setOption(option);
    }
  }
};
</script>

<style scoped>

</style>