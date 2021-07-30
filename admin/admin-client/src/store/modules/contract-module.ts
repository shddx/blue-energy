import {defineStore} from "pinia";
import type {Contract} from "@/store/interfaces";
import http from "@/api";
import {CONTRACT, CONTRACTS, CONTRACTS_SORTED} from "@/api/routes";

export const useContractStore = defineStore({
    id: 'contract-store',
    state: () => ({
        totalPages: 0,
        activePage: 0,
        pageSize: 10,
        total: 0,
        showEditForm: false,
        contracts: Array<Array<Contract>>()
    }),
    actions: {
        updateContracts() {
            this.fetchContracts(this.activePage);
        },
        fetchContracts(page: number) {
            http.get(CONTRACTS(page, this.pageSize))
                .then(({data}) => {
                    this.activePage = page
                    this.totalPages = data.pages
                    this.total = data.total
                    this.contracts[page] = data.content
                })
                .catch(err => console.log(err))
        },
        fetchContractsSorted({sort, direction}: { sort: string; direction: string }) {
            http.get(CONTRACTS_SORTED(this.activePage, this.pageSize, sort, direction))
                .then(({data}) => {
                    this.contracts[this.activePage] = data.content
                })
                .catch(err => console.log(err))
        },
        deleteContract(contract: Contract) {
            http.delete(CONTRACT(contract.id))
                .then(() => this.updateContracts())
                .catch(err => console.log(err));
        }
    }
})
