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
            <th scope="col" @click="sortBy('number')">Номер</th>
            <th scope="col" @click="sortBy('type')">Тип</th>
            <th scope="col" @click="sortBy('client')">Клиент</th>
            <th scope="col" @click="sortBy('price')">Сума</th>
            <th scope="col" @click="sortBy('signDate')">Подписан</th>
            <th scope="col" @click="sortBy('endDate')">Истекает</th>
            <th scope="col" @click="sortBy('updated')">Изменен</th>
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
      <Pagination/>
    </div>
  </div>
</template>

<script lang="ts">
import ContractRow from "@/components/ContractRow.vue";
import { mapState } from "vuex";
import Pagination from "@/components/Pagination.vue";
import { defineComponent } from "vue";

export default defineComponent({
  name: "Contracts",
  components: { Pagination, ContractRow},
  data () {
    return {
      currentSort: 'number',
      currentSortDir: true
    }
  },
  computed: {
    ...mapState([
      'contracts',
      'activePage'
    ])
  },
  methods: {
    sortBy(sort: string) {
      if (this.currentSort === sort) {
        this.currentSortDir = !this.currentSortDir;
      } else {
        this.currentSort = sort;
      }
      let direction = this.currentSortDir ? 'asc' : 'desc';
      this.$store.dispatch('fetchContractsSorted', { sort, direction} );
    }
  },
  created () {
    this.$store.dispatch('fetchContracts', 1)
  }
})
</script>

<style scoped>
.table th.fit {
  white-space: nowrap;
  width: 1%;
}
</style>
