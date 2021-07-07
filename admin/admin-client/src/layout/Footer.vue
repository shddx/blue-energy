<template>
  <el-footer class="app_footer">
    <div><a href="https://coreui.io">CoreUI</a> © 2020 creativeLabs.</div>
    <div>Powered by&nbsp;CoreUI</div>
  </el-footer>
</template>

<script lang="ts">
export default {
  name: "Footer"
}
</script>

<style scoped>
.app_footer {
  display: flex;
  flex: 0 0 50px;
  flex-wrap: wrap;
  align-items: center;
  padding: 0 1rem;
  height: 50px;
  justify-content: space-between;
  border-top: 1px solid #d8dbe0;
  background-color: #d8dbe0;
}
</style>
