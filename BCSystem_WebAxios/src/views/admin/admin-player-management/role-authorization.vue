<template>
  <div>
    <div class="card">
      <div class="card-body">
        <div class="d-flex align-items-center">
          <h5 class="mb-0">用户管理</h5>
          <form class="ms-auto position-relative">
            <div class="position-absolute top-50 translate-middle-y search-icon px-3"><i class="bi bi-search"></i></div>
            <input class="form-control ps-5" type="text" placeholder="通过姓名/手机号搜索" v-model="key_word" @input="keyWordSearch">
          </form>
        </div>
        <div class="table-responsive mt-3">
          <table class="table align-middle mb-0">
            <thead class="table-light">
              <tr>
                <th>姓名</th>
                <th>
                  <el-dropdown @command="officeSearch">
                    <span class="el-dropdown-link">
                      所属单位<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                      <el-dropdown-item command="all" v-model="office_search_key"><span style="color: red">显示所有</span></el-dropdown-item>
                      <el-dropdown-item command="辽宁沈阳三生飞豹俱乐部" v-model="office_search_key">辽宁沈阳三生飞豹俱乐部</el-dropdown-item>
                      <el-dropdown-item command="俱乐部青训队" v-model="office_search_key">俱乐部青训队</el-dropdown-item>
                      <el-dropdown-item command="省体育局地方队" v-model="office_search_key">省体育局地方队</el-dropdown-item>
                    </el-dropdown-menu>
                  </el-dropdown>
                </th>
                <th>电话</th>
                <th>
                  <el-dropdown @command="actorSearch">
                    <span class="el-dropdown-link">
                      职位<i class="el-icon-arrow-down el-icon--right"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                      <el-dropdown-item command="all" v-model="value"><span style="color: red">显示所有</span></el-dropdown-item>
                      <el-dropdown-item :command="null" v-model="value">未配置</el-dropdown-item>
                      <el-dropdown-item v-for="actor in actors"
                                        v-bind:actor="actor.id"
                                        :command="actor.id"
                                        :key="actor.id">
                        {{actor.name}}
                      </el-dropdown-item>
                    </el-dropdown-menu>
                  </el-dropdown>
                </th>
                <th>账号状态</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
              <role-author-tr v-for="role in role_active_list" :user="user" v-bind:role="role" :key="role.id" v-bind:actors="actors"></role-author-tr>
              <tr v-if="isShowTip">没有搜索结果</tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import RoleAuthorTr from "../../../components/role-authorization/role-author-tr";
export default {
  name: "role-authorization",
  components: { RoleAuthorTr },
  methods:{
    officeSearch(office_search_key){
      if (office_search_key=="all"){
        this.isShowTip = false;
        this.role_active_list = this.role_list;
        return
      }
      else if(office_search_key == "辽宁沈阳三生飞豹俱乐部"){
        this.role_active_list = [];
        this.isShowTip = false;
        this.role_list.forEach(
          (item)=>{
            if (item.office_name=="辽宁沈阳三生飞豹俱乐部"){
              this.role_active_list.push(item)
            }
          }
        )
        if (this.role_active_list.length==0){
          this.isShowTip = true;
        }
      }
      else if(office_search_key == "俱乐部青训队"){
        this.role_active_list = [];
        this.isShowTip = false;
        this.role_list.forEach(
          (item)=>{
            if (item.office_name=="俱乐部青训队"){
              this.role_active_list.push(item)
            }
          }
        )
        if (this.role_active_list.length==0){
          this.isShowTip = true;
        }
      }
      else {
        this.role_active_list = [];
        this.isShowTip = false;
        this.role_list.forEach(
          (item)=>{
            if (item.office_name!="俱乐部青训队"&&item.office_name!="辽宁沈阳三生飞豹俱乐部"){
              this.role_active_list.push(item)
            }
          }
        )
        if (this.role_active_list.length==0){
          this.isShowTip = true;
        }
      }
    },
    actorSearch(value){
      if (value=="all"){
        this.isShowTip = false;
        this.role_active_list = this.role_list;
        return
      }
      this.actor_search_key = value;
      this.role_active_list = [];
      this.isShowTip = false;
      this.role_list.forEach(
        (item)=>{
          if (item.actor==this.actor_search_key){
            this.role_active_list.push(item)
          }
        }
      )
      if (this.role_active_list.length==0){
        this.isShowTip = true;
      }
    },
    keyWordSearch(){
      if (this.key_word == ""){
        this.role_active_list = this.role_list;
      }
      this.isShowTip = false
      this.role_active_list = []
      this.role_list.forEach(
        (item)=>{
          if (item.name.indexOf(this.key_word)>-1||
            item.phone.indexOf(this.key_word)>-1){
            this.role_active_list.push(item)
          }
        }
      )
      if (this.role_active_list.length==0){
        this.isShowTip = true;
      }
    }
  },
  data(){
    return{
      user:null,
      key_word:"",
      actor_search_key:null,
      office_search_key:null,
      role_list:null,
      role_active_list:[],
      isShowTip:false,
      actors:[
        {
          id:1,
          name:"总经理"
        },
        {
          id:2,
          name:"教练"
        },
        {
          id:3,
          name:"录像分析师"
        },
        {
          id:4,
          name:"队医"
        },
        {
          id:5,
          name:"战术训练师"
        },
        {
          id:6,
          name:"体能训练师"
        },
        {
          id:7,
          name:"球队管理"
        },
        {
          id:8,
          name:"助理教练"
        }
      ]
    }
  },
  created() {
    this.user = this.$route.params.user;
    let param = new URLSearchParams();
    param.append("id",this.user.id)
    this.axios.post("http://localhost:8086/role-author/getRoleList",param).then(
      (res)=>{
        this.role_list = res.data;
        this.role_active_list = this.role_list;
      }
    );
  }
};
</script>

<style scoped>

</style>