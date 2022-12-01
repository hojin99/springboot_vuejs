import Vue from 'vue'
import App from './App.vue'
import router from './router';
import store from './store';

Vue.config.productionTip = false

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

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
