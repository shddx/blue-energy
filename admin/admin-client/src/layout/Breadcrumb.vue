<template>
  <div class="layout-main-breadcrumb flex layout-main-breadcrumb h-8 leading-8 text-gray-600 relative">
    <div
        class="flex flex-wrap items-center shadow border-b border-gray-100 px-3 overflow-hidden relative z-10 h-8 leading-8 w-full">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/' }">homepage</el-breadcrumb-item>
        <el-breadcrumb-item>promotion management</el-breadcrumb-item>
        <el-breadcrumb-item>promotion list</el-breadcrumb-item>
        <el-breadcrumb-item>promotion detail</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
  </div>
</template>

<script>
export default {
  name: "Breadcrumb"
}
</script>

<style scoped>

</style>
