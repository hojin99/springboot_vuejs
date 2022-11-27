<template>
  <div>
      <el-checkbox v-model="todoItem.completed" @change="changeTodo">{{todoItem.name}}</el-checkbox>
      <el-button size="mini" @click="deleteTodo">Delete</el-button>
  </div>
</template>

<script>
import { createNamespacedHelpers } from 'vuex';
const { mapActions }  = createNamespacedHelpers('todoListStore');

export default {
    data() {
        return {
            todoItem: '',
        }
    },
    // props를 통해서 상위 컴포넌트로 부터 속성 전달 받음
    props: {
        todo: {
            type:Object,
            required:true
        }
    }, 
    mounted() {
        this.todoItem = JSON.parse(JSON.stringify(this.todo)); // props를 초기화 변수로 사용 (배열, 객체는 참조변수여서 deep copy 필요)
    },
    methods: {
        ...mapActions(['changeTodoA','deleteTodoA']), // this.$store.dispatch('todoListStore/changeTodo',payload) 대신 this.changeTodo(payload) 사용
        changeTodo() {

            this.changeTodoA(this.todoItem);
        },
        deleteTodo() {

            this.deleteTodoA(this.todoItem);
         },
    }


}
</script>

<style>

</style>