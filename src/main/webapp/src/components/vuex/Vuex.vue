<template>
  <div>
      <el-row>
        <el-col>
            <!-- HTML에서 컴포넌트는 kebab-case(소문자,하이픈)로 사용 권장 (HTML에서는 대소문자 구분이 안 되기 때문)  -->
            <todo-list ref="todolistTom" :initTodos="toDoListTom" :initTitle="titleTom"></todo-list>
        </el-col>
      </el-row>

      <!-- <el-row >
        <el-col>
            <todo-list ref="todolistJane" :initTodos="toDoListJane" :initTitle="titleJane"></todo-list>
        </el-col>
      </el-row> -->
  </div>
</template>

<script>
import TodoList from "./TodoList.vue";

export default {
    components: { TodoList },
    data() {
        return {
            "toDoListTom":[
                {index:0, name:"Study", completed:false},
                {index:1, name:"Play Baseball", completed:false},
                {index:2, name:"Read Bible", completed:true},
            ],
            "titleTom" : "TO DO (Tom)",
            // "toDoListJane":[
            //     {index:0, name:"Study", completed:false},
            //     {index:1, name:"Play Baseball", completed:false},
            //     {index:2, name:"Read Bible", completed:true},
            //     {index:3, name:"Watch TV", completed:true},
            // ],
            // "titleJane" : "TO DO (Jane)"            
        };
    },
}
</script>

<style>
  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
</style>