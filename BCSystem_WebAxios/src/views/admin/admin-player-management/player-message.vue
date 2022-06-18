<template>
<div id="main">
  <div class="d-flex align-items-center" style="margin-bottom: 20px">
    <el-select v-model="type" @change="selectPlayer(type)">
      <el-option v-if="this.user.office==2" label="联赛球员" value="cba">联赛球员</el-option>
      <el-option v-else disabled>联赛球员</el-option>
      <el-option value="ngc" label="省体育局注册球员">省体育局注册球员</el-option>
    </el-select>
    <form class="ms-auto position-relative">
      <div class="position-absolute top-50 translate-middle-y search-icon px-3"><i class="bi bi-search"></i></div>
      <input class="form-control ps-5" v-model="key_word" type="text" placeholder="通过姓名搜索" @input="searchPlayer">
    </form>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <el-button type="primary" icon="el-icon-edit" @click="dialogFormVisibleAction" round>新增球员</el-button>
    <el-dialog title="新增球员" :visible.sync="dialogFormVisible">
      <div class="card-body">
        <div class="card shadow-none border">
          <div class="card-body">
            <New_player v-bind:user="user"/>
          </div>
        </div>
      </div>
    </el-dialog>
  </div>
  <div class="row row-cols-1 row-cols-md-2 row-cols-lg-2 row-cols-xxl-4">
    <player-card v-bind:type="type" v-for="player in player_act_list" v-bind:user="user" :key="player.id" v-bind:player="player"/>
    <h5 v-if="isShowUp">搜索结果为空</h5>
  </div>
</div>
</template>

<script>
import PlayerCard from "../../../components/player-message/player-card";
import New_player from "../../../components/player-message/new-player";
export default {
  name: "player-message",
  components: { New_player, PlayerCard },
  data(){
    return{
      user:null,
      type:"",
      key_word:"",
      isShowUp:false,
      dialogFormVisible:false,
      player_list:[],
      player_act_list:[]
    }
  },
  methods:{
    selectPlayer(type){
      if (type=='cba'){
        this.selectCBAPlayer();
      }
      if(type=='ngc') {
        this.selectNGCPlayer();
      }
    },
    selectCBAPlayer(){
      this.player_list = []
      this.player_act_list = []
      this.axios("http://localhost:8086/player-management/selectCbaPlayer").then(
        (res) => {
          this.player_list = res.data;
          this.player_act_list = this.player_list;
        }
      );
    },
    selectNGCPlayer(){
      this.player_list = []
      this.player_act_list = []
      let param = new URLSearchParams();
      param.append("office", this.user.office);
      this.axios.post("http://localhost:8086/player-management/selectAllPlayer", param).then(
        (res) => {
          this.player_list = res.data;
          this.player_act_list = this.player_list;
        }
      );
    },
    dialogFormVisibleAction(){
      this.dialogFormVisible = true;
    },
    searchPlayer(){
      if (this.key_word==""){
        this.isShowUp = false;
        this.player_act_list = this.player_list;
      }
      else {
        this.player_act_list = [];
        this.isShowUp = false;
        this.player_list.forEach(
          (item)=>{
            if (item.name.indexOf(this.key_word)>-1){
              this.player_act_list.push(item);
            }
          }
        )
        if (this.player_act_list.length==0){
          this.isShowUp = true;
        }
      }
    }
  },
  created: function() {
    this.user = this.$route.params.user;
    if (this.user.office==2){
      this.type="cba";
      this.selectCBAPlayer();
    }
    else {
      this.type = "ngc";
      this.selectNGCPlayer();
    }
  }
};
</script>

<style scoped>

</style>