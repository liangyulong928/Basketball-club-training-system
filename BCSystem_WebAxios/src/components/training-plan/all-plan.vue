<template>
  <div>
    <div class="row">
      <div class="col-sm-12">
        <table id="example" class="table table-striped table-bordered dataTable" style="width: 100%;" role="grid" aria-describedby="example_info">
          <thead>
          <tr role="row">
            <th class="sorting_asc">训练时间</th>
            <th class="sorting">记录员</th>
            <th class="sorting">操作</th>
          </tr>
          </thead>
          <tbody v-for="plan_data in planData" :key="plan_data.game_id">
            <plan-tr v-if="plan_data.office==user.office" v-bind:user="user" v-bind:plan_data="plan_data"/>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import PlanTr from "./plan-tr";
export default {
  name: "all-plan",
  components: { PlanTr },
  props:{
    user:JSON,
    planData:Array
  }
};
</script>

<style scoped>

</style>