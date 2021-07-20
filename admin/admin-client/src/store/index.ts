import { defineStore } from 'pinia'
import {Breadcrumb} from "@/store/interfaces";

// useStore could be anything like useUser, useCart
export const useStore = defineStore({
  // unique id of the store across your application
  id: 'root-store',
  state: () => ({
    // all these properties will have their type inferred automatically
    sidebarCollapse: 0,
    sidebarMinimized: false,
    menuList: Array<Breadcrumb>()
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
