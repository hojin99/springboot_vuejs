<template>
  <div class="hj-container">
    <div class="hj-toolbar">
        <b-button
          v-b-tooltip.hover
          title="새로고침"
        >
          <font-awesome-icon icon="fa-solid fa-sync" />
        </b-button>
        <b-button
          v-b-tooltip.hover
          title="전체펼치기"
        >
          <ExpandAllIcon class="hj-tool-icon"></ExpandAllIcon>
        </b-button>
        <b-button
          v-b-tooltip.hover
          title="전체접기"
        >
          <CollapseAllIcon class="hj-tool-icon"></CollapseAllIcon>
        </b-button>
        <div class="hj-toolbar-nowrap">
            <div class="hj-filter">
                <div class="hj-filter-label">필터:</div>
                <b-dropdown class="hj-filter-type-dropdown">
                    <b-dropdown-item></b-dropdown-item>
                </b-dropdown>
                <b-form-input class="hj-filter-input"></b-form-input>
            </div>
        </div>
    </div>
    <div class="hj-tree"></div>
  </div>
</template>

<script>

export default {
  components: {
    CollapseAllIcon: () => import('@/assets/svg/icon_collapse_all.svg'),
    ExpandAllIcon: () => import('@/assets/svg/icon_expand_all.svg'),
  }

}
</script>

<style lang="scss" scoped>

.hj-container {
  display: flex;
  flex-flow: column;

  > .hj-toolbar {
    flex: 0 0 auto;
    gap: $hj-spacing-small;
    background-color: $hj-background-color-light;
    border-bottom: 1px solid $hj-line-color;
    padding: $hj-spacing-small;

    .hj-tool-icon {
      width: 15px;
      height: 15px;
    }

  }

}

</style>