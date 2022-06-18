<template>
  <div class="row g-3">
    <div class="col-4">
      <label class="form-label">选择训练类型</label>
      <el-select v-model="plan.type" style="width: 100%">
        <el-option value="1" label="比赛">比赛</el-option>
        <el-option value="2" label="训练">训练</el-option>
      </el-select>
    </div>
    <div class="col-4">
      <label class="form-label">日期</label>
      <el-date-picker
        style="width: 100%"
        v-model="plan.time"
        type="datetime"
        placeholder="选择日期时间">
      </el-date-picker>
    </div>
    <div class="col-4">
      <label class="form-label">记录员</label>
      <el-select v-model="plan.registrar" style="width: 100%">
        <el-option v-for="item in planList.registrar" :key="item.id" :value="item.id" :label="item.name">{{item.name}}</el-option>
      </el-select>
    </div>
    <div class="col-12">
      <label class="form-label">参训队员</label>
      <div>
        <el-checkbox-group v-model="plan.player" size="small">
          <el-checkbox-button v-for="item in planList.playerList" :key="item.id" :label="item.id">{{item.name}}</el-checkbox-button>
        </el-checkbox-group>
      </div>
    </div>
    <div class="col-12">
      <el-button type="success" @click="setNewPlan" plain>保存</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "new-plan",
  data(){
    return{
      planList:[],
      plan:{
        type:"",
        time:"",
        office:this.user.office,
        registrar:"",
        player:[]
      }
    }
  },
  props:{
    user:JSON
  },
  created() {
    this.axios.get("http://localhost:8086/admin/getRegistrarList",{params:{
      office:this.user.office }}).then(
      (res)=>{
        this.planList = res.data
      }
    )
  },
  methods:{
    setNewPlan(){
      let date = new Date();
      let low_date = new Date();
      let high_date = new Date();
      low_date.setDate(date.getDate() + 1);
      high_date.setDate(date.getDate() + 90);
      if (this.plan.player.length==0||this.plan.registrar==""||this.plan.type==""||this.plan.time==""){
        this.$message({
          message:'请完整填写信息',
          type:'error',
          duration:3000
        })
      }
      else if (this.plan.time <= date){
        this.$message({
          message:'时间已经过期，无法创建训练',
          type:'error',
          duration:3000
        })
      }
      else if (this.plan.time <= low_date){
        this.$message({
          message:'不可创建1天以内的训练',
          type:'error',
          duration:3000
        })
      }
      else if (this.plan.time >= high_date){
        this.$message({
          message:'创建训练时间必须在90天以内',
          type:'error',
          duration:3000
        })
      }
      else{
        let param = new URLSearchParams();
        param.append("plan",JSON.stringify(this.plan));
        this.axios.post("http://localhost:8086/game/setNewTrain",param).then(
          (res)=>{
            if (res.data==1){
              this.$message({
                message:'保存成功',
                type:'success',
                duration:3000
              })
            }
          }
        )
      }
      }
  }
};
</script>

<style scoped>

</style>