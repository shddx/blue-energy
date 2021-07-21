<template>
  <div class="layout-main-content flex-1 overflow-hidden p-4">
    <div class="advanced-search bg-white relative shadow text-gray-600 mb-3 px-3 rounded">
      <el-row class="flex justify-between items-center h-12 cursor-pointer" :class="{'border-b': showAdvancedSearch}"
              @click='showAdvancedSearch = !showAdvancedSearch'>
        <span class="flex items-center">Расширенный поиск</span>
        <i :class="advSearchButton.icon"></i>
      </el-row>
      <el-row class="transition-height duration-200 overflow-hidden" :class="searchStyles">
        <el-form ref='form' class='card-list-form' :model='searchForm' size='mini'>
          <el-row :gutter='15' class="p-3">
            <div>
              <el-input v-model='searchForm.contractNumber' placeholder='Номер договора' prefix-icon="el-icon-search"/>
            </div>
            <el-select v-model="searchForm.type" placeholder="Select">
              <el-option
                  v-for="item in ServiceTypes"
                  :key="item"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
            <div>
              <el-input v-model='searchForm.client' placeholder='Имя клиента' prefix-icon="el-icon-search"/>
            </div>
            <el-date-picker v-model='searchForm.signDate' type='daterange' range-separator='до'
                            start-placeholder='От даты'
                            end-placeholder='До даты'/>
          </el-row>
        </el-form>
      </el-row>
    </div>
    <div class="page relative">
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
            align="center" width="minmax(60px, 100px)">
          <template #default="scope">
            <el-button
                size="small"
                icon="el-icon-edit"
                @click="handleEdit(scope.$index, scope.row)"
                circle>
            </el-button>
            <el-button
                size="small"
                icon="el-icon-delete"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)"
                circle>
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script setup lang="ts">
import {computed, ref, reactive} from "vue";
import {useContractStore} from "@/store/modules/contract-module";
import {ServiceTypes} from "@/types";

interface SearchForm {
  contractNumber: string
  client: string
  signDate: string
  type: ServiceTypes
}

const searchForm: SearchForm = reactive({
  contractNumber: '',
  client: '',
  signDate: '',
  type: ServiceTypes.VDGO
})

const store = useContractStore()
store.fetchContracts(1);

const contracts = computed(() => store.contracts);
const activePage = computed(() => store.activePage);
const totalPages = computed(() => store.totalPages);
const showAdvancedSearch = ref(false)
const searchStyles = computed(() => showAdvancedSearch.value ? 'h-20' : 'h-0')
const advSearchButton = computed(() => showAdvancedSearch.value ? {
  icon: 'el-icon-arrow-up',
  text: 'Скрыть'
} : {icon: 'el-icon-arrow-down', text: 'Показать'})

function formatUpdated(row, column, cellValue, index) {
  return cellValue.replace('T', ' ').replace(/\..*/, '');
}

function sortTable({prop, order}) {
  if (prop == null || order === null) {
    store.fetchContracts(activePage.value)
    return
  }
  let direction = order === 'ascending' ? 'asc' : 'desc';
  store.fetchContractsSorted({sort: prop, direction});
}
</script>

<style scoped>
::v-deep(.el-card__header) {
  padding: 7px 15px;
}

.layout-main-content {
  background-color: #f0f2f5;
}
</style>
