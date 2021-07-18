import { defineStore } from 'pinia'

// useStore could be anything like useUser, useCart
export const useStore = defineStore({
  // unique id of the store across your application
  id: 'root-store',
  state: () => ({
    // all these properties will have their type inferred automatically
    sidebarCollapse: 0,
    sidebarMinimized: false
  }),
  actions: {
    toggleSidebarCollapse (collapse: number) {
      this.sidebarCollapse = collapse;
    },
    toggleSidebarMinimized () {
      this.sidebarMinimized = !this.sidebarMinimized;
    }
  }
})
