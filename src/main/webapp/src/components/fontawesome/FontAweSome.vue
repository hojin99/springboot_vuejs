<template>
  <div>
    {{message}}
    <font-awesome-icon icon="fa-solid fa-user-secret" />
    <font-awesome-icon icon="fa-brands fa-twitter" />
    <font-awesome-icon icon="fa-regular fa-hospital" />
   
    <div v-for="bld in bldList" :key="bld.bld_adm_cd">{{bld.bld_name}}</div>
  </div>
</template>

<script>
import axios from 'axios';
import qs from 'qs';


export default {
  data() {
    return {
      message: "",
      bldList: []
    }
  },
  mounted() {

    this.hello();
    this.listBld();

  },
  methods: {
    hello() {
      // http://localhost:19002/hello?userIds=1&userIds=2
      const params = {userIds:[1,2]};
      const myAxios = axios.create({
        paramsSerializer: params => qs.stringify(params, {arrayFormat: 'repeat'})
      });

      myAxios.get('/hello',{params}).then((res) =>{
        this.message = res.data;
        return res.data;
       }).catch(console.log);
    },
    listBld() {
      axios.get ('/bld/list').then((res) => {
        this.bldList = res.data;
        console.log(res.data);

      }).catch(console.log);
    },

    
  }
}
</script>

<style scoped>


</style>