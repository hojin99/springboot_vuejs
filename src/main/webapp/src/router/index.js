import Vue from 'vue';
import Router from 'vue-router';
import Bind from '@/components/bind/Bind.vue';
import Event from '@/components/event/Event.vue';
import Lifecycle from '@/components/lifecycle/Lifecycle.vue';
import Watch from '@/components/watch/Watch.vue';
import Style from '@/components/style/Style.vue';
import Flow from '@/components/flow/Flow.vue';
import Slot from '@/components/slot/Slot.vue';
import Dynamic from '@/components/dynamic/Dynamic.vue';
import Aysnc from '@/components/async/Async.vue';
import Transition from '@/components/transition/Transition.vue';
import Mixin from '@/components/mixin/Mixin.vue';
import Directive from '@/components/directive/Directive.vue';
import Plugin from '@/components/plugin/Plugin.vue';
import Filter from '@/components/filter/Filter.vue';
import Vuex from '@/components/vuex/Vuex.vue';
import FontAweSome from '@/components/fontawesome/FontAweSome.vue';
import Comp from '@/components/component/Component.vue';
import BootStrap from '@/components/bootstrap/BootStrap.vue';
import Tooltip from '@/components/tooltip/Tooltip.vue';
import List from '@/components/list/List.vue';
import I18n from '@/components/i18n/I18n.vue';
import Axios from '@/components/comm/Axios.vue';
import ReActive from '@/components/reactive/ReActive.vue';

Vue.use(Router);

export default new Router({
    mode: 'abstract',
    base : __dirname,
    routes: [
        {name:'Bind', path:"/bind", component:Bind},
        {name:'Event', path:"/event", component:Event},
        {name:'Lifecycle', path:"/lifecycle", component:Lifecycle},
        {name:'Watch', path:"/watch", component:Watch},
        {name:'Style', path:"/style", component:Style},
        {name:'Flow', path:"/flow", component:Flow},
        {name:'Slot', path:"/slot", component:Slot},
        {name:'Dynamic', path:"/dynamic", component:Dynamic},
        {name:'Aysnc', path:"/async", component:Aysnc},
        {name:'Transition', path:"/transition", component:Transition},
        {name:'Mixin', path:"/mixin", component:Mixin},
        {name:'Directive', path:"/directive", component:Directive},
        {name:'Plugin', path:"/plugin", component:Plugin},
        {name:'Filter', path:"/filter", component:Filter},
        {name:'Vuex', path:"/vuex", component:Vuex},
        {name:'FontAweSome', path:"/fontawesome", component:FontAweSome},
        {name:'Component', path:"/component", component:Comp},
        {name:'BootStrap', path:"/bootstrap", component:BootStrap},
        {name:'Tooltip', path:"/tooltip", component:Tooltip},
        {name:'List', path:"/list", component:List},
        {name:'I18n', path:"/i18n", component:I18n},
        {name:'Axios', path:"/axios", component:Axios},
        {name:'ReActive', path:"/reactive", component:ReActive},
      ]
})