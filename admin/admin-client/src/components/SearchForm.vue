<template>
  <div class="advanced-search bg-white relative shadow text-gray-600 mb-3 px-4 rounded">
    <el-row class="flex justify-between items-center h-12 cursor-pointer" :class="{'border-b': showAdvancedSearch}"
            :gutter="15"
            @click='showAdvancedSearch = !showAdvancedSearch'>
      <span class="flex items-center">Расширенный поиск</span>
      <i :class="advSearchButton"></i>
    </el-row>
    <el-row :gutter="15" class="transition-height duration-200 overflow-hidden flex flex-col text-sm"
            :class="searchStyles">
      <slot name="form" />
    </el-row>
  </div>
</template>

<script setup lang="ts">
import {computed, ref} from "vue";
const showAdvancedSearch = ref(false)
const searchStyles = computed(() => showAdvancedSearch.value ? 'h-44' : 'h-0')
const advSearchButton = computed(() => showAdvancedSearch.value ?  'el-icon-arrow-up' : 'el-icon-arrow-down' )
</script>

<style scoped>

</style>
