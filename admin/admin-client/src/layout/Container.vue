<template>
  <div class="layout flex h-screen">
    <Sidebar />
    <MainContent/>
  </div>
</template>

<script lang="ts">
import Sidebar from "./Sidebar.vue";
import MainContent from "./MainContent.vue";
export default {
  name: "Container",
  components: {MainContent, Sidebar}
}
</script>

<style scoped>

</style>
