<template>
  <tr role="row">
    <td>{{ date }}</td>
    <td>{{ game_data.score }}</td>
    <td>{{ game_data.backboard }}</td>
    <td>{{ game_data.assists }}</td>
    <td>{{ game_data.time }}min</td>
    <td>{{shooting_average}}</td>
    <td>{{three_point_average}}</td>
    <td>{{free_throw_average}}</td>
    <td>
      <el-tag v-if="game_data.value==3" size="small" type="danger">状态火热</el-tag>
      <el-tag v-if="game_data.value==2" size="small" type="success">状态良好</el-tag>
      <el-tag v-if="game_data.value==1" size="small" type="warning">状态较差</el-tag>
      <el-tag v-if="game_data.value==0" size="small" >状态低迷</el-tag>
    </td>
  </tr>
</template>

<script>
import moment from "moment";

export default {
  name: "player_tr",
  data(){
    return{
      shooting_average:null,
      three_point_average:null,
      free_throw_average:null,
      date:null
    }
  },
  props:{
    game_data:JSON
  },
  created() {
    // eslint-disable-next-line no-unused-vars
    let shooting_average;
    if (this.game_data.shooting_shot!=0){
      shooting_average = this.game_data.shooting / this.game_data.shooting_shot
    }
    else {
      shooting_average = 0 ;
    }
    this.shooting_average = (shooting_average*100).toFixed(2)+"%"
    let three_average;
    if (this.game_data.three_point_shot!=0){
      three_average = this.game_data.three_point_hit / this.game_data.three_point_shot
    }
    else {
      three_average = 0 ;
    }
    this.three_point_average = (three_average*100).toFixed(2)+"%"
    let free_average;
    if (this.game_data.free_throw_shot!=0){
      free_average = this.game_data.free_throw_hit / this.game_data.free_throw_shot
    }
    else {
      free_average = 0 ;
    }
    this.free_throw_average = (free_average*100).toFixed(2)+"%";
    this.date = moment(this.game_data.game_date).format("MM-DD");
  }
};
</script>

<style scoped>

</style>