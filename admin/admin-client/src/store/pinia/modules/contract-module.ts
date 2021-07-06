import { defineStore } from "pinia";
import { Contract } from "@/store/interfaces";
import http from "@/api";
import { CONTRACTS, CONTRACTS_SORTED } from "@/api/routes";

export const useContractStore = defineStore({
  id: 'contract-store',
  state: () => ({
    totalPages: 0,
    activePage: 0,
    contracts: [[]]
  }),
  actions: {
    fetchContracts (page: number) {
      http.get(CONTRACTS(page, 10))
        .then(({data}) => {
          this.activePage = page
          this.totalPages = data.pages
          this.contracts[page] = data.content
        })
        .catch(err => console.log(err))
    },
    fetchContractsSorted ({sort, direction}: { sort: string; direction: string }) {
      http.get(CONTRACTS_SORTED(this.activePage, 10, sort, direction))
        .then(({ data }) => {
          this.contracts[this.activePage] = data.content
        })
        .catch(err => console.log(err))
    }
  }
})
