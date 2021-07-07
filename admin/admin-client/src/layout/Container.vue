<template>
  <el-container class="app_wrapper">
    <Sidebar/>
    <el-container direction="vertical">
      <Header/>
      <Breadcrumbs/>
      <el-main>
        <router-view :key="$route.path"></router-view>
      </el-main>
      <Footer/>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
import Sidebar from "./Sidebar.vue";
import Header from "./Header.vue";
import Footer from "./Footer.vue";
import Breadcrumbs from "@/layout/Breadcrumbs.vue";

</script>

<style scoped>
.app_wrapper {
  min-height: 100vh;
  padding: 0;
  margin: 0;
}
</style>
