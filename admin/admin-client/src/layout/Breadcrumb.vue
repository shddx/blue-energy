<template>
  <div class="layout-main-breadcrumb flex layout-main-breadcrumb h-8 leading-8 text-gray-600 relative">
    <div
        class="flex flex-wrap items-center shadow border-b border-gray-100 px-3 overflow-hidden relative z-10 h-8 leading-8 w-full">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <transition-group name="breadcrumb">
          <el-breadcrumb-item v-for='breadcrumb in breadcrumbs' :to="{ path: breadcrumb.path }" :key="breadcrumb.path">{{ breadcrumb.title }}
          </el-breadcrumb-item>
        </transition-group>
      </el-breadcrumb>
    </div>
  </div>
</template>

<script setup lang="ts">
import {useStore} from "@/store";
import {computed} from "vue";
import {useRouter} from "vue-router";

const store = useStore();
const router = useRouter();

const breadcrumbs = computed(() => {
  return router.currentRoute.value.matched.map((record) => {
    let title = record.meta.title
    let path = record.path
    return {title, path};
  })
})
</script>

<style scoped>
.breadcrumb-enter-active,
.breadcrumb-leave-active {
  transition: all 0.5s;
}

.breadcrumb-enter-from,
.breadcrumb-leave-active {
  opacity: 0;
  transform: translateX(20px);
}

.breadcrumb-move {
  transition: all 0.5s;
}

.breadcrumb-leave-active {
  position: absolute;
}
</style>
