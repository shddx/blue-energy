<template>
  <el-dialog
      title="Tips"
      v-model="showForm"
      width="30%">
    <span>This is a message</span>
    <template #footer>
    <span class="dialog-footer">
      <el-button @click="showForm = false">Cancel</el-button>
      <el-button type="primary" @click="showForm = false">Confirm</el-button>
    </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import {defineProps, toRefs} from "vue";

const props = defineProps<{
  showForm: Boolean
}>();

const { showFrom } = toRefs(props)
</script>

<style scoped>

</style>
