<template>
  <div>
    <div class="hj-child">Child1 update</div>
    <label>입력: </label><input v-model="message"><br>
    <label>출력: </label> {{message}} <br>

    <hj-child-child></hj-child-child>
  </div>
</template>

<script>
import HjChildChild from './HjChildChild.vue'
export default {
  components: {HjChildChild},
  data() {
    return {
        message:"Hello"
    }
  },  
  created() {
    console.log('child created');
  },
  mounted() {
    console.log('child mounted');
  },
  updated() {
    console.log('child updated');
  }, 
  destroyed() {
    console.log('child destroyed');
  }
}
</script>

<style lang="scss" scoped>

.hj-child {
  color: red;
}

</style>