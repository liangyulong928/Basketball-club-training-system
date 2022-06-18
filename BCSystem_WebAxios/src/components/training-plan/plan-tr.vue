<template>
  <tr role="row">
    <td>
      <el-date-picker
        v-model="plan_data.time"
        type="datetime"
        placeholder="选择日期时间">
      </el-date-picker>
    </td>
    <td>
      <el-select v-model="plan_data.registrar" style="width: 100%">
        <el-option v-for="item in planList.registrar" :key="item.id" :value="item.id" :label="item.name">{{item.name}}</el-option>
      </el-select>
    </td>
    <td>
      <a @click="editPlan" class="text-warning" data-bs-toggle="tooltip" data-bs-placement="bottom" data-bs-original-title="Edit" aria-label="Edit">
        <i style="cursor:pointer" class="bi bi-pencil-fill"></i>
      </a>
      <a @click="deletePlan" class="text-danger" data-bs-toggle="tooltip" data-bs-placement="bottom" title="" data-bs-original-title="Delete" aria-label="Delete">
        <i style="cursor:pointer" class="bi bi-trash-fill"></i>
      </a>
    </td>
  </tr>
</template>

<script>
export default {
  name: "plan-tr",
  data(){
    return{
      time:null,
      planList:null
    }
  },
  props:{
    plan_data:JSON,
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
    editPlan(){
      alert("编辑")
    },
    deletePlan(){
      this.axios.get("http://localhost:8086/game/deletePlan",{params:{game_id:this.plan_data.game_id}}).then(
        (res)=>{
          if (res.data==1){
            this.$message({
              message:'已完成删除',
              type:'success',
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
  i{
    margin:10px;
    padding-top: 10px;
  }
</style>