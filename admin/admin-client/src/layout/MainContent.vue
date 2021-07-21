<template>
  <div class="layout-main flex flex-1 flex-col overflow-x-hidden overflow-y-auto">
    <Header />
    <Breadcrumb/>
    <router-view :key="$route.path"/>
  </div>
</template>

<script lang="ts">
import Header from "./Header.vue";
import Breadcrumb from "./Breadcrumb.vue";

export default {
  name: "MainContent",
  components: {Breadcrumb, Header},
}
</script>

<style scoped>
</style>
