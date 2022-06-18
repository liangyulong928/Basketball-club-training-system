<template>
  <div class="row g-3">
    <div class="col-6">
      <label class="form-label">选择球员类型</label>
      <el-select v-model="checkItem" style="width: 100%">
        <el-option value="2" label="省体育局注册球员">省体育局注册球员</el-option>
        <el-option v-if="user.office==2" value="1" label="联赛球员">联赛球员</el-option>
        <el-option v-else disabled label="联赛球员">联赛球员</el-option>
      </el-select>
    </div>
    <div class="col-6" v-if="checkItem==1">
      <label class="form-label">联盟注册球员号</label>
      <input type="text" class="form-control" v-model="player.player_id">
    </div>
    <div class="col-md-6" v-if="checkItem==2">
      <label class="form-label">选择球员注册单位</label>
      <el-select v-model="player.office" placeholder="请选择" style="width: 100%">
        <el-option
          v-for="office in offices"
          :key="office.office_id"
          :label="office.office_name"
          :value="office.office_id">
        </el-option>
      </el-select>
    </div>
    <div class="col-6">
      <label class="form-label">姓名</label>
      <input type="text" class="form-control" v-model="player.name">
    </div>
    <div class="col-6">
      <label class="form-label">出生日期</label>
      <el-date-picker
        v-model="player.birthday"
        style="width: 100%;"
        type="date"
        placeholder="选择日期">
      </el-date-picker>
    </div>
    <div class="col-6">
      <label class="form-label">手机号</label>
      <input type="text" class="form-control" v-model="player.phone">
    </div>
    <div class="col-6" v-if="checkItem==1">
      <label class="form-label">合同时长</label>
      <el-date-picker
        v-model="player.contract_time"
        style="width: 100%;"
        type="date"
        placeholder="选择日期">
      </el-date-picker>
    </div>
    <div class="col-12">
      <el-button type="primary" plain @click="addPlayer">新增</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "new_player",
  data(){
    return{
      checkItem:null,
      offices:[],
      player:{}
    }
  },
  props:{
    user:JSON
  },
  created() {
    let param = new URLSearchParams();
    param.append("office",this.user.office)
    this.axios.post("http://localhost:8086/admin/searchOfficeListByOffice",param).then(
      (res)=>{
        this.offices = res.data;
      }
    )
  },
  methods:{
    addPlayer(){
      let param = new URLSearchParams();
      param.append("playerString",JSON.stringify(this.player));
      this.axios.post("http://localhost:8086/player-management/addPlayer",param).then(
        (res)=>{
          if (res.data==1){
            this.$message({
              message:'保存成功',
              type:'success',
              duration:3000
            })
          }
          else {
            this.$message({
              message:'操作失败',
              type:'error',
              duration:3000
            })
          }
        }
      )
    }
  }
};
</script>

<style scoped>

</style>