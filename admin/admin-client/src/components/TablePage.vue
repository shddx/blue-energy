<template>
  <div class="layout-main-content flex-1 overflow-hidden p-4">
    <SearchForm />
    <div class="page relative">
      <slot name="table"/>
    </div>
  </div>
</template>

<script>
import SearchForm from "./SearchForm";
export default {
  name: "TablePage",
  components: {SearchForm}
}
</script>

<style scoped>

</style>
