<template>
  <div>
    <div class="hj-childchild">child-child</div>
  </div>
</template>

<script>
export default {
  created() {
    console.log('childchild created');
  },
  mounted() {
    console.log('childchild mounted');
  },
  updated() {
    console.log('childchild updated');
  }, 
  destroyed() {
    console.log('childchild destroyed');
  }
}
</script>

<style lang="scss" scoped>

.hj-childchild {
  color: rgb(98, 0, 255);
}

</style>