<template>
    <div class="hj-child">Child2</div>
</template>

<script>
export default {
  created() {
    console.log('child2 created');
  },
  mounted() {
    console.log('child2 mounted');
  },
  updated() {
    console.log('child2 updated');
  }, 
  destroyed() {
    console.log('child2 destroyed');
  }
}
</script>

<style lang="scss" scoped>

.hj-child {
  color: rgb(0, 255, 200);
}

</style>