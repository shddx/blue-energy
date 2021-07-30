<template>
  <el-dialog
      title="Tips"
      :model-value="showForm"
      width="40%"
      :before-close="hideForm">
    <el-form v-model="contract">
      <el-form-item label="Номер договора:">
        <el-input v-model.string="contract.number" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Тип договора:">
        <el-select v-model="contract.type" placeholder="Select">
          <el-option
              v-for="item in ServiceTypes"
              :key="item"
              :label="item"
              :value="item">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="Имя клиента:">
        <el-input v-model.string='contract.client' autocomplete="off"/>
      </el-form-item>
      <el-form-item label="Сумма:">
        <el-input v-model.string='contract.price' autocomplete="off"/>
      </el-form-item>
      <el-form-item label="Подписан:">
          <el-date-picker v-model='contract.signDate' type='date'
                          placeholder='Подписан' class="w-full"/>
      </el-form-item>
      <el-form-item label="Истекает:">
          <el-date-picker v-model='contract.endDate' type='date'
                          placeholder='Истекает' class="w-full"/>
      </el-form-item>
    </el-form>
    <template #footer>
    <span class="dialog-footer">
      <el-button @click="hideForm">Cancel</el-button>
      <el-button type="primary" @click="saveContract">Confirm</el-button>
    </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import {defineProps, toRefs, computed} from "vue";
import type {Contract} from "@/store/interfaces";
import {ServiceTypes} from "@/types";
import {useContractStore} from "@/store/modules/contract-module";

const store = useContractStore();
const showForm = computed(() => store.showEditForm);

const props = defineProps<{
  contract: Contract
}>();
const {contract} = toRefs(props);

function saveContract() {
  store.saveContract(contract.value);
  hideForm();
}

function hideForm() {
  store.showEditForm = false;
}

</script>

<style scoped>

</style>
