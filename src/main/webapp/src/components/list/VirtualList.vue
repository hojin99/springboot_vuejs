<template>
    <div
        class="iw-virtual-list"
        :style="{ 'overflow-x': overflowX }"
        @scroll.passive="onScroll"
    >
        <div
            ref="container"
            class="iw-row-container"
            :style="{ 'height': '' + containerHeight + 'px' }"
        >
            <div
                class="iw-row"
                :class="{ 'iw-node-activate': activeNode === row }"
                v-for="(row, index) in visibleRows"
                :key="keyPropertyName ? row[keyPropertyName] : index"
                :style="{ 'height': '' + rowHeight + 'px', 'top': '' + (rowHeight * (startIndex + index) + paddingY) + 'px' }"
            >
                <slot :row="row" />
            </div>
        </div>
    </div>
</template>

<script>
    import * as ResizeObserver from './ResizeObserver';

    export default {
        name: 'VirtualList',
        props: {
            rows: { type: Array, required: true },
            keyPropertyName: { type: String },
            rowsChanged: { type: Number, default: undefined },
                // rows가 (성능을 위해) reactive하지 않을 때 지정한다.
                // 그 경우, 이 값이 바뀌면 rows가 변경된 것으로 간주한다.
            rowHeight: { type: Number, required: true },
            paddingY: { type: Number, default: 0 },
            overflowX: { type: String, default: 'hidden' },
            selectedNode: { type: Object }
        },
        data() {
            return {
                elHeight: 1,
                startIndex: 0,
                nonReactiveRowsLength: 0,
                nonReactiveVisibleRows: (this.rowsChanged === undefined) ? undefined : [],
                activeNode: undefined,
                isDestroyed: false
            }
        },
        computed: {
            numVisibleRows() {
                return Math.ceil(this.elHeight / this.rowHeight) + 1;
            },
            rowsLength() {
                return (this.rowsChanged === undefined) ?
                    this.rows.length : this.nonReactiveRowsLength;
            },
            containerHeight() {
                return this.rowHeight * this.rowsLength + this.paddingY * 2;
            },
            visibleRows() {
                return (this.rowsChanged === undefined) ?
                    this.getVisibleRows() : this.nonReactiveVisibleRows;
            }
        },
        created() {
            if (this.rowsChanged !== undefined) {
                this.nonReactiveRowsLength = this.rows.length;
                this.$watch('rowsChanged', function () {
                    this.nonReactiveRowsLength = this.rows.length;
                    this.setupSize();
                });
            }
        },
        destroyed() {
            if (this.stopResizeObserver)
                this.stopResizeObserver();
            this.isDestroyed = true;
            this.$emit('api', undefined);
        },
        mounted() {
            this.setupSize();
            this.stopResizeObserver = ResizeObserver.observe(this.$el, () => {
                this.setupSize();
            });
            const that = this;
            // this.$refs 가 초기화되려면 $nextTick()으로 기다려야 한다.
            // 참고: https://vuejs.org/v2/api/#mounted
            this.$nextTick(() => {
                if (this.isDestroyed)
                    return;
                this.$emit('api', {
                    scrollIntoView(index) { that.scrollIntoView(index) }
                });
            });
        },
        methods: {
            setVisibleRows() {
                if (this.rowsChanged !== undefined) {
                    // rows가 reactive하지 않은 경우, 여기서 rows의 element들 중 visibleRows에 포함되는
                    // 것들이 reactive 상태가 된다. visibleRows에 의해 '전염'되는 것.
                    this.nonReactiveVisibleRows = this.getVisibleRows();
                }
            },
            getVisibleRows() {
                return this.rows.slice(this.startIndex, this.startIndex + this.numVisibleRows);
            },
            setupSize() {
                this.elHeight = this.$el.offsetHeight;
                this.setVisibleRows();
            },
            onScroll() {
                let elScrollTop = Math.max(this.$el.scrollTop - this.paddingY, 0);
                this.startIndex = Math.floor(elScrollTop / this.rowHeight);
                this.setVisibleRows();
            },
            /**
             * @param {number} index
             */
            scrollIntoView(index) {
                // DOM이 update되기 전에 call될 수도 있으므로, container의 height를 여기서 검사해서
                // 미리 update 한다. 그러지 않으면 height가 충분하지 않아서 scroll이 덜 될 수 있다.
                if (this.$refs.container.clientHeight !== this.containerHeight)
                    this.$refs.container.style.height = '' + this.containerHeight + 'px';
                const minY = index * this.rowHeight + this.paddingY;
                if (this.$el.scrollTop > minY) {
                    this.$el.scrollTop = minY;
                    return;
                }
                const maxY = minY + this.rowHeight;
                if (this.$el.scrollTop + this.elHeight < maxY) {
                    this.$el.scrollTop = maxY - this.elHeight;
                }
            }
        }
    }
</script>

<style lang="scss" scoped>
    .iw-virtual-list {
        overflow-y: auto;
        position: relative;
        color: black;

        .iw-row-container {
            position: absolute;
            left: 0;
            top: 0;
            right: 0;

            .iw-row {
                position: absolute;
                left: 0;
                right: 0;
            }
            .iw-node-activate {
                background-color: yellowgreen !important;
                color: rebeccapurple;
                :hover {
                    background-color: yellowgreen !important;
                }
            }
        }
    }
</style>
