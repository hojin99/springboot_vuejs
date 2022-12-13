<template>
  <div>
        <b-form-input
            v-model="value"
            autocomplete="off"
            placeholder="찾기"
            ref="input"
            @blur="onInputBlur"
            @focus="onInputFocus"
            @keydown="onInputKeydown"
        />

        <ul class="iw-dropdown-menu" 
            :style="{ 'display': dropdownShow }"
            ref="menu">

            <virtual-list
                class="iw-menu-inner"
                style="height:150px"
                :rows="items"
                :row-height="rowHeight"
            >
                <template v-slot="{ row: item }">
                    <b-dropdown-item
                        class="iw-dropdown-item"
                    >
                        <div class="iw-item-content">
                            {{item[textKey]}}
                        </div>
                    </b-dropdown-item>
                </template>
            </virtual-list>

        </ul>   

  </div>
</template>

<script>
import VirtualList from './VirtualList.vue';
import { createPopper } from '@popperjs/core';

export default {
    components: { 
        VirtualList 
    },
    data() {
        return {
            items: [
                {'id':'1', 'name':'홍길동1'},
                {'id':'2', 'name':'손흥민1'},
                {'id':'3', 'name':'일지매1'},
                {'id':'4', 'name':'이순신1'},
                {'id':'5', 'name':'홍길동2'},
                {'id':'6', 'name':'손흥민2'},
                {'id':'7', 'name':'일지매2'},
                {'id':'8', 'name':'이순신2'},     
                {'id':'1', 'name':'홍길동3'},
                {'id':'2', 'name':'손흥민3'},
                {'id':'3', 'name':'일지매3'},
                {'id':'4', 'name':'이순신3'},
                {'id':'5', 'name':'홍길동4'},
                {'id':'6', 'name':'손흥민4'},
                {'id':'7', 'name':'일지매4'},
                {'id':'8', 'name':'이순신4'},                             
                ],
            rowHeight: 22,
            textKey: "name",
            value: undefined,
            popper: undefined,
            isInputFocused: false
        }
    },
    computed: {
        dropdownShow() {
            return this.isInputFocused ? 'block' : 'none';
        }
    },
    methods: {
        clearValue() {

        },
        onInputBlur() {
            this.isInputFocused = false;
            this.destroyPopper();
        },
        onInputFocus() {
            this.isInputFocused = true;
            this.createPopper();
        },
        onInputKeydown(evt) {
            if(evt.key === 'Enter')
                this.$refs.input.$el.blur();

        },
        createPopper() {
            console.log('createPopper');
            console.log(this.$refs.input.$el);
            console.log(this.$refs.menu);

            this.popper = createPopper(
                this.$refs.input.$el,
                this.$refs.menu,
                {
                    placement: 'bottom-start',
                    modifiers: [
                        {
                            name: 'offset',
                            options: {
                                offset: [0, 2],
                            }
                        }
                    ]
                }
            );
        },
        destroyPopper() {
            console.log('destroyPopper');
            this.popper.destroy();
            this.popper = undefined;
        }
  }

}
</script>

<style lang="scss" scoped>
.iw-dropdown-menu {
    $iw-max-width: 300px;
    width: $iw-max-width;
    overflow-y: auto;
    margin: 0;

    > .iw-menu-inner {
        width: 100%;
        height: 100%;

        // >>> 
        //::v-deep
        /deep/ .iw-dropdown-item {
            .dropdown-item {
                padding: 1px 1rem;
            }
            .iw-item-content {
                @include iw-ellipsis-text(calc(#{$iw-max-width} - 2rem));
            }
        }
    }
}
</style>