<template>
  <el-header class="app_header">
    <el-menu class="navbar-menu" :default-active="1" mode="horizontal" @select="handleSelect">
      <el-menu-item @click="toggleSidebarShow"><span class="burger" :class="burgerIcon"></span></el-menu-item>
      <el-menu-item index="1">Home</el-menu-item>
      <el-menu-item index="3">Profile</el-menu-item>
    </el-menu>
  </el-header>
</template>

<script setup lang="ts">
import { useStore } from "@/store";
import { computed, ref } from 'vue'

const store = useStore()
const burgerIcon = computed(() => store.sidebarShow ? 'el-icon-s-fold' : 'el-icon-s-unfold')

function toggleSidebarShow () {
  store.toggleSidebarShow()
}

const activeIndex = ref('1');

</script>

<style scoped>
.burger {
  font-size: 1.5rem;
}

.app_header {
  padding-left: 0;
}

.navbar-menu {
  border-bottom: 1px solid #d8dbe0;
}
</style>
