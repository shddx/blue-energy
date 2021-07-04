import { createStore, StoreOptions } from 'vuex'
import http from '@/api/index.ts'
import { CONTRACTS, CONTRACTS_WITH_SIZE } from '@/api/routes.ts'
import { Contract } from "@/shims-vuex";

export const store = createStore({
  state: {
    sidebarShow: true,
    sidebarMinimized: false,
    contracts: Array<Array<Contract>>(),
    totalPages: 0,
    activePage: 0
  },
  mutations: {
    toggleSidebarShow (state) {
      state.sidebarShow = !state.sidebarShow;
    },
    toggleSidebarMinimized (state) {
      state.sidebarMinimized = !state.sidebarMinimized;
    },
    setContracts (state, {contracts, page}) {
      state.contracts[page] = contracts;
    },
    setPages (state, pages: number) {
      state.totalPages = pages;
    },
    setActivePage (state, page: number) {
      state.activePage = page;
    }
  },
  actions: {
    toggleSidebarShow ({commit}) {
      commit('toggleSidebarShow');
    },
    toggleSidebarMinimized ({commit}) {
      commit('toggleSidebarMinimized');
    },
    fetchContracts ({commit}, page: number) {
      http.get(CONTRACTS_WITH_SIZE(page, 1))
        .then(({data}) => {
          commit('setContracts', {contracts: data.content, page});
          commit('setPages', data.pages)
          commit('setActivePage', page)
        })
        .catch(err => console.log(err))
    }
  },
  modules: {},
  getters: {}
})
