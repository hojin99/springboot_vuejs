<template>
  <div id="app">
    <b-navbar type="dark" variant="info">
      <b-navbar-brand href="#">Vue Test</b-navbar-brand>

      <b-navbar-nav>
        <b-nav-item-dropdown text="Framwork" right>
          <b-dropdown-item v-for="menu in frameworkMenuList" @click="navigate(menu.path)" :key="menu.index">{{menu.name}}</b-dropdown-item>
        </b-nav-item-dropdown>       
        <b-nav-item-dropdown text="Library" right>
          <b-dropdown-item v-for="menu in libraryMenuList" @click="navigate(menu.path)" :key="menu.index">{{menu.name}}</b-dropdown-item>
        </b-nav-item-dropdown>       
        <b-nav-item-dropdown text="Application" right>
          <b-dropdown-item v-for="menu in applicationMenuList" @click="navigate(menu.path)" :key="menu.index">{{menu.name}}</b-dropdown-item>
        </b-nav-item-dropdown>                  
      </b-navbar-nav>   
    </b-navbar>
    <b-navbar type="dark" variant="dark" style="height:30px">
      <b-navbar-brand href="#">{{beforeActive}}</b-navbar-brand>
    </b-navbar>      
    <router-view></router-view>
  </div>

</template>

<script>

export default {
  name: 'App',
  data() {
    return {
      frameworkMenuList: [
        {index:0, name:'Bind', path:"/bind"},
        {index:15, name:'Component', path:"/component"},
        {index:14, name:'Vuex', path:"/vuex"},        
        {index:1, name:'Event', path:"/event"},
        {index:2, name:'Lifecycle', path:"/lifecycle"},
        {index:3, name:'Watch', path:"/watch"},
        {index:4, name:'Style', path:"/style"},
        {index:5, name:'Flow', path:"/flow"},
        {index:6, name:'Slot', path:"/slot"},
        {index:7, name:'Dynamic', path:"/dynamic"},
        {index:8, name:'Aysnc', path:"/async"},
        {index:9, name:'Transition', path:"/transition"},
        {index:10, name:'Mixin', path:"/mixin"},
        {index:11, name:'Directive', path:"/directive"},
        {index:12, name:'Plugin', path:"/plugin"},
        {index:13, name:'Filter', path:"/filter"},
        {index:16, name:'Reactive', path:"/reactive"},
      ],      
      libraryMenuList: [
        {index:0, name:'BootStrap', path:"/bootstrap"},
        {index:1, name:'FontAweSome', path:"/fontawesome"},
        {index:2, name:'Tooltip', path:"/tooltip"},
        {index:3, name:'I18n', path:"/i18n"},
        {index:4, name:'Axios', path:"/axios"},
      ],
      applicationMenuList: [
        {index:0, name:'List', path:"/list"},
      ],      
      beforeActive: ''
    }
  },
  methods: {
    // 메뉴 이동
    navigate(path) {

      if(this.beforeActive !== path) {
        console.log(`route to ${path}`);
        this.$router.push(path);
        this.beforeActive = path;
      }

    }
  },
  mounted() {
        // cookie set, get 테스트 (hj cookie가 없으면 생성)
        // this.$cookies.remove('hj');
        let cookie = this.$cookies.get('hj');
        console.log(`cookie1 : ` + cookie);

        if(!cookie) 
          cookie = this.$cookies.set('hj', 'test').get('hj');
        console.log(`cookie2 : ` + cookie);

        this.navigate('/bind');
  }
}
</script>

<style>

</style>
