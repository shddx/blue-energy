<template>
  <header class="layout-main-navbar flex justify-between items-center h-12 relative z-10 overflow-hidden">
    <div class="flex items-center px-4 flex-wrap h-12 leading-12">
      <span class="text-2xl cursor-pointer leading-12" :class="navBarIcon" @click="toggleSidebar"/>
    </div>
  </header>
</template>

<script setup lang="ts">
import {useStore} from "@/store";
import {computed} from "vue";

const store = useStore();
const navBarIcon = computed(() => store.sidebarCollapse === 1 ? 'el-icon-s-unfold' : 'el-icon-s-fold')
function toggleSidebar() {
  store.toggleSidebarCollapse(store.sidebarCollapse === 0 ? 1 : 0)
}
</script>

<style scoped>

</style>
