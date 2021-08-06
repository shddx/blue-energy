import {defineStore} from "pinia";
import {Contract, ContractSearchParams, PageParams} from "@/store/interfaces";
import http from "@/api";
import {CONTRACT, CONTRACT_FILTER, CONTRACTS, CONTRACTS_SORTED} from "@/api/routes";

export const useContractStore = defineStore({
    id: 'contract-store',
    state: () => ({
        totalPages: 0,
        activePage: 1,
        pageSize: 10,
        sort: 'contractNumber',
        direction: 'ASC',
        total: 0,
        showEditForm: false,
        contracts: Array<Array<Contract>>(),
        filterActive: false,
        searchParams: {} as ContractSearchParams
    }),
    actions: {
        updateContracts() {
            let pageParams = new PageParams(this.activePage, this.pageSize, this.sort, this.direction);
            if (this.filterActive) {
                this.filterContracts(this.searchParams, pageParams)
            } else {
                this.fetchContracts(pageParams);
            }
        },
        fetchContracts(pageParams: PageParams) {
            http.get(CONTRACTS_SORTED(pageParams))
                .then(({data}) => {
                    this.totalPages = data.pages
                    this.total = data.total
                    this.contracts[pageParams.page] = data.content
                })
                .catch(err => console.log(err));
        },
        filterContracts(searchParams: ContractSearchParams, pageParams: PageParams) {
            http.get(CONTRACT_FILTER(searchParams, pageParams))
                .then(({data}) => {
                    this.totalPages = data.pages;
                    this.total = data.total;
                    this.contracts[this.activePage] = data.content
                })
                .catch(err => console.log(err));
        },
        deleteContract(contract: Contract) {
            http.delete(CONTRACT(contract.id))
                .then(() => this.updateContracts())
                .catch(err => console.log(err));
        },
        updateContract(contract: Contract) {
            http.put(CONTRACT(contract.id), contract)
                .then(() => this.updateContracts())
                .catch(err => console.log(err));
        },
        saveContract(contract: Contract) {
            http.post('contract', contract)
                .then(() => this.updateContracts())
                .catch(err => console.log(err));
        }
    }
})
