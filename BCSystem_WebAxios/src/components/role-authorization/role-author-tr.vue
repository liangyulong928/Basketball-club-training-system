<template>
  <tr>
    <td>{{ role.name }}</td>
    <td>
      <el-tag v-if="role.office_name=='辽宁沈阳三生飞豹俱乐部'" type="success" size="mini">{{ role.office_name }}</el-tag>
      <el-tag v-else-if="role.office_name=='俱乐部青训队'" size="mini">{{ role.office_name }}</el-tag>
      <el-tag v-else type="info" size="mini">{{ role.office_name }}</el-tag>
    </td>
    <td>{{ role.phone }}</td>
    <td>
      <select v-if="role.actor==null" v-model="value" class="badge rounded-pill alert-danger">
        <option :value="null" selected="selected">未配置</option>
        <option
          v-for="actor in actors"
          :key="actor.id"
          :label="actor.name"
          :value="actor">
        </option>
      </select>
      <div v-else>
        <span class="badge rounded-pill alert-success" v-for="actor in actors" :key="actor.id">
          <div v-if="actor.id==role.actor">{{actor.name}}</div>
        </span>
      </div>
    </td>
    <td v-if="role.status==1">
      <span class="badge bg-light-success text-success w-50">已授权</span>
    </td>
    <td v-else>
      <span class="badge bg-light-danger text-danger w-50">未授权</span>
    </td>
    <td v-if="role.status==1">
      <el-link type="primary" @click="workPlaceOut">职位调动</el-link>
      <el-dialog :visible.sync="dialogFormVisible">
          <h2 class="product-title" style="font-size: large">即将调出<span style="font-weight: bold;color: #e54d4d">{{role.name}}</span>用户</h2>
          <br/>
          <el-select v-model="select_office" class="col-md-4" placeholder="请选择调出单位">
            <el-option
              v-for="office in offices"
              :key="office.office_id"
              :label="office.office_name"
              :value="office.office_id">
            </el-option>
          </el-select>
          &nbsp;
          <el-select v-model="new_actor" class="col-md-4" placeholder="请选择调动职位">
            <el-option
              v-for="actor in actors"
              :key="actor.id"
              :label="actor.name"
              :value="actor.id">
            </el-option>
          </el-select>
          <div class="actions d-flex align-items-center justify-content-end gap-2 mt-3">
            <a class="btn btn-sm btn-outline-primary" @click="postOut"><i class="bi bi-pencil-fill"></i> 调动</a>
            <a class="btn btn-sm btn-outline-danger" @click="deleteUser"><i class="bi bi-trash-fill"></i> 解聘</a>
          </div>
      </el-dialog>
    </td>
    <td v-else>
      <el-link type="success" @click="adminAccept">授权</el-link>
      &nbsp;&nbsp;
      <el-link type="danger" @click="adminConfuse">驳回</el-link>
    </td>
  </tr>
</template>

<script>

export default {
  name: "role-author-tr",
  data(){
    return{
      new_actor:null,
      value:null,
      select_office:null,
      offices:[],
      dialogFormVisible:false
    }
  },
  props:{
    role:JSON,
    actors:Array,
    user:JSON
  },
  methods:{
    deleteUser(){
      this.$confirm('此操作将彻底解除该用户', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'error'
      }).then(() => {
        let param = new URLSearchParams();
        param.append("id",this.role.id);
        this.axios.post("http://localhost:8086/admin/deleteUser",param).then(
          (res)=>{
            if (res.data==1){
              this.$message({
                message:'已完成解聘操作',
                type:'success',
                duration:3000
              })
              this.dialogFormVisible = false
            }else {
              this.$message({
                message:'操作失败，请稍后重试',
                type:'error',
                duration:3000
              })
            }
          }
        )
      }).catch(() => {
        this.$message({
          message:'已取消',
          type:'error',
          duration:3000
        })
        this.dialogFormVisible = false;
      });
    },
    postOut(){
      if (this.select_office==null){
        this.$message({
          message:'请选择调出单位',
          type:'error',
          duration:3000
        })
      }
      else if (this.new_actor==null){
        this.$message({
          message:'请选择新就职职位',
          type:'error',
          duration:3000
        })
      }
      else {
        let param = new URLSearchParams();
        param.append("id",this.role.id);
        param.append("office",this.select_office);
        param.append("actor",this.new_actor);
        this.axios.post("http://localhost:8086/admin/postOut",param).then(
          (res)=>{
            if (res.data==1){
              this.$message({
                message:'已完成调动',
                type:'success',
                duration:3000
              })
              this.dialogFormVisible = false;
            }
            else {
              this.$message({
                message:'操作失败，请稍后重试',
                type:'error',
                duration:3000
              })
            }
          }
        )
      }
    },
    workPlaceOut(){
      this.dialogFormVisible = true
      let param = new URLSearchParams();
      param.append("office",this.user.office)
      this.axios.post("http://localhost:8086/admin/searchOfficeListByOffice",param).then(
        (res)=>{
          this.offices = res.data;
        }
      )
    },
    adminAccept:function(){
      if (this.value==null){
        this.$message({
          message:'请为用户配置职位',
          type:'error',
          duration:3000
        })
      }
      else {
        let message = "即将为"+this.role.name+"用户授予"+this.role.office_name+this.value.name+"职位，是否继续？";
        this.$confirm(message, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let param = new URLSearchParams();
          param.append("id",this.role.id);
          param.append("actor",this.value.id);
          this.axios.post("http://localhost:8086/role-author/accept",param).then(
            (res)=>{
              if (res.data){
                this.$message({
                  message:'授权成功',
                  type:'success',
                  duration:3000
                });
              }
              else {
                this.$message({
                  message:'授权失败',
                  type:'error',
                  duration:3000
                })
              }
            }
          )
        });
      }
    },
    adminConfuse:function(){
      let message = "即将驳回"+this.role.name+"用户申请，是否继续？";
      this.$confirm(message, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let param = new URLSearchParams();
        param.append("id",this.role.id);
        this.axios.post("http://localhost:8086/role-author/confuse",param).then(
          (res)=>{
            if (res.data){
              this.$message({
                message:'操作成功，已驳回申请',
                type:'success',
                duration:3000
              });
            }
            else {
              this.$message({
                message:'操作失败',
                type:'error',
                duration:3000
              })
            }
          }
        )
      });
    }
  }
};
</script>

<style scoped>

</style>