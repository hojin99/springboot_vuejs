<template>
  <div>
      <el-card class="box-card"> 
        <div slot="header">
            <span>state: {{title}}</span><br>
            <span>getter: {{reverseTitle}}</span><br>
            <span>local state: {{titleAll}}</span>
        </div>
        <todo v-for="todo in todoList" :todo="todo" :key="todo.index"></todo>
        <br>
        <add-todo></add-todo>
      </el-card>
 
  </div>
</template>

<script>
import { createNamespacedHelpers } from 'vuex';
const { mapState, mapMutations, mapGetters }  = createNamespacedHelpers('todoListStore');

import AddTodo from './AddTodo.vue'
import Todo from './Todo.vue'

export default {
  components: { AddTodo, Todo },
    props: {
        initTodos : {type: Array, rquired:true},
        initTitle : {type: String}, 
    },
    data() {
        return {
            subTitle : ' + local state'
        }
    },
    computed: {
      ...mapState(
        ['todoList', 'title'] // 이름과 상태이름이 동일할 경우 문자열 배열로 정의 가능
      ),        
      ...mapState({
        // todoList: state => state.todoList, // 화살표 함수 사용
        // title: 'title', // state => state.title과 동일
        titleAll(state) {  // local 상태와 함께 사용하려면 일반 함수 사용
            return state.title + this.subTitle;
        }
      }),
      ...mapGetters(
          ['doneTodos', 'getTodoByName', 'reverseTitle']
      ),
    }, 
    mounted() {
        this.setTodoListM({'data': JSON.parse(JSON.stringify(this.initTodos))}); // props를 초기화 변수로 사용 (배열, 객체는 참조변수여서 deep copy 필요)
        this.setTitleM(this.initTitle); // props를 초기화 변수로 사용
    },
    methods: {
        ...mapMutations(['setTodoListM','setTitleM']), // this.$store.commit('todoListStore/setTodoList',payload) 대신 this.setTodoList(payload)사용
        changeTitle() {
            this.setTitleM("TO DO List");
        }
    }

}
</script>

<style>

  .box-card {
    width: 480px;
  }

</style>