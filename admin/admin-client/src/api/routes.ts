export const CONTRACTS_SORTED = (page?: number, size?: number, sort?: string, direction?: string) => {
  return `contract?page=${page}&size=${size}&sort=${sort},${direction}`
}
export const CONTRACTS = (page?: number, size?: number) => {
  return `contract?page=${page}&size=${size}`
}
export const CONTRACT = (id: string) => {
  return `contract/${id}`
}
