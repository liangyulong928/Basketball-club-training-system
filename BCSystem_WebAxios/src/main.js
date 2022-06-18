import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import axios from "axios";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.css";
import "pace-js/pace.min";
import "pace-js";
import $ from "jquery";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import {message} from "./utils/resetMessage";

Vue.use(ElementUI);
Vue.config.productionTip = false;
Vue.prototype.axios=axios;
Vue.prototype.$=$;
Vue.prototype.$message = message

new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");
