<template>
  <li class="nav-item dropdown dropdown-user-setting">
    <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" href="#" data-bs-toggle="dropdown">
      <div class="user-setting d-flex align-items-center">
        <img src="https://img.alicdn.com/imgextra/i3/O1CN01X5wCJo1y5PnqZmij7_!!6000000006527-1-tps-144-144.gif" class="user-img">
      </div>
    </a>
    <ul class="dropdown-menu dropdown-menu-end">
      <li>
        <a class="dropdown-item" href="#">
          <div class="d-flex align-items-center">
            <img src="https://img.alicdn.com/imgextra/i3/O1CN01X5wCJo1y5PnqZmij7_!!6000000006527-1-tps-144-144.gif" alt="" class="rounded-circle" width="54" height="54">
            <div class="ms-3">
              <h6 class="mb-0 dropdown-user-name">{{user.name}}</h6>
            </div>
          </div>
        </a>
      </li>
      <li><hr class="dropdown-divider"></li>
      <li>
        <router-link class="dropdown-item" :to="{name:this.admin,params:{user:this.user}}">
          <div class="d-flex align-items-center">
            <div class=""><i class="bi bi-person-fill"></i></div>
            <div class="ms-3"><span>个人中心</span></div>
          </div>
        </router-link>
      </li>
      <li>
        <button class="dropdown-item" @click="updatePassword">
          <div class="d-flex align-items-center">
            <div class=""><i class="bx bx-key"></i></div>
            <div class="ms-3"><span>修改密码</span></div>
          </div>
        </button>
      </li>
      <li><hr class="dropdown-divider"></li>
      <li>
        <router-link to="/login" class="dropdown-item">
          <div class="d-flex align-items-center">
            <div class=""><i class="bi bi-lock-fill"></i></div>
            <div class="ms-3"><span>注销</span></div>
          </div>
        </router-link>
      </li>
    </ul>
  </li>
</template>

<script>
export default {
  name: "user-message",
  data(){
    return{
      admin:"admin-home",
    }
  },
  props:{
    user:JSON
  },
  methods:{
    updatePassword:function(){
      this.$prompt('该操作有一定风险，请输入密码确认操作',"警告",{
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPlaceholder:'请输入密码',
        inputType:"password"
      }).then(
        ({ value })=>{
          let param = new URLSearchParams();
          param.append("id",this.user.phone);
          param.append("password",value);
          this.axios.post("http://localhost:8086/admin/login",param).then(
            (res)=>{
              if (res.data.keywordType==1&&res.data.status==1){
                this.$message({
                  message:'密码输入正确',
                  type:'success',
                  duration:3000
                });
                this.$router.push({ name: "update", params: { id: this.user.id } })
              }
              else {
                this.$message({
                  message:'密码输入错误',
                  type:'error',
                  duration:3000
                })
              }
            }
          )
        }
      )
    }
  }
};
</script>

<style scoped>

</style>