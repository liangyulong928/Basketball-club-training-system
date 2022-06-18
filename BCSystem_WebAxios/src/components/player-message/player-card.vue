<template>
  <div :class="[type=='cba'?'col-xl-4':'col-xl-3']">
    <div class="card radius-10">
      <div class="card-body">
        <div class="d-flex align-items-center gap-3">
          <div class="border-0" v-if="type=='cba'">
            <img :src="this.img" style="height: 150px;width: 112px" class="bg-light-primary radius-30"/>
          </div>
          <div>
            <el-link type="primary" @click="dialogFormVisible = true" style="font-size: 17px">{{player.name}}</el-link>
            <el-dialog :title="player.name" :visible.sync="dialogFormVisible">
              <player-update v-bind:type="type" v-bind:user="user" v-bind:player="player"></player-update>
            </el-dialog>
            <p></p>
            <p class="mb-1">生日：{{birthday}}</p>
            <p class="mb-1">位置：{{player.position_1}} <span v-if="player.position_2!=null">/ {{player.position_2}}
            </span></p>
            <p class="mb-1" v-for="office in offices" :key="office.office_id">
              <span v-if="office.office_id==player.office">{{type=='ngc'?office.office_name:"省体育局注册球员"}}</span>
            </p>
            <p v-if="type=='cba'">
              <el-tag v-if="this.player.tags.length!=0" :type="this.player.tags[0].type" size="small">{{this.player.tags[0].msg}}</el-tag>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import moment from "moment";
import PlayerUpdate from "./player-update";

export default {
  name: "player-card",
  components: { PlayerUpdate },
  data(){
    return{
      img:null,
      birthday:null,
      time:null,
      offices:[],
      dialogFormVisible:false
    }
  },
  props:{
    user:JSON,
    player:JSON,
    type:String
  },
  created() {
    this.img = "http://sportsdata.misports.cn/cctv5/cbaplayer/" + this.player.player_id + ".png";
    let date = new Date(this.player.contract_time);
    let birthday = new Date(this.player.birthday);
    this.time = moment(date).format("YYYY-MM-DD");
    this.birthday = moment(birthday).format("YYYY年MM月DD日");
    let param = new URLSearchParams();
    param.append("office",this.user.office)
    this.axios.post("http://localhost:8086/admin/searchOfficeListByOffice",param).then(
      (res)=>{
        this.offices = res.data;
      }
    )
  }
};
</script>

<style scoped>

</style>