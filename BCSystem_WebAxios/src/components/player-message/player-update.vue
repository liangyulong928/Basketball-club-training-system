<template>
    <div class="card-body">
      <div class="p-4 border rounded">
        <form class="row g-3 needs-validation" novalidate="">
          <div class="col-md-4">
            <label class="form-label">姓名</label>
            <input type="text" class="form-control" v-model="player.name">
          </div>
          <div class="col-md-4">
            <label class="form-label">联系电话</label>
            <input type="text" class="form-control" v-model="player.phone">
          </div>
          <div class="col-md-4">
            <label class="form-label">出生日期</label>
            <el-date-picker
              style="width: 100%"
              v-model="player.birthday"
              type="date"
              placeholder="选择日期">
            </el-date-picker>
          </div>
          <div class="col-md-6" v-if="type=='cba'">
            <label class="form-label">联赛注册ID</label>
            <div class="input-group has-validation">
              <input type="text" class="form-control" v-model="player.player_id" placeholder="省地方队球员">
            </div>
          </div>
          <div class="col-md-3">
            <label class="form-label">第一位置</label>
            <el-select v-model="player.position_1" placeholder="请选择">
              <el-option
                v-for="position in positions"
                :key="position.key"
                :label="position.name"
                :value="position.key">
              </el-option>
            </el-select>
          </div>
          <div class="col-md-3">
            <label class="form-label">第二位置</label>
            <el-select v-model="player.position_2" placeholder="请选择">
              <el-option
                v-for="position in positions"
                :key="position.key"
                :label="position.name"
                :value="position.key">
              </el-option>
            </el-select>
          </div>
          <div :class="[type=='cba'?'col-md-12':'col-md-6']">
            <label class="form-label">所属地方队</label>
            <el-select v-model="player.office" placeholder="请选择" style="width: 100%">
              <el-option :value=null label="引援"><span style="color: #b95050">引援</span></el-option>
              <el-option
                v-for="office in offices"
                :key="office.office_id"
                :label="office.office_name"
                :value="office.office_id">
              </el-option>
            </el-select>
          </div>
          <div class="col-md-12" v-if="type=='cba'">
            <label class="form-label">意向说明
              <button type="button" @click="addTag" v-if="addButton==false">添加</button>
            </label>
            <div class="table-responsive">
              <table class="table align-middle">
                <tbody>
                  <tr>
                    <th>日期</th>
                    <th>意向</th>
                    <th>处理人</th>
                  </tr>
                  <tr v-if="addButton==true">
                    <td>{{dateForAct}}</td>
                    <td>
                      <select v-model="tag_model.type">
                        <option selected="selected" value="success">Success</option>
                        <option value="warning">Wander</option>
                        <option value="danger">Danger</option>
                      </select>&nbsp;
                      <input type="text" v-model="tag_model.msg" />
                    </td>
                    <td><button type="button" @click="saveTag">保存</button></td>
                  </tr>
                  <tr v-for="tag in this.player.tags" :key="tag.date">
                    <td>{{tag.date}}</td>
                    <td>
                      <el-tag :type="tag.type" size="mini">{{ tag.msg }}</el-tag>
                    </td>
                    <td>{{ tag.req_id }}</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <div class="col-12">
            <el-button type="primary" plain @click="updatePlayer">保存修改</el-button>
            <el-button type="danger" plain v-if="player.player_id!=null" @click="signOutCBA">解约联赛</el-button>
            <el-button type="success" plain v-else @click="signContract">签约联赛</el-button>
          </div>
        </form>
      </div>
    </div>
</template>

<script>

import moment from "moment";

export default {
  name: "player-update",
  data(){
    return{
      dateForAct:null,
      tag_model:{
        player_id:this.player.id,
        date:null,
        type:null,
        msg:null,
        req_id:this.user.id
      },
      addButton:false,
      offices:null,
      positions:[{
        key:"SG",
        name:"控球后卫"
      },{
        key:"PG",
        name: "得分后卫"
      },{
        key:"SF",
        name:"小前锋"
      },{
        key:"PF",
        name: "大前锋"
      },{
        key:"C",
        name: "中锋"
      }],
      tags:null
    }
  },
  props:{
    user:JSON,
    player:JSON,
    type:String
  },
  created() {
    let param = new URLSearchParams();
    param.append("office",this.user.office)
    this.axios.post("http://localhost:8086/admin/searchOfficeListByOffice",param).then(
      (res)=>{
        this.offices = res.data;
      }
    )
  },
  methods:{
    saveTag(){
      if (this.tag_model.type!=null&&this.tag_model.msg!=null){
        let param = new URLSearchParams();
        param.append("tagString",JSON.stringify(this.tag_model))
        this.axios.post("http://localhost:8086/tag/addTag",param).then(
          (res)=>{
            if (res.data==1){
              this.$message({
                message:'保存成功',
                type:'success',
                duration:3000
              })
            }
            else {
              this.$message({
                message:'保存失败',
                type:'error',
                duration:3000
              })
            }
          }
        )
      }
      else {
        this.$message({
          message:'请完整填写信息',
          type:'error',
          duration:3000
        })
      }
    },
    addTag(){
      this.addButton=true;
      this.tag_model.date = new Date();
      this.dateForAct = moment(this.tag_model.date).format("yyyy-MM-DD")
    },
    signOutCBA(){
      this.$confirm('此操作将更该球员信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.axios("http://localhost:8086/player-management/signOutCBA",{params:{'id':this.player.id}}).then(
          (res)=>{
            if (res.data==1){
              this.$message({
                message:'操作成功',
                type:'success',
                duration:3000
              })
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
      }
      );
    },
    signContract(){
      this.$prompt('请输入联赛注册号',"提示",{
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPlaceholder:'联赛注册号',
        inputType:"text"
      }).then(
        ({ value })=>{
          let param = new URLSearchParams();
          param.append("player_id",value);
          param.append("id",this.player.id);
          this.axios.post("http://localhost:8086/player-management/signContract",param).then(
            (res)=>{
              if (res.data==1){
                this.$message({
                  message:'签约成功',
                  type:'success',
                  duration:3000
                })
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
        }
      )
    },
    updatePlayer(){
      if (this.player.position_1==this.player.position_2){
        this.player.position_2 = null;
      }
      let param = new URLSearchParams();
      param.append("playerString",JSON.stringify(this.player))
      this.axios.post("http://localhost:8086/player-management/updatePlayer",param).then(
        (res)=>{
          if (res.data==1){
            this.$message({
              message:'保存成功',
              type:'success',
              duration:3000
            })
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
    }
  }
};
</script>

<style scoped>

</style>