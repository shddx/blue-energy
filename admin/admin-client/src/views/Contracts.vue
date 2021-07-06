<template>
  <div class="card">
    <div class="card-header">
      <h3 class="h-3"> Список договоров </h3>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <table class="table table-bordered table-hover">
          <thead class="thead-dark">
          <tr>
            <th scope="col">#</th>
            <th scope="col" @click="sortBy('number')"><div class="title-container"><span>Номер</span><i :class="arrowClass('number')"></i></div></th>
            <th scope="col" @click="sortBy('type')"><div class="title-container"><span>Тип</span><i :class="arrowClass('type')"></i></div></th>
            <th scope="col" @click="sortBy('client')"><div class="title-container"><span>Клиент</span><i :class="arrowClass('client')"></i></div></th>
            <th scope="col" @click="sortBy('price')"><div class="title-container"><span>Сума</span><i :class="arrowClass('price')"></i></div></th>
            <th scope="col" @click="sortBy('signDate')"><div class="title-container"><span>Подписан</span><i :class="arrowClass('signDate')"></i></div></th>
            <th scope="col" @click="sortBy('endDate')"><div class="title-container"><span>Истекает</span><i :class="arrowClass('endDate')"></i></div></th>
            <th scope="col" @click="sortBy('updated')"><div class="title-container"><span>Изменен</span><i :class="arrowClass('updated')"></i></div></th>
            <th scope="col" class="fit"></th>
            <th scope="col" class="fit"></th>
          </tr>
          </thead>
          <tbody>
          <ContractRow v-for="(contract, index) in contracts[activePage]"
                       :key="contract.id"
                       :contract="contract"
                       :index="index"/>
          </tbody>
        </table>
      </div>
      <Pagination :totalPages="totalPages" :activePage="activePage" @changeActivePage="changeActivePage"/>
    </div>
  </div>
</template>

<script setup lang="ts">
import { computed } from "vue";
import ContractRow from "@/components/ContractRow.vue";
import { contractModule } from "@/store/modules/contract-module";
import Pagination from "@/components/Pagination.vue";
import { useContractStore } from "@/store/pinia/modules/contract-module";

const store = useContractStore()

let currentSort = 'number'
let sortDirAsc = true
const contracts = computed(() => store.contracts)
const activePage = computed(() => store.activePage)
const totalPages = computed(() => store.totalPages);

//on create
store.fetchContracts(1)

function changeActivePage(num: number) {
  store.fetchContracts(num)
}

function arrowClass(name: string): string {
  return currentSort === name ? sortDirAsc ? 'cil-caret-top' : 'cil-caret-bottom' : '';
}

function sortBy(sort: string) {
  if (currentSort === sort) {
    sortDirAsc = !sortDirAsc;
  } else {
    currentSort = sort;
  }
  let direction = sortDirAsc ? 'asc' : 'desc';
  store.fetchContractsSorted({ sort, direction });
}
</script>

<style scoped>
.table th.fit {
  white-space: nowrap;
  width: 1%;
}

.title-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
