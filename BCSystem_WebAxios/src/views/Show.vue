<template>
  <div class="container-fluid">
    <div class="authentication-card">
      <div class="card shadow rounded-0 overflow-hidden">
        <div class="row g-0">
          <div class="col-lg-6 bg-light-info d-flex align-items-center justify-content-center">
            <img src="../assets/images/error/auth-img-register3.png" class="img-fluid" alt="">
          </div>
          <div class="col-lg-6">
            <div class="card-body p-4 p-sm-5">
              <h5 class="card-title">注册</h5>
              <p class="card-text">欢迎加入辽宁沈阳三生飞豹俱乐部！</p>
                <div class="login-separater text-center mb-4"> <span>使用手机号进行注册</span>
                  <hr>
                </div>
                <div class="row g-3">
                  <div class="col-12">
                    <label class="form-label">姓名</label>
                    <div class="ms-auto position-relative">
                      <div class="position-absolute top-50 translate-middle-y search-icon px-3"><i class="bi bi-person-circle"></i></div>
                      <input type="text" class="form-control radius-30 ps-5" id="inputName" placeholder="姓名" v-model="name">
                    </div>
                  </div>
                  <div class="col-12">
                    <label class="form-label">手机号</label>
                    <div class="ms-auto position-relative">
                      <div class="position-absolute top-50 translate-middle-y search-icon px-3"><i class="lni lni-phone"></i></div>
                      <input type="text" class="form-control radius-30 ps-5" id="inputEmailAddress" placeholder="手机号" v-model="phone">
                    </div>
                  </div>
                  <div class="col-12">
                    <label class="form-label">选择所属单位</label>
                    <div class="ms-auto position-relative">
                      <div class="position-absolute top-50 translate-middle-y search-icon px-3"><i class="lni lni-phone"></i></div>
                      <div class="form-control radius-30 ps-5">
                        <el-select filterable v-model="select_office" placeholder="请选择所属单位" style="width: 100%">
                          <el-option v-for="office in offices" :label="office.office_name" :value="office.office_id" :key="office.office_id">
                            <span>{{office.office_name}}</span>
                          </el-option>
                        </el-select>
                      </div>
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="d-grid">
                      <button type="submit" class="btn btn-primary radius-30" @click="signup">注册</button>
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
  name: "show",
  data(){
    return{
      name:undefined,
      phone:undefined,
      select_office:null,
      offices:null
    }
  },
  created() {
    this.axios.post("http://localhost:8086/admin/getOfficeList").then(
      (res)=>{
        this.offices = res.data;
      }
    )
  },
  methods:{
    signup:function(){
      if (this.name==undefined||this.name==""||this.phone==undefined||this.phone==""||this.select_office==null){
        this.$message({
          message:'请完整填写信息',
          type:'error',
          duration:3000
        })
      }
      else {
        let param = new URLSearchParams();
        param.append("name",this.name);
        param.append("phone",this.phone);
        param.append("office",this.select_office);
        this.axios.post("http://localhost:8086/admin/signup",param).then(
          (res)=>{
            if(res.data){
              alert("已上传用户申请，待管理员验证后，会对您进行短信通知。")
              this.$router.push("/login");
            }
            else {
              this.$message({
                message:'申请失败，请稍后重试',
                type:'error',
                duration:3000
              })
            }
          }
        )
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