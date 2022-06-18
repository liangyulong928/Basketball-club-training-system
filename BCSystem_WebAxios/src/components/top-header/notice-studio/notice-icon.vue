<template>
  <router-link class="dropdown-item" :to="{name:notice.rounter}">
    <div class="d-flex align-items-center">
      <div class="notification-box bg-light-primary text-primary"><i class="bi bi-basket2-fill"></i></div>
      <div class="ms-3 flex-grow-1">
        <h6 class="mb-0 dropdown-msg-user">{{ notice.type }}</h6>
        <small class="mb-0 dropdown-msg-text text-secondary d-flex align-items-center">
          {{notice.name}}等{{notice.count}}人于{{time}}申请
        </small>
      </div>
    </div>
  </router-link>
</template>

<script>
import moment from "moment";

export default {
  name: "notice-icon",
  data(){
    return{
      time:null
    }
  },
  props:{
    notice:JSON
  },
  created() {
    let date = new Date(this.notice.apply_time);
    this.time = moment(date).format("yyyy年MM月DD日");
  }
};
</script>

<style scoped>

</style>