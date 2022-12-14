<template>
  <div class="iw-ag-grid-column-finder">

    <b-form-group v-slot="{ ariaDescribedby }" class="iw-size-select">
      <b-form-radio-group buttons v-model="size" :options="options" :aria-describedby="ariaDescribedby"></b-form-radio-group>
    </b-form-group>

    <b-form-group 
      class="iw-fieldset">
        <b-input-group :size="size">
            <!-- <template #prepend>
                <b-input-group-text>
                    <font-awesome-icon icon="search" />
                </b-input-group-text>
            </template> -->
            <b-input-group-prepend>
                <b-input-group-text>
                    <font-awesome-icon icon="search" />
                </b-input-group-text>              
            </b-input-group-prepend>

            <b-form-input
                v-model="value"
                autocomplete="off"
                placeholder="칼럼 찾기"
                ref="input"
                @blur="onInputBlur"
                @focus="onInputFocus"
                @keydown="onInputKeydown"
            />

            <!-- <template #append>
                <b-button
                    variant="iw-dropdown"
                    class="iw-input-group-btn"
                    @click="clearValue"
                >
                    <font-awesome-icon icon="times" />
                </b-button>
            </template> -->
            <b-input-group-append>
                <b-button
                    variant="iw-dropdown"
                    class="iw-input-group-btn"
                    @click="clearValue"
                >
                    <font-awesome-icon icon="times" />
                </b-button>              
            </b-input-group-append>

        </b-input-group>
    </b-form-group>


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
  data() {
    return {
      options: [
        { text: 'Small', value: 'sm' },
        { text: 'Medium', value: 'md' },
        { text: 'Large', value: 'lg' },        
      ],
      size: 'md',
      value: '',
      el: undefined,
    }
  },
  mounted() {
    console.log(this.$refs.input);
    console.log(this.$refs.input.$el);
    this.el = this.$refs.input.$el;
  },
  methods: {
    clearValue() {

    },
    onInputBlur() {

    },
    onInputFocus() {

    },
    onInputKeydown() {

    }
  }

}
</script>

<style lang="scss" scoped>
.iw-ag-grid-column-finder {
    > .iw-size-select {
      margin-top: 2px;
      margin-left: 2px;
      margin-bottom: 2px;
    }

    > .iw-fieldset {
        margin: 0;
    }
    ::v-deep .iw-input-group-btn {
        @include iw-border(1px, 1px, 1px, 0, $iw-gray-300);
    }
}
</style>
