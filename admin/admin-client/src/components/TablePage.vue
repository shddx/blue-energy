<template>
  <div class="layout-main-content flex-1 overflow-hidden p-4">
    <SearchForm :showAdvancedSearch="false">
        <template #form>
          <slot name="form" />
        </template>
    </SearchForm>
    <div class="page relative">
      <slot name="table"/>
    </div>
  </div>
</template>

<script lang="ts">
import SearchForm from "./SearchForm.vue";
export default {
  name: "TablePage",
  components: {SearchForm}
}
</script>

<style scoped>

</style>
