<template>
      <nav class="navbar navbar-expand gap-3">
        <div class="top-navbar-right ms-auto">
          <ul class="navbar-nav align-items-center">
            <user-message v-bind:user="user"></user-message>
          </ul>
        </div>
      </nav>
</template>

<script>
import UserMessage from "./top-header/user-message";
export default {
  name: "top-header",
  components: {UserMessage },
  props:{
    user:JSON,
    linkIcons:Array
  }
};
</script>

<style scoped>
  @import "../assets/plugins/vectormap/jquery-jvectormap-2.0.2.css";
  @import "../assets/plugins/simplebar/css/simplebar.css";
  @import "../assets/plugins/perfect-scrollbar/css/perfect-scrollbar.css";
  @import "../assets/plugins/metismenu/css/metisMenu.min.css";
  @import "../assets/css/bootstrap.min.css";
  @import "../assets/css/bootstrap-extended.css";
  @import "../assets/css/style.css";
  @import "../assets/css/icons.css";
  @import "https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap";
  @import "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css";
  @import "../assets/css/pace.min.css";
  @import "../assets/css/dark-theme.css";
  @import "../assets/css/light-theme.css";
  @import "../assets/css/semi-dark.css";
  @import "../assets/css/header-colors.css";
</style>