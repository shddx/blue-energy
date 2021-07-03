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
          <ContractRow v-for="(contract, index) in contracts"
                       :key="contract.id"
                       :contract="contract"
                       :index="index"/>
          </tbody>
        </table>
      </div>
      <nav aria-label="contract navigation">
        <ul class="pagination">
          <li class="page-item disabled">
            <router-link class="page-link" to="#">Previous</router-link>
          </li>
          <li class="page-item active">
            <router-link class="page-link" to="#">1</router-link>
          </li>
          <li class="page-item">
            <router-link class="page-link" to="#">2</router-link>
          </li>
          <li class="page-item">
            <router-link class="page-link" to="#">3</router-link>
          </li>
          <li class="page-item">
            <router-link class="page-link" to="#">Next</router-link>
          </li>
        </ul>
      </nav>
    </div>
  </div>
</template>

<script>
import ContractRow from "@/components/ContractRow";
import {mapActions, mapState} from "vuex";

export default {
  name: "Contracts",
  components: {ContractRow},
  data() {
    return {}
  },
  computed: {
    ...mapState([
      'contracts'
    ])
  },
  created() {
    this.$store.dispatch('fetchContracts')
  }
}
</script>

<style scoped>
.table th.fit {
  white-space: nowrap;
  width: 1%;
}
</style>
