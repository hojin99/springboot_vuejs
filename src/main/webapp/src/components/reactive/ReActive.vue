<template>
  <div>
    <h3>버튼 클릭 후 콘솔 로그 확인</h3>
    <button @click="changeData()">Change Data</button><button @click="reset()">Reset</button><br>
    Message: {{message}} 
    <!-- <span ref="message">{{message}}</span> -->
    <input ref="message" type="text" :value="message" readonly>
    <!-- <br>
    이름(this.name): {{name}}      -->
    <br>
    이름:(this.obj.name): {{obj.name}} 
    <br>
    배열:(this.arr): {{arr}}     
  </div>
</template>

<script>
export default {
    data() {
        return {
            message: 'Not Updated!',
            text: 'test',
            arr: ['a','b','c','d'],
            obj: {
                id: '1',
            }            
        }
    },
    mounted() {
        // 객체에 직접 프로퍼티 추가하는 건 Warning (감지 못함)
        // this.name = "홍길동"; 
        this.$set(this.obj, 'name', '홍길동');

        // https://v2.vuejs.org/v2/guide/reactivity.html#Change-Detection-Caveats
        // 설명과 다르게 reactive로 잘 동작함 (버전업이 되면서 개선된건지?)
        this.arr[1] = 'B';
        // this.$set(this.arr, 1, 'B');
        this.arr.length = 2;
        // this.arr.splice(2);
    },
    methods: {
        changeData() {
            this.message = "Update";
            // Dom은 아직 업데이트가 안되어서 false로 나옴
            console.log(`input element value : ${this.$refs.message.value}`);    
            this.$nextTick(() => {
                // Dom 업데이트 후에는 true로 나옴 (업데이트 된 DOM을 참조하려면 nextTick사용 필요)
                console.log(`input element value : ${this.$refs.message.value}`);   
            });

            // https://v2.vuejs.org/v2/guide/reactivity.html#Change-Detection-Caveats
            // 설명과 다르게 reactive로 잘 동작함 (버전업이 되면서 개선된건지?)
            this.arr[1] = 'B';
            // this.$set(this.arr, 1, 'B');
            this.arr.length = 2;
            // this.arr.splice(2);
        },
        reset() {
            this.message = "Not Update";

            this.arr[1] = 'b'
            this.arr.length = 4;
        }
    }

}
</script>

<style>

</style>