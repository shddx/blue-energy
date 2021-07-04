import { createStore, StoreOptions } from 'vuex'
import http from '@/api/index.ts'
import { CONTRACTS } from '@/api/routes.ts'
import { Contract } from "@/vuex";

export const store =  createStore({
  state: {
    sidebarShow: true,
    sidebarMinimized: false,
    contracts: Array<Array<Contract>>(),
    pages: 0
  },
  mutations: {
    toggleSidebarShow(state) {
      state.sidebarShow = !state.sidebarShow;
    },
    toggleSidebarMinimized(state) {
      state.sidebarMinimized = !state.sidebarMinimized;
    },
    setContracts(state, { contracts, page }) {
      state.contracts[page] = contracts;
    },
    setPages(state, pages: number) {
      state.pages = pages;
    }
  },
  actions: {
    toggleSidebarShow({commit}) {
      commit('toggleSidebarShow');
    },
    toggleSidebarMinimized({commit}) {
      commit('toggleSidebarMinimized');
    },
    fetchContracts({commit}, page: number) {
      http.get(CONTRACTS(page))
        .then(({ data }) => {
          commit('setContracts', {contracts: data.content, page });
          commit('setPages', data.pages)
        })
        .catch(err => console.log(err))
    }
  },
  modules: {
  },
  getters: {
  }
})
