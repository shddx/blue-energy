<template>
  <el-dialog
      title="Tips"
      v-model="showForm"
      width="40%">
    <el-form v-model="contract">
      <el-form-item label="Номер договора:">
        <el-input v-model.string="contract.number" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Имя клиента:">
        <el-input v-model.string='contract.client' autocomplete="off"/>
      </el-form-item>
    </el-form>
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
import type {Contract} from "@/store/interfaces";

const props = defineProps<{
  showForm: Boolean,
  contract: Contract
}>();

const { showFrom } = toRefs(props)
</script>

<style scoped>

</style>
