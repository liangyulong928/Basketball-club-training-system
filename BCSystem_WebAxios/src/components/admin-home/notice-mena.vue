<template>
    <div class="col-12 col-lg-12 col-xl-8 d-flex">
      <div class="card radius-10 w-100">
        <div class="card-body">
          <div class="d-flex align-items-center">
            <h6 class="mb-0">通知中心</h6>
          </div>
          <div class="table-responsive mt-2">
            <table class="table align-middle mb-0">
              <thead class="table-light">
              <tr>
                <th>消息类型</th>
                <th>申请人</th>
                <th>申请时间</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
                <notice-tr v-bind:user="user" v-for="notice in notices" v-bind:notice="notice" :key="notice.type"></notice-tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import NoticeTr from "./notice-tip/notice-tr";
export default {
  name: "notice-mena",
  components: { NoticeTr },
  props:{
    user:JSON,
    notices:Array
  }
};
</script>

<style scoped>

</style>