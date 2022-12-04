<template>
  <div>
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
                {'id':'1', 'name':'홍길동'},
                {'id':'2', 'name':'손흥민'},
                {'id':'3', 'name':'메시'},
                {'id':'4', 'name':'음바페'},
                {'id':'5', 'name':'홍길동'},
                {'id':'6', 'name':'손흥민'},
                {'id':'7', 'name':'메시'},
                {'id':'8', 'name':'음바페'},     
                {'id':'1', 'name':'홍길동'},
                {'id':'2', 'name':'손흥민'},
                {'id':'3', 'name':'메시'},
                {'id':'4', 'name':'음바페'},
                {'id':'5', 'name':'홍길동'},
                {'id':'6', 'name':'손흥민'},
                {'id':'7', 'name':'메시'},
                {'id':'8', 'name':'음바페'},                             
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

        &.iw-no-result-message {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        /deep/ .iw-dropdown-item {
            .dropdown-item {
                padding: 2px 1rem;
            }
            .iw-item-content {
                @include iw-ellipsis-text(calc(#{$iw-max-width} - 2rem));
            }
        }
    }
}
</style>