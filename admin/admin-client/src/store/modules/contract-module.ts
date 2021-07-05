import { VuexModule, Module, Mutation, Action } from "vuex-class-modules";
import { store } from "@/store";
import http from "@/api";
import { CONTRACTS, CONTRACTS_SORTED } from "@/api/routes";
import { Contract } from "@/store/interfaces";

@Module
class ContractModule extends VuexModule {
  totalPages = 3
  activePage = 1
  contracts: Contract[][] = []

  // getters

  // mutations
  @Mutation
  setContracts (contracts: Contract[]) {
    this.contracts[this.activePage] = contracts;
  }
  @Mutation
  setPages (pages: number) {
    this.totalPages = pages;
  }
  @Mutation
  setActivePage (page: number) {
    this.activePage = page;
  }
  @Action
  async fetchContractsSorted ({sort, direction}: { sort: string; direction: string }) {
    http.get(CONTRACTS_SORTED(this.activePage, 10, sort, direction))
      .then(({ data }) => {
        this.setContracts(data.content)
      })
      .catch(err => console.log(err))
  }

  @Action
  async fetchContracts (page: number) {
    await http.get(CONTRACTS(page, 10))
      .then(({data}) => {
        this.setActivePage(page)
        this.setPages(data.pages)
        this.setContracts(data.content)
      })
      .catch(err => console.log(err))
  }
}

export const contractModule = new ContractModule({ store, name: "contract" });
