<template>
  <div>
    <span>New Todo : </span>
    <el-input size="mini" placeholder="Please Input Todo" v-model="todoName"></el-input>
    <el-button size="mini" @click="addTodo">Add Todo</el-button>
  </div>
</template>

<script>
import { createNamespacedHelpers } from 'vuex';
const { mapState, mapActions }  = createNamespacedHelpers('todoListStore');

export default {
    data() {
        return {
            todoName: ''
        }
    },
    computed: {
      ...mapState(
        ['todoList'] // 이름과 상태이름이 동일할 경우 문자열 배열로 정의 가능
      ), 
    },    
    methods: {
        ...mapActions(['addTodoA']), // this.$store.dispatch('todoListStore/changeTodo',payload) 대신 this.changeTodo(payload) 사용
        addTodo() {
            if(this.todoName !== '') {
                const sameTodo = this.todoList.find((item) => {
                    return item.name === this.todoName;
                })
                
                if(sameTodo == undefined) {
                    this.addTodoA(this.todoName);
                } else {
                    this.$alert('동일한 todo 입력 불가');
                }                
            }
        }
    }
}
</script>

<style>

</style>