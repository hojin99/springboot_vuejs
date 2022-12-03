<template>
  <div id="app">
        <el-tabs v-model="activeName" @tab-click="navigate">
            <el-tab-pane v-for="menu in menuList" :label="menu.name" :name="menu.path" :key="menu.index"></el-tab-pane>
        </el-tabs>
        <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App',
  data() {
    return {
      menuList: [
        {index:0, name:'Bind', path:"/bind"},
        {index:16, name:'Component', path:"/component"},
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
        {index:17, name:'BootStrap', path:"/bootstrap"},
        {index:15, name:'Etc', path:"/etc"},
      ],
      activeName: '/bind',
      beforeActive: ''
    }
  },
  methods: {
    // 메뉴 이동
    navigate() {
        if(this.beforeActive !== this.activeName) {
            console.log(`route to ${this.activeName}`);
            this.$router.push(this.activeName);
            this.beforeActive = this.activeName;
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

        this.navigate();
  }
}
</script>

<style>

</style>
