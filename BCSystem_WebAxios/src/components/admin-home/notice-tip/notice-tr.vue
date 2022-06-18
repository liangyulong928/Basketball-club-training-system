<template>
  <tr v-if="notice.count!=0">
    <td>{{notice.type}}</td>
    <td>
      {{notice.name}}<span v-if="notice.count!=1">等{{notice.count}}人</span>
    </td>
    <td>{{time}}</td>
    <td>
      <div class="d-flex align-items-center gap-3 fs-6">
        <router-link class="text-warning" :to="{name:notice.rounter,params:{user:this.user}}">
          <el-tooltip class="item" effect="light" content="操作" placement="bottom">
            <i class="bi bi-pencil-fill"></i>
          </el-tooltip>
        </router-link>
      </div>
    </td>
  </tr>
</template>

<script>
import moment from "moment"
export default {
  name: "notice-tr",
  props:{
    notice:JSON,
    user:JSON
  },
  data(){
    return{
      time:null
    }
  },
  created() {
    let date = new Date(this.notice.apply_time);
    this.time = moment(date).format("YYYY-HH-DD hh:mm");
  }
};
</script>

<style scoped>

</style>