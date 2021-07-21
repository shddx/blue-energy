<template>
  <div class="layout-sidebar flex flex-col h-screen transition-width duration-200 shadow overflow-hidden ease-in-out"
       :class='{
                "w-64": collapse === 0,
                "w-16": collapse === 1
            }'>
    <div class="layout-sidebar-logo flex h-12 relative flex-center shadow-lg">Title</div>
    <el-menu
        class="border-r-0"
        :default-active="currentPath"
        :collapse-transition='false'
        text-color="white"
        active-text-color="white"
        :unique-opened='true'
        router="true">
      <el-menu-item index="contracts" class="sidebar-item" route="">
        <i class="el-icon-document"></i>
        <span v-if="collapse === 0">Договоры</span>
      </el-menu-item>
      <el-menu-item index="houses">
        <i class="el-icon-house"></i>
        <span v-if="collapse === 0">Дома</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script setup lang="ts">

import {useStore} from "@/store";
import {computed} from "vue";
import {useRouter} from "vue-router";

const store = useStore();
const collapse = computed(() => store.sidebarCollapse);
const router = useRouter();
const currentPath = computed(() => router.currentRoute.value.path.replace('/', ''))
</script>

<style scoped>
.layout-sidebar {
  background-color: #001529;
}

layout-sidebar .el-menu-item:hover,
.layout-sidebar .el-menu-item.is-active {
  background-color: #409eff;
}

.layout-sidebar-logo {
  background-color: #001529;
  color: #fff;
}

.el-menu-item:hover {
  background-color: black;
  color: white
}

.el-menu {
  background-color: #001529;
}
</style>
