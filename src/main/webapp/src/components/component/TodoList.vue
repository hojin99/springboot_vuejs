<template>
  <div>
      <el-card class="box-card"> 
        <div slot="header">
            <span>{{title}}</span>
        </div>
        <!-- :todo props를 통해서 하위 컴포넌트에 속성 전달, @deleteTodo를 통해서 하위 컴포넌트로부터 이벤트 청취 -->
        <todo v-for="todo in todoList" :todo="todo" :key="todo.index" 
            @changeTodo="changeTodo" @deleteTodo="deleteTodo"></todo>
        <br>
        <add-todo @addTodo="addTodo"></add-todo>
      </el-card>
 
  </div>
</template>

<script>
import AddTodo from './AddTodo.vue'
import Todo from './Todo.vue'

export default {
  components: { AddTodo, Todo },
    data() {
        return {
           todoList: [], 
           title: "",
        }
    },
    props: {
        initTodos : {type: Array, rquired:true},
        initTitle : {type: String}, 
    }, 
    mounted() {
        this.todoList = JSON.parse(JSON.stringify(this.initTodos)); // props를 초기화 변수로 사용 (배열, 객체는 참조변수여서 deep copy 필요)
        this.title = this.initTitle; // props를 초기화 변수로 사용
    },
    methods: {
        changeTodo(todo) {
            console.log(`[TodoList.vue]change ${todo.name}`);
            
            let changeTodo = this.todoList.find((item) => {
                return item.index === todo.index;
            });

            changeTodo.completed = !changeTodo.completed;
            console.log(`[TodoList.vue] ${changeTodo.completed}`);
        },
        deleteTodo(todo) {
            console.log(`[TodoList.vue]delete ${todo.name}`); 

            this.todoList = this.todoList.filter((item) => {
                return todo.index !== item.index;
            })
         },
        addTodo(todoName) {
            console.log(`[TodoList.vue]add ${todoName}`);

            const sameTodo = this.todoList.find((item) => {
                return item.name === todoName;
            })
            
            if(sameTodo == undefined) {
                const lastIndex = this.todoList.reduce((prev, cur) => {

                    let curIndex = cur.index;
                    console.log(`${prev}:${curIndex}`);
                    if(prev < curIndex )
                        return curIndex;
                    else
                        return prev;
                },0);

                this.todoList.push({
                    name: todoName,
                    completed:false,
                    index:lastIndex+1
                });
            } else {
                this.$alert('동일한 todo 입력 불가');
            }
        },
        changeTitle() {
            this.title = "TO DO List";
        }
    }

}
</script>

<style>

  .box-card {
    width: 480px;
  }

</style>