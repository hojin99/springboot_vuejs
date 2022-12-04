<template>
  <div>
    <el-input placeholder="Please Input Text" v-model="message" size="small"></el-input>
    <el-input placeholder="Please Input Text" v-model="message2" size="small"></el-input>    
   
    <p> 세번 호출 됨 </p>
    <p>method : {{getMessage()}} </p> 
    <p>method : {{getMessage()}} </p>
    <p>method : {{getMessage()}} </p>
    <p> 한번 호출 됨 </p> 
    <p>computed : {{reverseMessage}} </p>
    <!-- 두번째는 호출 안됨 (캐싱) -->
    <p>computed : {{reverseMessage}} </p> 
    <p>computed : {{reverseMessage}} </p>
    <p> 2개의 변수에 대한 처리는 복잡해짐 </p>
    <p>watch : {{wMessage + ', ' + wMessage2}} </p> 
    <p>watch : {{wMessage + ', ' + wMessage2}} </p> 
    <p>watch : {{wMessage + ', ' + wMessage2}} </p>     
  </div>
</template>

<script>
export default {
  data() {
    return {
      message:'test',
      message2:'test',
      wMessage:'tset',
      wMessage2:'test'
    }
  }, 
  methods: {
    getMessage() {
      console.log('getMessage');
      return this.message.split('').reverse().join('') + ", " + this.message2.toUpperCase();
    }
  }, 
  computed: {
    reverseMessage: function() {
      console.log('reverseMessage');
      return this.message.split('').reverse().join('') + ", " + this.message2.toUpperCase();
    }
  },
  watch: {
    message : function (val) {
      console.log('watch');
      this.wMessage = val.split('').reverse().join('');
    },
    message2 : function (val) {
      console.log('watch2');
      this.wMessage2 = val.toUpperCase();
    }
  }
}
</script>


<style scoped>

.el-input {
  width: 200px;
}

</style>