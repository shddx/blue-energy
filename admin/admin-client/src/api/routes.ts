export const CONTRACTS = (page: number) => `contract?page=${page}`
export const CONTRACTS_WITH_SIZE = (page: number, size: number) => `contract?page=${page}&size=${size}`
export const CONTRACTS_SORTED = (page?: number, size?: number, sort?: string, direction?: string) => {
  return `contract?page=${page}&size=${size}&sort=${sort},${direction}`
}
export const CONTRACT = (id: string) => `contract/${id}`
