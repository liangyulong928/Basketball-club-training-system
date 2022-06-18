<template>
    <router-link v-if="notice.count!=0" :to="{name:this.notice.rounter,params:{user:this.user}}" class="list-group-item d-flex justify-content-between align-items-center bg-transparent border-top">
      {{ notice.type }}
      <span class="badge bg-primary rounded-pill">{{ notice.count }}</span>
    </router-link>
</template>

<script>
export default {
  name: "notice-ul",
  props:{
    notice:JSON,
    user:JSON
  }
};
</script>

<style scoped>

</style>