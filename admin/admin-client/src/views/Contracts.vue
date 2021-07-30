<template>
  <TablePage>
    <template #form>
      <el-form :model='searchForm' size='mini'>
        <el-row :gutter='15' class="py-2" justify="start">
          <el-col :xs='24' :sm='12' :xl='10'>
            <el-form-item label="Номер договора:">
              <el-input v-model='searchForm.contractNumber' placeholder='Номер договора'
                        prefix-icon="el-icon-search"/>
            </el-form-item>
          </el-col>
          <el-col :xs='24' :sm='12' :xl='10'>
            <el-form-item label="Имя клиента:">
              <el-input :model='searchForm.client' placeholder='Имя клиента' prefix-icon="el-icon-search"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter='15'>
          <el-col :xs='24' :sm='12' :xl='10'>
            <el-form-item label="Подписан:">
              <el-row justify="start">
                <el-col :xs="24" :sm="11" :xl="11">
                  <el-form-item prop="signDateLower">
                    <el-date-picker v-model='searchForm.signDateLower' type='date'
                                    placeholder='От даты' class="w-full"/>
                  </el-form-item>
                </el-col>
                <el-col class="hidden-xs-only text-center" :sm="2" :xl="2">-</el-col>
                <el-col :xs="24" :sm="8" :xl="11">
                  <el-form-item prop="signDateUpper">
                    <el-date-picker v-model='searchForm.signDateUpper' type='date'
                                    placeholder='До даты' class="w-full"/>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form-item>
          </el-col>
          <el-col :xs='24' :sm='12' :xl='10'>
            <el-form-item label="Тип договора:">
              <el-select v-model="searchForm.type" placeholder="Select">
                <el-option
                    v-for="item in ServiceTypes"
                    :key="item"
                    :label="item"
                    :value="item">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :xs='24' :sm='20' :xl='20'>
            <el-row justify="start">
              <el-button type="primary" icon="el-icon-search">Искать</el-button>
            </el-row>
          </el-col>
        </el-row>
      </el-form>
    </template>
    <template #table>
      <el-scrollbar max-height="75vh">
        <el-table
            class="shadow"
            :data="contracts[activePage]"
            style="width: 100%"
            @sort-change="sortTable">
          <el-table-column type="index" label="#"/>
          <el-table-column label="Номер" sortable="custom" prop="number"/>
          <el-table-column label="Тип" prop="type" sortable="custom"/>
          <el-table-column label="Клиент" prop="client" sortable="custom"/>
          <el-table-column label="Сумма" prop="price" sortable="custom"/>
          <el-table-column label="Подписан" prop="signDate" sortable="custom"/>
          <el-table-column label="Истекает" prop="endDate" sortable="custom"/>
          <el-table-column label="Изменен" prop="updated" sortable="custom" :formatter="formatUpdated"/>
          <el-table-column
              align="center" width="minmax(60px, 100px)">
            <template #header>
              <el-button
                  type="primary"
                  icon="el-icon-document-add">Создать
              </el-button>
            </template>
            <template #default="scope">
              <el-button
                  @click.prevent="showContractForm(scope.$index, scope.row)"
                  size="mini"
                  icon="el-icon-edit"
                  round>
              </el-button>
              <el-button
                  @click.prevent="deleteContract(scope.$index, scope.row)"
                  size="mini"
                  icon="el-icon-delete"
                  type="danger"
                  round>
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-scrollbar>
      <el-pagination
          layout="prev, pager, sizes, next"
          @current-change="updateTable"
          @size-change="updateSize"
          :page-sizes='[10, 20, 50, 100]'
          :page-size="pageSize"
          :total="total"
          :current-page="activePage"
          :page-count="totalPages">
      </el-pagination>
    </template>
  </TablePage>
  <ContractForm :contract="contractToEdit" />
</template>

<script setup lang="ts">
import TablePage from "@/components/TablePage.vue";
import {ServiceTypes} from "@/types";
import {computed, reactive, ref} from "vue";
import {useContractStore} from "@/store/modules/contract-module";
import type {Contract} from "@/store/interfaces";
import ContractForm from "@/components/ContractForm.vue";

interface SearchForm {
  contractNumber: string
  client: string
  signDateLower: string
  signDateUpper: string
  type: ServiceTypes
}

const searchForm: SearchForm = reactive({
  contractNumber: '',
  client: '',
  signDateLower: '',
  signDateUpper: '',
  type: ServiceTypes.VDGO
})
const store = useContractStore()
store.fetchContracts(1);
const showForm = ref(false)
const contracts = computed(() => store.contracts);
const activePage = computed(() => store.activePage);
const totalPages = computed(() => store.totalPages);
const pageSize = computed(() => store.pageSize);
const total = computed(() => store.total);
const contractToEdit = ref<Contract>({
  id: '',
  number: '',
  type: '',
  client: '',
  price: 0,
  signDate: '',
  endDate: '',
  updated: ''
});

function test() {
  console.log('test')
}

function formatUpdated(row: number, column: number, cellValue: string) {
  return cellValue.replace('T', ' ').replace(/\..*/, '');
}

function deleteContract(id: number, contract: Contract) {
  store.deleteContract(contract);
}

function updateSize(newSize: number) {
  store.pageSize = newSize;
  store.updateContracts();
}

function showContractForm(row: number, contract: Contract) {
  store.showEditForm = true;
  contractToEdit.value = contract;
}

function updateTable(page: number) {
  store.activePage = page;
  store.updateContracts();
}

function sortTable({prop, order}: { prop: string | null, order: string | null }) {
  if (prop == null || order == null) {
    store.fetchContracts(activePage.value)
    return
  }
  let direction = order === 'ascending' ? 'asc' : 'desc';
  store.fetchContractsSorted({sort: prop, direction});
}
</script>

<style scoped>
::v-deep(.el-select),
::v-deep(.el-date-editor.el-input),
::v-deep(.el-date-editor.el-input__inner) {
  width: 100%;
}

.layout-main-content {
  background-color: #f0f2f5;
}
</style>
