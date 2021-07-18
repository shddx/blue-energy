<template>
  <div class="layout flex h-screen">
    <Sidebar :collapse="collapse"/>
    <LayoutMain @toggleSidebar="toggleSidebar"/>
  </div>
</template>

<script lang="ts">
import Sidebar from "./Sidebar.vue";
import LayoutMain from "./MainContent.vue";
export default {
  name: "Container",
  components: {LayoutMain, Sidebar}
}
</script>

<style scoped>

</style>
