import Vue from 'vue'
import App from './App.vue'
import router from './router';
import store from './store';
import i18n from './assets/i18n/i18n';

// fontawsome icon
import './fontawesome.js';

// element-ui
import 'element-ui/lib/theme-chalk/index.css';

import ElementUI from 'element-ui';
Vue.use(ElementUI);

Vue.prototype.$msgbox = ElementUI.MessageBox;
Vue.prototype.$alert = ElementUI.MessageBox.alert;
Vue.prototype.$confirm = ElementUI.MessageBox.confirm;
Vue.prototype.$prompt = ElementUI.MessageBox.prompt;

// bootstrap
import '@/scss/app.scss';

import { BootstrapVue } from 'bootstrap-vue';
Vue.use(BootstrapVue);

// vue-cookies
import VueCookies from "vue-cookies";

Vue.use(VueCookies);
// 만료일 1일
Vue.$cookies.config("1d");

Vue.config.productionTip = false

new Vue({
  i18n,
  router,
  store,
  render: h => h(App),
}).$mount('#app')
