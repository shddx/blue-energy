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
            <th scope="col">Номер</th>
            <th scope="col">Тип</th>
            <th scope="col">Клиент</th>
            <th scope="col">Сума</th>
            <th scope="col">Подписан</th>
            <th scope="col">Истекает</th>
            <th scope="col">Изменен</th>
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
    <Pagination />
    </div>
  </div>
</template>

<script lang="ts">
import ContractRow from "@/components/ContractRow";
import {mapActions, mapState} from "vuex";
import Pagination from "@/components/Pagination";

export default {
  name: "Contracts",
  components: {Pagination, ContractRow},
  data() {
    return {
      currentSort: 'index',
      currentSortDir: 'desc'
    }
  },
  computed: {
    ...mapState([
      'contracts',
      'activePage'
    ])
  },
  methods: {
  },
  created() {
    this.$store.dispatch('fetchContracts', 1)
  }
}
</script>

<style scoped>
.table th.fit {
  white-space: nowrap;
  width: 1%;
}
</style>
