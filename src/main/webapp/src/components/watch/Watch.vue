<template>
  <div>
    <el-input placeholder="Please Input Text" v-model="message" size="small"></el-input>
    <p>method : {{getMessage()}} </p> 
    <p>method : {{getMessage()}} </p> 
    <p>computed : {{reverseMessage}} </p>
    <!-- 두번째는 호출 안됨 (캐싱) -->
    <p>computed : {{reverseMessage}} </p> 
    <p>watch : {{rMessage}} </p> 
    <p>watch : {{rMessage}} </p> 
  </div>
</template>

<script>
export default {
  data() {
    return {
      message:'test',
      rMessage:'tset'
    }
  }, 
  methods: {
    getMessage() {
      console.log('getMessage');
      return this.message.split('').reverse().join('');
    }
  }, 
  computed: {
    reverseMessage: function() {
      console.log('reverseMessage');
      return this.message.split('').reverse().join('');
    }
  },
  watch: {
    message : function (val) {
      console.log('watch');
      this.rMessage = val.split('').reverse().join('');
    }
  }
}
</script>


<style scoped>

.el-input {
  width: 200px;
}

</style>