<template>
<div>
  <div class="container-fluid">
    <div class="authentication-card">
      <div class="card shadow rounded-0 overflow-hidden">
        <div class="row g-0">
          <div class="col-lg-6 d-flex align-items-center justify-content-center border-end">
            <img src="../assets/images/error/forgot-password-frent-img.jpg" class="img-fluid" alt="">
          </div>
          <div class="col-lg-6">
            <div class="card-body p-4 p-sm-5">
              <h5 class="card-title">修改密码</h5>
                <div class="row g-3">
                  <div class="col-12">
                    <label class="form-label" style="padding-top: 20px">请输入新密码</label>
                    <div class="ms-auto position-relative">
                      <div class="position-absolute top-50 translate-middle-y search-icon px-3"><i class="bi bi-lock-fill"></i></div>
                      <input type="password" class="form-control radius-30 ps-5" id="inputNewPassword" placeholder="New Password" v-model="user.passwd1">
                    </div>
                  </div>
                  <br/>
                  <div class="col-12">
                    <label class="form-label">请再次输入新密码</label>
                    <div class="ms-auto position-relative">
                      <div class="position-absolute top-50 translate-middle-y search-icon px-3"><i class="bi bi-lock-fill"></i></div>
                      <input type="password" class="form-control radius-30 ps-5" id="inputConfirmPassword" placeholder="Confirm Password" v-model="user.passwd2">
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="d-grid gap-3">
                      <input type="button" @click="sub" value="修改密码" class="btn btn-primary radius-30">
                      <router-link to="/" class="btn btn-light radius-30">返回登录</router-link>
                    </div>
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
  name: "Update",
  data(){
    return{
      user:{
        id:null,
        passwd1:undefined,
        passwd2:undefined
      }
    }
  },
  methods:{
    sub:function(){
      if(this.user.passwd1==undefined||this.user.passwd2==undefined||this.user.passwd1==""||this.user.passwd2==""){
        this.$message({
          message:'密码不能为空',
          type:'error',
          duration:3000
        })
      }
      else if (this.user.passwd1!=this.user.passwd2){
        this.$message({
          message:'两次输入密码不一致，请重新输入！',
          type:'error',
          duration:3000
        })
      }
      else{
        let param = new URLSearchParams();
        param.append("id",this.user.id);
        param.append("password",this.user.passwd1);
        this.axios.post("http://localhost:8086/admin/pwdUpdate",param).then(
          (res) => {
            if (res.data){
              this.$message({
                message:'密码修改成功',
                type:'success',
                duration:3000
              })
              this.$router.push({ name: "admin", params: { id: this.user.id } });
            }else {
              this.$message({
                message:'密码修改失败',
                type:'error',
                duration:3000
              })
            }
          }
        )
      }
    }
  },
  created() {
    this.user.id = this.$route.params.id;
    if (this.user.id==null){
      alert("您未进行登录！");
      this.$router.push({name:"login"});
    }
  }
}
</script>

<style scoped>
  @import "../assets/css/bootstrap.min.css";
  @import "../assets/css/bootstrap-extended.css";
  @import "../assets/css/style.css";
  @import "../assets/css/icons.css";
  @import "https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap";
  @import "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css";
  @import "../assets/css/pace.min.css";
  p{
    display: inline;
  }
</style>