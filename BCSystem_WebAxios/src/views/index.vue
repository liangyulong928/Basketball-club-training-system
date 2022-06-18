<template>
  <div>
    <div>
      <nav class="navbar navbar-expand-lg navbar-light bg-white rounded-0 border-bottom">
        <div class="container">
          <img src="../assets/images/logo-brand-1.webp" width="100"/>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mb-2 mb-lg-0 align-items-center"></ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0"></ul>
            <div class="d-flex ms-3 gap-3">
              <router-link to="/login" class="btn btn-sm btn-white px-4 radius-30" active-class="btn-primary">登录</router-link>
              <router-link to="/show" class="btn btn-sm btn-white px-4 radius-30" active-class="btn-primary">注册</router-link>
            </div>
          </div>
        </div>
      </nav>
    </div>
    <router-view/>
  </div>

</template>

<script>
  export default {
    name: "index.vue",
    data(){
      return{
       loginStyle:"btn-primary",
       signupStyle:"btn-white"
      }
    },
    created() {
      this.$router.push("/login");
    },
    methods: {}
  };
</script>

<style scoped>

</style>