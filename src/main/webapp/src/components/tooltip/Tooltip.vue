<template>
  <div class="body">
    <div ref="popcorn" id="popcorn" aria-describedby="tooltip"></div>
    <div ref="tooltip" id="tooltip" role="tooltip">
      My tooltip
      <div id="arrow" data-popper-arrow></div>
    </div>    
  </div>
</template>

<script>
import { createPopper } from '@popperjs/core';

export default {
    mounted() {
        console.log(this.$refs.popcorn);
        console.log(this.$refs.tooltip);

        createPopper(document.querySelector('#popcorn'), document.querySelector('#tooltip'), {
        placement:"bottom",
        modifiers: [
            {
            name: 'offset',
            options: {
                offset: [0, 8],
            },
            },
        ],      
        })
    }

}
</script>

<style scoped>

.body {
  background-color: #30263d;
  font-family: -apple-system, Helvetica Neue, Segoe UI, Roboto, Oxygen, Ubuntu,
    Cantarell, Open Sans, sans-serif;
  text-transform: uppercase;
  padding: 100px;
}

#popcorn {
  display: inline-block;
  width: 134px;
  height: 120px;
  background-image: url('https://popper.js.org/images/popcorn-box.svg');
}

#tooltip {
  display: inline-block;
  background: #ffffff;
  color: #643045;
  font-weight: bold;
  padding: 5px 10px;
  font-size: 13px;
  border-radius: 4px;
}

#arrow,
#arrow::before {
  position: absolute;
  width: 8px;
  height: 8px;
  background: inherit;
}

#arrow {
  visibility: hidden;
}

#arrow::before {
  visibility: visible;
  content: '';
  transform: rotate(45deg);
}

#tooltip[data-popper-placement^='top'] > #arrow {
  bottom: -4px;
}

#tooltip[data-popper-placement^='bottom'] > #arrow {
  top: -4px;
}

#tooltip[data-popper-placement^='left'] > #arrow {
  right: -4px;
}

#tooltip[data-popper-placement^='right'] > #arrow {
  left: -4px;
}



</style>