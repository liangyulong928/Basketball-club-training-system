<template>
  <div>
    <div class="container-fluid">
      <div class="authentication-card">
        <div class="card shadow rounded-0 overflow-hidden">
          <div class="row g-0">
            <div class="col-lg-6 bg-light-info d-flex align-items-center justify-content-center">
              <img src="../assets/images/error/auth-img-7.png" class="img-fluid" alt="">
            </div>
            <div class="col-lg-6">
              <div class="card-body p-4 p-sm-5">
                <h5 class="card-title">球员训练管理平台</h5>
                <p class="card-text" style="margin-bottom: 5px">辽宁沈阳三生飞豹俱乐部</p>
                <div class="login-separater text-center mb-4"> <span>使用手机号进行登录</span>
                  <hr>
                </div>
                  <div class="row g-3">
                    <div class="col-12">
                      <label class="form-label">手机号</label>
                      <div class="ms-auto position-relative">
                        <div class="position-absolute top-50 translate-middle-y search-icon px-3"><i class="lni lni-phone"></i></div>
                        <input type="text" class="form-control radius-30 ps-5" id="inputEmailAddress" placeholder="手机号" v-model="id">
                      </div>
                    </div>
                    <div class="col-12">
                      <label class="form-label">密码</label>
                      <div class="ms-auto position-relative">
                        <div class="position-absolute top-50 translate-middle-y search-icon px-3"><i class="bi bi-lock-fill"></i></div>
                        <input type="password" class="form-control radius-30 ps-5" id="inputChoosePassword" placeholder="密码" v-model="password">
                      </div>
                    </div>
                    <div class="col-6">
                    </div>
                    <div class="col-12">
                      <div class="d-grid">
                        <input type="button" class="btn btn-primary radius-30" value="登录" @click="submit">
                      </div>
                    </div>
                    <div class="col-12">
                      <p class="mb-0">获取账号授权  <router-link to="/show"> 点击这里</router-link></p>
                    </div>
                  </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data(){
    return{
      id:null,
      password:null,
      adminType:null
    }
  },
  methods:{
    submit:function(){
      if(this.id) {
        if (this.password) {
          let params = new URLSearchParams();
          params.append("id", this.id);
          params.append("password", this.password);
          this.axios.post("http://localhost:8086/admin/login",
            params).then(
            (res) => {
              this.adminType = res.data;
              if (this.adminType){
                if (!this.adminType.status){
                  this.$message({
                    message:'管理员未对该用户进行授权，请联系相关管理人员',
                    type:'error',
                    duration:3000
                  })
                }
                else if (this.adminType.keywordType == 0) {
                  this.$message({
                    message:'密码错误，请重新输入',
                    type:'error',
                    duration:3000
                  })
                }
                else if (this.adminType.keywordType == 1) {
                  this.$message({
                    message:'登录成功',
                    type:'success',
                    duration:3000
                  })
                  this.$router.push({ name: "admin", params: { id: this.adminType.adminId } });
                }
                else {
                  alert("密码为初始密码，请进行修改！");
                  this.$router.push({ name: "update", params: { id: this.adminType.adminId } });
                }
              }else{
                alert("账户不存在")
              }
            }
          );
        }
        else {
          alert("请输入密码")
        }
      }
      else {
        alert("id为空")
      }
    }
  }
};
</script>

<style scoped>
  @import "../assets/css/bootstrap.min.css";
  @import "../assets/css/bootstrap-extended.css";
  @import "../assets/css/style.css";
  @import "../assets/css/icons.css";
  @import "https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap";
  @import "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css";
  @import "../assets/css/pace.min.css";
</style>