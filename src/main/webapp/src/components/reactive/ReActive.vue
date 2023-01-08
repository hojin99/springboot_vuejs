<template>
  <div>
    <h3>버튼 클릭 후 콘솔 로그 확인</h3>
    <button @click="testObj()">Change Name - Obj</button><button @click="testObjReactive()">Change Name - Obj set</button><br>
    <button @click="testArray()">Change Array</button><button @click="testArrayReactive()">Change Array set, splice</button><br>
    <button @click="changeMessage()">Change Message</button><br>
    <button @click="reset()">Reset</button><br>
    이름:(this.obj.name): {{obj.name}} 
    <br>
    배열:(this.arr): {{arr}}
    <br>
    Message: {{message}} 
    <input ref="message" type="text" :value="message" readonly>
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
    methods: {
        testObj() {
            // https://v2.vuejs.org/v2/guide/reactivity.html#Change-Detection-Caveats
            // 객체에 직접 프로퍼티 추가하는 건 감지 못함
            this.obj.name = "홍길동"; 
        },
        testObjReactive() {
            this.$set(this.obj, 'name', '홍길동');
        },        
        testArray() {
            // https://v2.vuejs.org/v2/guide/reactivity.html#Change-Detection-Caveats 
            // 배열에 요소를 직접 바꾸거나, 길이를 바꾸는 것은 감지 못함
            this.arr[1] = 'B';
            this.arr.length = 2;
        },
        testArrayReactive() {
            this.$set(this.arr, 1, 'B');
            this.arr.splice(2);
        },        
        changeMessage() {
            this.message = "Update";
            // Dom은 아직 업데이트가 안되어서 false로 나옴
            console.log(`input element value before nexttick : ${this.$refs.message.value}`);    
            this.$nextTick(() => {
                // Dom 업데이트 후에는 true로 나옴 (업데이트 된 DOM을 참조하려면 nextTick사용 필요)
                console.log(`input element value after nexttick : ${this.$refs.message.value}`);   
            });
 
        },
        reset() {
            this.obj = {
                id: '1',
            };

            this.arr = ['a','b','c','d'];    

            this.message = "Not Update";            
        }
    }

}
</script>

<style>

</style>