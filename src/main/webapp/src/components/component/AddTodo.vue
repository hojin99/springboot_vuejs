<template>
  <div>
    <span>New Todo : </span>
    <el-input size="mini" placeholder="Please Input Todo" v-model="todoName"></el-input>
    <el-button size="mini" @click="addTodo">Add Todo</el-button>
  </div>
</template>

<script>
export default {
    data() {
        return {
            todoName: ''
        }
    },
    methods: {
        addTodo() {
            if(this.todoName !== '')
                this.$emit('addTodo', this.todoName);
        }
    }
}
</script>

<style>

</style>