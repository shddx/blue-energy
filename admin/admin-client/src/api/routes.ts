import {ContractSearchParams, PageParams} from "@/store/interfaces";

export const CONTRACTS_SORTED = (pageParams: PageParams) => {
    return `contract?${pageParams.buildQuery()}`
}
export const CONTRACTS = (page?: number, size?: number) => {
    return `contract?page=${page}&size=${size}`
}
export const CONTRACT = (id: string) => {
    return `contract/${id}`
}
export const CONTRACT_FILTER = (searchParams: ContractSearchParams, pageParams: PageParams) => {
    return `contract/filter?${searchParams.buildSearchQuery()}&${pageParams.buildQuery()}`;
}
