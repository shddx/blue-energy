<template>
  <el-aside class="app_sidebar">
    <el-menu
      default-active="contracts"
      class="app_sidebar_menu"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      router="true">
      <el-menu-item index="contracts">
        <i class="el-icon-document"></i>
        <span>Договоры</span>
      </el-menu-item>
      <el-menu-item index="houses">
        <i class="el-icon-house"></i>
        <span>Дома</span>
      </el-menu-item>
    </el-menu>
  </el-aside>
  <!--  <el-aside>-->
  <!--    <div class="c-sidebar c-sidebar-dark c-sidebar-fixed"-->
  <!--         :class="{'c-sidebar-minimized': sidebarMinimized, 'c-sidebar-show': sidebarShow}">-->
  <!--      <ul class="c-sidebar-nav">-->
  <!--        <li class="c-sidebar-nav-title">Nav Title</li>-->
  <!--        <li class="c-sidebar-nav-item">-->
  <!--          <router-link class="c-sidebar-nav-link" to="/contracts">-->
  <!--            <i class="c-sidebar-nav-icon cil-description"></i> Договора-->
  <!--          </router-link>-->
  <!--        </li>-->
  <!--        <li class="c-sidebar-nav-item">-->
  <!--          <router-link class="c-sidebar-nav-link" to="/houses">-->
  <!--            <i class="c-sidebar-nav-icon cil-house"></i> Дома-->
  <!--          </router-link>-->
  <!--        </li>-->
  <!--        <li class="c-sidebar-nav-item c-sidebar-nav-dropdown">-->
  <!--          <a class="c-sidebar-nav-link c-sidebar-nav-dropdown-toggle" href="#">-->
  <!--            <i class="c-sidebar-nav-icon cil-description"></i> Открывающийся список-->
  <!--          </a>-->
  <!--          <ul class="c-sidebar-nav-dropdown-items">-->
  <!--            <li class="c-sidebar-nav-item">-->
  <!--              <a class="c-sidebar-nav-link" href="#">-->
  <!--                <i class="c-sidebar-nav-icon cil-description"></i> Объект списка-->
  <!--              </a>-->
  <!--            </li>-->
  <!--          </ul>-->
  <!--        </li>-->
  <!--      </ul>-->
  <!--      <button class="c-sidebar-minimizer c-brand-minimizer" type="button" @click="toggleSidebarMinimized"></button>-->
  <!--    </div>-->
  <!--  </el-aside>-->
</template>

<script setup lang="ts">
import { useStore } from "@/store";
import { computed } from "vue";

const store = useStore()
const sidebarShow = computed(() => store.sidebarShow)
const sidebarMinimized = computed(() => store.sidebarMinimized)

function toggleSidebarMinimized () {
  store.toggleSidebarMinimized();
}
</script>

<style scoped>
.app_sidebar {
  height: 100%;
}

.app_sidebar_menu {
  height: 100%;
}
</style>
