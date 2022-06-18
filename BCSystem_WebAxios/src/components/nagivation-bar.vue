<template>
  <div>
    <div class="sidebar-header">
      <div>
        <img src="../assets/images/logo-brand-1.webp" class="logo-icon" alt="logo icon">
      </div>
      <div>
        <h4 class="logo-text">辽宁沈阳<br/>三生飞豹俱乐部</h4>
      </div>
    </div>
    <!--navigation-->
    <ul class="metismenu" id="menu">
      <li><link-icon v-bind:icon="icon" v-bind:user="user" v-for="icon in linkIcons" :key="icon.name"/></li>
    </ul>
  </div>
</template>

<script>
import LinkIcon from "./nagivation-bar/link-icon";
export default {
  name: "nagivation-bar",
  components: { LinkIcon },
  props:{
    linkIcons:Array,
    user:JSON
  }
};
</script>
<style scoped>

</style>