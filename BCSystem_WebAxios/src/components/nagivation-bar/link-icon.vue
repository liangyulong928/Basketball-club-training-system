<template>
  <router-link active-class="rounter-link-active" :to="{name:this.icon.rounter,params:{user:this.user}}">
    <div class="parent-icon"><i v-bind:class="icon.icon"></i></div>
    <div class="menu-title">{{ icon.func_name }}</div>
  </router-link>
</template>

<script>
export default {
  name: "link-icon",
  props:{
    icon:JSON,
    user:JSON
  }
};
</script>

<style scoped>
  .rounter-link-active{
    background-color: rgb(255 255 255);
    border-left: 4px solid #3461ff;
    box-shadow: 0 0.125rem 0.25rem rgb(0 0 0 / 8%);
  }
  .rounter-link-active .parent-icon{
    color: #3461ff;
    text-decoration: none;
  }
  .rounter-link-active .menu-title{
    color: #3461ff;
    text-decoration: none;
  }
</style>