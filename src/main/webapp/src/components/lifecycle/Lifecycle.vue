<template>
  <div>
    <li>created, mounted, updated, destroyed</li>
    <br>    
    {{message}}
    <input v-model="message">
  </div>
</template>

<script>
export default {
  data() {
    return {
        message:"Hello"
    }
  },
  created() {
    console.log('created');
  },
  mounted() {
    console.log('mounted');
  },
  updated() {
    console.log('updated');
  }, 
  destroyed() {
    console.log('destroyed');
  }
}
</script>

<style>

</style>