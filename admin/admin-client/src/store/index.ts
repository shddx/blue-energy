import { createStore, StoreOptions } from 'vuex'
import http from '@/api/index.ts'
import { CONTRACTS } from '@/api/routes.ts'

export const store =  createStore({
  state: {
    sidebarShow: true,
    sidebarMinimized: false,
    contracts: Object
  },
  mutations: {
    toggleSidebarShow(state) {
      state.sidebarShow = !state.sidebarShow;
    },
    toggleSidebarMinimized(state) {
      state.sidebarMinimized = !state.sidebarMinimized;
    },
    setContracts(state, characters) {
      state.contracts = characters;
    }
  },
  actions: {
    toggleSidebarShow({commit}) {
      commit('toggleSidebarShow');
    },
    toggleSidebarMinimized({commit}) {
      commit('toggleSidebarMinimized');
    },
    fetchContracts({commit}) {
      http.get(CONTRACTS)
        .then(data => {
          console.log(data.data)
          commit('setContracts', data.data)
        })
        .catch(err => console.log(err))
    }
  },
  modules: {
  },
  getters: {
  }
})
