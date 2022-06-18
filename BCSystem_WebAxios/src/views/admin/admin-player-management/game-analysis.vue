<template>
  <div>
    <div class="d-flex align-items-center col-md-12" style="margin-bottom: 20px">
      <div class="block">
        <el-date-picker
          v-model="date_value"
          type="daterange"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          :picker-options="pickerOptions">
        </el-date-picker>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <el-button type="primary" icon="lni lni-magnifier" @click="searchGameList" round> 搜索比赛</el-button>
      </div>
    </div>
    <div class="card">
      <div class="card-body">
        <el-collapse v-for="game in game_list" :key="game">
          <game_table v-bind:game="game"></game_table>
        </el-collapse>
      </div>
    </div>
  </div>
</template>

<script>
import moment from "moment";
import Game_table from "../../../components/game_data/game_table";

export default {
  name: "game-analysis",
  // eslint-disable-next-line vue/no-unused-components
  components: { Game_table },
  data(){
    return{
      user:null,
      activeNames: ['1'],
      date_value: [],
      game_list:[]
    }
  },
  created() {
    this.user = this.$route.params.user;
    this.date_value[1] = new Date()
    this.date_value[0] = this.date_value[1] - 3600 * 1000 * 24 * 90
    this.searchGameList()
  },
  methods: {
    searchGameList(){
      let start = moment(this.date_value[0]).format("YYYY-MM-DD hh:mm:ss")
      let end = moment(this.date_value[1]).format("YYYY-MM-DD hh:mm:ss")
      let url = "http://localhost:8086/game/getGameList?office="+this.user.office+"&start="+start+"&end="+end
      this.axios.get(url).then(
        (res)=>{
          this.game_list = res.data
        }
      )
    }
  }
};
</script>

<style scoped>

</style>