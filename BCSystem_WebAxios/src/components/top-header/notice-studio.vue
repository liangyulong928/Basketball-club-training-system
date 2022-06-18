<template>
  <li class="nav-item dropdown dropdown-large">
    <a href="#" class="nav-link dropdown-toggle dropdown-toggle-nocaret" data-bs-toggle="dropdown">
      <div class="notifications">
        <span class="notify-badge">{{notices.length}}</span>
        <i class="bi bi-bell-fill"></i>
      </div>
    </a>
<!--    <div class="dropdown-menu dropdown-menu-end p-0">-->
<!--      <div class="p-2 border-bottom m-2">-->
<!--        <h5 class="h5 mb-0">通知中心</h5>-->
<!--      </div>-->
<!--      <div class="header-notifications-list p-2">-->
<!--        <notice-icon v-for="notice in notices" v-bind:notice="notice" :key="notice.type"></notice-icon>-->
<!--      </div>-->
<!--    </div>-->
  </li>
</template>

<script>
// import NoticeIcon from "./notice-studio/notice-icon";
export default {
  name: "notice-studio",
  // components: { NoticeIcon },
  props:{
    user:JSON,
    notices:JSON
  },
  created() {
    console.log(this.notices)
  }
}
</script>

<style scoped>

</style>