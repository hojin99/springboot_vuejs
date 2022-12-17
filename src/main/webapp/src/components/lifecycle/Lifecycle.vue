<template>
  <div>
    <li>console에서 life cycle 이벤트 발생 확인</li>
    <li>created는 main -> child 순서</li>
    <li>mounted는 child -> main 순서</li>
    <br>

    <h3>main update</h3>
    <br>    
    
    <label>입력: </label><input v-model="message"><br>
    <label>출력: </label>{{message}}

    <h3>child component</h3>
    <hj-child></hj-child>
    <hj-child2></hj-child2>

  </div>
</template>

<script>
import HjChild from './HjChild.vue';
import HjChild2 from './HjChild2.vue';

export default {
  components: {
    HjChild,
    HjChild2
  },
  data() {
    return {
        message:"Hello"
    }
  },
  created() {
    console.log('main created');
  },
  mounted() {
    console.log('main mounted');
  },
  updated() {
    console.log('main updated');
  }, 
  destroyed() {
    console.log('main destroyed');
  }
}
</script>

<style>

</style>