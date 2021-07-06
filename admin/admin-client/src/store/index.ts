import { defineStore } from 'pinia'

// useStore could be anything like useUser, useCart
export const useStore = defineStore({
  // unique id of the store across your application
  id: 'root-store',
  state: () => ({
    // all these properties will have their type inferred automatically
    sidebarShow: true,
    sidebarMinimized: false
  }),
  actions: {
    toggleSidebarShow () {
      this.sidebarShow = !this.sidebarShow;
    },
    toggleSidebarMinimized () {
      this.sidebarMinimized = !this.sidebarMinimized;
    }
  }
})
