<template>
  <div>
    <b-button class="mb-2" variant="primary" @click="$bvToast.show('example-toast')">
      Show toast
    </b-button>    
    <b-toast id="example-toast" title="BootstrapVue" static no-auto-hide>
      Hello, world! This is a toast message.
    </b-toast>    
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>
