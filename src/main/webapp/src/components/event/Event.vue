<template>
  <div>
    <li>@submit.prevent</li>   
    <br>     
    <form @submit.prevent="onSubmit">
      <span>Name:</span><input name="name">
      <span>Password:</span><input type="password" name="password">  

      <button>Submit</button>
    </form>
  </div>
</template>

<script>
export default {
  methods: {
    onSubmit() {
      console.log("onSubmit with prevent");
    }
  }

}
</script>

<style>

</style>