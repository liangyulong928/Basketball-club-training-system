import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "index",
    meta:{title:"球员训练管理平台"},
    component:()=>import("../views/index.vue"),
    children:[
      {
        path:"/login",
        name:"login",
        component:()=>import("../views/login")
      },{
        path:"/show",
        name:"show",
        component:()=>import("../views/Show.vue")
      }
    ]
  },
  {
    path:"/update",
    name:"update",
    meta:{title:"辽宁沈阳三生飞豹俱乐部"},
    component:()=>import("../views/Update.vue")
  },
  {
    path: "/admin",
    name: "admin",
    meta:{title:"个人中心"},
    component:()=>import("../views/admin/admin-index"),
    children: [
      {
        path: "/admin-home",
        name: "admin-home",
        component:()=>import("../views/admin/admin-home")
      },
      {
        path: "/player-message",
        name: "player-message",
        component:()=>import("../views/admin/admin-player-management/player-message")
      },
      {
        path: "/role-authorization",
        name: "role-authorization",
        component:()=>import("../views/admin/admin-player-management/role-authorization")
      },
      {
        path: "/training-plan",
        name: "training-plan",
        component:()=>import("../views/admin/admin-player-management/training-plan")
      },
      {
        path: "/game-analysis",
        name: "game-analysis",
        component:()=>import("../views/admin/admin-player-management/game-analysis")
      },
      {
        path: "/player-analysis",
        name: "player-analysis",
        component:()=>import("../views/admin/admin-player-management/player-analysis")
      }
    ]
  }
];

const router = new VueRouter({
  mode:"history",
  routes,
});

router.beforeEach((to,from,next)=>{
  if (to.meta.title){
    document.title = to.meta.title
  }
  next()
})

export default router;
