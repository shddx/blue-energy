<template>
  <tr>
    <th scope="row">{{index + 1}}</th>
    <td><span class="align-middle">{{contract.number}}</span></td>
    <td>{{contract.type}}</td>
    <td>{{contract.client}}</td>
    <td>{{contract.price}}</td>
    <td>{{contract.signDate}}</td>
    <td>{{contract.endDate}}</td>
    <td v-if="contract">{{ updatedDate}}</td>
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

<script lang="ts">

import { Contract } from "@/store/index.ts"
import { defineComponent, PropType } from 'vue'

export default defineComponent({
  name: "ContractRow",
  data() {
    return {
      message: 'Hello'
    }
  },
  props: {
    index: Number,
    contract: {
      type: Object as PropType<Contract>
    }
  },
  computed: {
    updatedDate(): string | undefined {
      let updated = this.contract!.updated;
      updated = updated.replace('T', ' ')
      return updated.replace(/\..*/, '')
    }
  }
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
