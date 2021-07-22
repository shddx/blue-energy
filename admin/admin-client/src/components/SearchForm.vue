<template>
  <div class="advanced-search bg-white relative shadow text-gray-600 mb-3 px-3 rounded">
    <el-row class="flex justify-between items-center h-12 cursor-pointer" :class="{'border-b': showAdvancedSearch}"
            :gutter="15"
            @click='showAdvancedSearch = !showAdvancedSearch'>
      <span class="flex items-center">Расширенный поиск</span>
      <i :class="advSearchButton.icon"></i>
    </el-row>
    <el-row :gutter="15" class="transition-height duration-200 overflow-hidden flex flex-col text-sm"
            :class="searchStyles">
      <slot name="form" />
    </el-row>
  </div>
</template>

<script lang="ts">
export default {
  name: "SearchForm",
  props: {
    showAdvancedSearch: boolean
  }
}
</script>

<style scoped>

</style>
