<template>
  <div>
    {{message}}
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

    // this.listBld();

  },
  methods: {
    hello() {
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

<style>

</style>