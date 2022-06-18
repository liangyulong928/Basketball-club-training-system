<template>
  <div class="row">
    <notice-mena v-bind:user="user" v-bind:notices="notices"></notice-mena>
    <admin-index v-bind:user="user" v-bind:notices="notices"></admin-index>
  </div>
</template>

<script>
import NoticeMena from "../../components/admin-home/notice-mena";
import AdminIndex from "../../components/admin-home/admin-index";
export default {
  name: "admin-home",
  components: { AdminIndex, NoticeMena },
  data(){
    return{
      notices:null
    }
  },
  props:{
    user:JSON
  },
  created() {
    this.user = this.$route.params.user;
    let param = new URLSearchParams();
    param.append("id",this.user.id)
    this.axios.post("http://localhost:8086/notice/getNoticeMenuList",param).then(
      (res)=>{
        this.notices = res.data;
      }
    );
  }
};
</script>

<style scoped>

</style>