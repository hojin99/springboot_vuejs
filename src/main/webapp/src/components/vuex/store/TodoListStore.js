
const state = {
    todoList: [], 
    title: "",
}

const getters = {
    doneTodos: state => state.todoList.filter(todo => todo.completed),
    getTodoByName: state => name => state.todoList.find(todo => todo.name === name),
    reverseTitle: state => state.title.split("").reverse().join(""),
}

// mutation은 무조건 동기이어야 함 (devtool에서 상태의 이전, 이후를 캡쳐해야 하는데, 비동기 콜백일 경우 불가능함)
const mutations = {
    setTodoListM(state, payload) {
        state.todoList = payload.data;
    },
    changeTodoCompletedM(state, todo) {
        let changeTodo = state.todoList.find((item) => {
            return item.index === todo.index;
        });

        changeTodo.completed = !changeTodo.completed;
    },
    deleteTodoM(state, todo) {
        state.todoList = state.todoList.filter((item) => {
            return todo.index !== item.index;
        })
    },    
    addTodoM(state, todoName) {
        const lastIndex = state.todoList.reduce((prev, cur) => {

            let curIndex = cur.index;
            if(prev < curIndex )
                return curIndex;
            else
                return prev;
        },0);

        state.todoList.push({
            name: todoName,
            completed:false,
            index:lastIndex+1
        });
    },
    setTitleM(state, title) {
        state.title = title;
    }
}

const actions = {
    async changeTodoA({commit}, todo) {
        // db 트랜잭션 후
        commit('changeTodoCompletedM',todo);
    },
    async deleteTodoA({commit}, todo) {
        // db 트랜잭션 후
        commit('changeTodoCompletedM',todo);
     },
     async addTodoA({commit}, todoName) {
        // db 트랜잭션 후
        commit('addTodoM',todoName);
    },
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
};