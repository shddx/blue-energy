<template>
  <div class="layout-main-content flex-1 overflow-hidden">
    <div class="page m-3 relative">
      <el-table
          class="shadow"
          :data="contracts[activePage]"
          style="width: 100%"
          @sort-change="sortTable">
        <el-table-column
            type="index"
            label="#">
        </el-table-column>
        <el-table-column
            label="Номер"
            sortable="custom"
            prop="number">
        </el-table-column>
        <el-table-column
            label="Тип"
            prop="type"
            sortable="custom">
        </el-table-column>
        <el-table-column
            label="Клиент"
            prop="client"
            sortable="custom">
        </el-table-column>
        <el-table-column
            label="Сумма"
            prop="price"
            sortable="custom">
        </el-table-column>
        <el-table-column
            label="Подписан"
            prop="signDate"
            sortable="custom">
        </el-table-column>
        <el-table-column
            label="Истекает"
            prop="endDate"
            sortable="custom">
        </el-table-column>
        <el-table-column
            label="Изменен"
            prop="updated"
            sortable="custom"
            :formatter="formatUpdated">
        </el-table-column>
        <el-table-column
            align="right">
          <template #default="scope">
            <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)">Edit
            </el-button>
            <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">Delete
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script setup lang="ts">
import {computed} from "vue";
import {useContractStore} from "@/store/modules/contract-module";

const store = useContractStore()
store.fetchContracts(1);

const contracts = computed(() => store.contracts);
const activePage = computed(() => store.activePage);
const totalPages = computed(() => store.totalPages);

function formatUpdated(row, column, cellValue, index) {
  return cellValue.replace('T', ' ').replace(/\..*/, '');
}

function sortTable({ prop, order }) {
  if (prop == null || order === null) {
    store.fetchContracts(activePage.value)
    return
  }
  let direction = order === 'ascending' ? 'asc' : 'desc';
  store.fetchContractsSorted({sort: prop, direction});
}
</script>

<style scoped>
.layout-main-content {
  background-color: #f0f2f5;
}
</style>
