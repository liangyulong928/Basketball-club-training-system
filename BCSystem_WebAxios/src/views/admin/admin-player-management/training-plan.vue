<template>
  <div>
    <el-button type="primary" @click="dialogFormVisible1=true" plain>新增代办</el-button>
    <el-dialog title="新增代办" :visible.sync="dialogFormVisible1">
      <new-plan v-bind:user="user"></new-plan>
    </el-dialog>
    &nbsp;&nbsp;
    <el-button type="success" @click="dialogFormVisible2=true" plain>查看代办</el-button>
    <el-dialog title="查看代办" :visible.sync="dialogFormVisible2">
      <all-plan v-bind:planData="planData" v-bind:user="user"></all-plan>
    </el-dialog>
    <p></p>
    <div class="card">
      <div class="card-body">
        <el-calendar v-model="value">
          <template slot="dateCell" slot-scope="{date, data}">
            {{data.day.split('-').slice(1)[1]}}
            <div v-for="(item,index) in calendarData" :key="index">
              <div v-if="item.months==data.day.split('-').slice(1)[0]">
                <div v-if="item.days==data.day.split('-').slice(2).join('-')">
                  <el-tag :type="item.status" size="mini">{{item.things}}</el-tag>
                </div>
              </div>
            </div>
          </template>
        </el-calendar>
      </div>
    </div>
  </div>
</template>

<script>
import NewPlan from "../../../components/training-plan/new-plan";
import AllPlan from "../../../components/training-plan/all-plan";
import moment from "moment";
export default {
  name: "training-plan",
  components: { AllPlan, NewPlan },
  data() {
    return {
      dialogFormVisible2:null,
      dialogFormVisible1:null,
      user: null,
      value: new Date(),
      planData:[],
      calendarData: [
      ]
    };
  },
  created() {
    this.user = this.$route.params.user;
    this.axios.get("http://localhost:8086/game/getAllPlan",{params:{
      office:this.user.office
      }}).then(
      (res)=>{
        this.planData = res.data;
        res.data.forEach(
          (item)=>{
            var momentObjectOutput = moment(item.time).toObject();
            var time = moment(item.time).format("HH:mm")
            var things = "";
            var status = "";
            if (item.office==this.user.office){
              if (item.type==1){
                things = "比赛时间："+ time + "\n记录员：" + item.registrar_name;
                status = "danger"
              }
              else {
                things = "训练时间："+ time + "\n记录员：" + item.registrar_name;
                status = "warning"
              }
            }
            else{
              status = "info"
              if (item.type==1){
                things =  item.office_name +"比赛\n比赛时间："+ time;
              }
              else {
                things =  item.office_name +"训练\n训练时间："+ time;
              }
            }
            let jsonObject = {months:momentObjectOutput.months+1,days:momentObjectOutput.date,things:things,status:status}
            this.calendarData.push(jsonObject);
          }
        )
      }
    )
  }
};
</script>

<style scoped>
  .el-tag{
    white-space: normal;
    height:auto;
  }
</style>
