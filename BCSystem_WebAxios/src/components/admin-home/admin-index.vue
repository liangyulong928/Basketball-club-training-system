<template>
  <div class="col-12 col-lg-12 col-xl-4 d-flex">
    <div class="card radius-10 w-100">
      <div class="card-body">
        <div class="d-flex align-items-center">
          <h6 class="mb-0">个人中心</h6>
        </div>
          <div class="profile-avatar text-center">
            <img src="https://img.alicdn.com/imgextra/i3/O1CN01X5wCJo1y5PnqZmij7_!!6000000006527-1-tps-144-144.gif" width="120" height="120" alt="">
          </div>
          <div class="text-center mt-4">
            <h4 class="mb-1">{{user.name}}</h4>
            <div class="mt-4"></div>
            <h6 class="mb-1">{{office}} - {{actor}}</h6>
            <p class="mb-0 text-secondary">{{user.phone}}</p>
          </div>
        </div>
        <ul class="list-group list-group-flush">
          <notice-ul v-for="notice in notices" v-bind:user="user" v-bind:notice="notice" :key="notice.type"></notice-ul>
        </ul>
    </div>
  </div>
</template>

<script>
import NoticeUl from "./notice-tip/notice-ul";
export default {
  name: "admin-index",
  components: { NoticeUl },
  data(){
    return{
      actor:null,
      office:null
    }
  },
  props:{
    user:JSON,
    notices:Array
  },
  created() {
    let param = new URLSearchParams();
    param.append("id",this.user.id);
    this.axios.post("http://localhost:8086/admin/searchActorNameById",param).then(
      (res)=>{
        this.actor = res.data;
      }
    );
    this.axios.post("http://localhost:8086/admin/searchOfficeNameById",param).then(
      (res)=>{
        this.office = res.data;
      }
    );
  }
};
</script>

<style scoped>

</style>