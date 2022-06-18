<template>
  <el-collapse-item :title="title" :name="game.id" style="padding-left: 20px">
    <div class="row">
      <div class="col-sm-12">
        <table id="example" class="table table-striped table-bordered dataTable" style="width: 100%;" role="grid" aria-describedby="example_info">
          <thead>
            <tr role="row">
              <th class="sorting_asc">球员姓名</th>
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
          <tbody v-for="game_data in game.dataList" :key="game_data.player_id">
            <game_tr v-bind:game_data="game_data"/>
          </tbody>
        </table>
      </div>
    </div>
  </el-collapse-item>
</template>

<script>
import moment from "moment";
import Game_tr from "./game_tr";

export default {
  name: "game_table",
  // eslint-disable-next-line vue/no-unused-components
  components: { Game_tr },
  data(){
    return{
      title:null
    }
  },
  props:{
    game:JSON
  },
  created() {
    // eslint-disable-next-line no-unused-vars
    let type = "";
    if (this.game.type==1){
      type="联赛"
    }
    else {
      type="训练"
    }
    this.title = moment(this.game.time).format("yyyy年MM月DD日 ")+type+" 记录员:" + this.game.registrar
  }
};
</script>

<style scoped>

</style>