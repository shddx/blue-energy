import { createStore, StoreOptions } from 'vuex'

export const store =  createStore({
  state: {
    sidebarShow: true,
    sidebarMinimized: false
  },
  mutations: {
    toggleSidebarShow(state) {
      state.sidebarShow = !state.sidebarShow
    },
    toggleSidebarMinimized(state) {
      state.sidebarMinimized = !state.sidebarMinimized
    }
  },
  actions: {
    toggleSidebarShow({commit}) {
      commit('toggleSidebarShow')
    },
    toggleSidebarMinimized({commit}) {
      commit('toggleSidebarMinimized')
    }
  },
  modules: {
  },
  getters: {
  }
})
