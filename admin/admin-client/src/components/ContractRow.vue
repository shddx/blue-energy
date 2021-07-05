<template>
  <tr>
    <th scope="row">{{ rowIndex }}</th>
    <td><span class="align-middle">{{contract.number}}</span></td>
    <td>{{contract.type}}</td>
    <td>{{contract.client}}</td>
    <td>{{contract.price}}</td>
    <td>{{contract.signDate}}</td>
    <td>{{contract.endDate}}</td>
    <td v-if="contract">{{ updatedDate }}</td>
    <td class="fit">
      <button type="button" class="btn btn-warning btn-block">
        <i class="cil-pen btn-icon"></i>
      </button>
    </td>
    <td class="fit">
      <button type="button" class="btn btn-danger btn-block">
        <i class="cil-trash btn-icon"></i>
    </button>
    </td>
  </tr>
</template>

<script setup="props" lang="ts">

import type { Contract } from "@/store/interfaces";
import { computed, defineProps, toRefs } from 'vue'
import { contractModule } from "@/store/modules/contract-module";

const props = defineProps<{
  index: number,
  contract: Contract
}>();

const { index } = toRefs(props);
const { contract }= toRefs(props);
const rowIndex = computed(() => (contractModule.activePage - 1) * 10 + index.value + 1)
const updatedDate = computed(() => {
  let updated = contract.value.updated;
  updated = updated.replace('T', ' ')
  return updated.replace(/\..*/, '')
})
</script>

<style scoped>
th,
td {
  vertical-align: middle;
}
 td.fit {
   white-space: nowrap;
   width: 1%;
 }
</style>
