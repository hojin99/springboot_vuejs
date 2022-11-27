<template>
  <div>
      <el-checkbox v-model="todoItem.completed" @change="changeTodo">{{todoItem.name}}</el-checkbox>
      <el-button size="mini" @click="deleteTodo">Delete</el-button>
  </div>
</template>

<script>
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
        changeTodo() {
            // 상위 컴포넌트로 이벤트 전달
            this.$emit('changeTodo', this.todoItem);
        },
        deleteTodo() {
            // 상위 컴포넌트로 이벤트 전달
            this.$emit('deleteTodo', this.todoItem);
        }
    }


}
</script>

<style>

</style>