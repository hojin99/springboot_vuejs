<template>
  <div>
        <ul class="iw-dropdown-menu">
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
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

  </div>
</template>

<script>
import VirtualList from './VirtualList.vue';

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
            textKey: "name"
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