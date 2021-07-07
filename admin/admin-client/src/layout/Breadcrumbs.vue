<template>
    <el-breadcrumb class="app_breadcrumbs" separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">homepage</el-breadcrumb-item>
      <el-breadcrumb-item>promotion management</el-breadcrumb-item>
      <el-breadcrumb-item>promotion list</el-breadcrumb-item>
      <el-breadcrumb-item>promotion detail</el-breadcrumb-item>
    </el-breadcrumb>
</template>

<script lang="ts">
export default {
  name: "Breadcrumbs"
}
</script>

<style scoped>
.app_breadcrumbs {
  display:flex;
  flex-wrap: wrap;
  height: 60px;
  border-bottom: 1px solid #d8dbe0;
  padding-left: 1.4rem;
  align-items: center;
}
</style>
