<template>
<div class="wrapper">
  <el-container>
    <el-header class="top-header">
      <TopHeader v-bind:user="user" v-bind:notices="notices"></TopHeader>
    </el-header>
    <el-container>
      <el-aside class="sidebar-wrapper" width="260px">
        <nagivation-bar v-bind:linkIcons="linkIcons" v-bind:user="user"></nagivation-bar>
      </el-aside>
      <el-main class="page-content">
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</div>
</template>

<script>
import TopHeader from "../../components/top-header";
import NagivationBar from "../../components/nagivation-bar";
export default {
  name: "admin-index",
  components: { NagivationBar, TopHeader },
  data(){
    return{
      user:null,
      linkIcons:null,
      notices:null
    }
  },
  created() {
    let id = this.$route.params.id;
    if(id==null){
      alert("您未进行登录!");
      this.$router.push({name:"index"});
    }
    else {
      let param = new URLSearchParams();
      param.append("id",id);
      this.axios.post("http://localhost:8086/actor-function/getFunctionListById",param).then(
        (res)=>{
          this.linkIcons = res.data;
        }
      );
      this.axios.post("http://localhost:8086/admin/getAdmin",param).then(
        (res)=>{
          this.user = res.data;
          this.$router.push({name:"admin-home",params:{user:this.user}});
        }
      );
    }
  }
};
</script>

<style scoped>

</style>