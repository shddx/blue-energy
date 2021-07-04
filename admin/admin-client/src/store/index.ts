import { createStore, useStore as baseUseStore, Store } from 'vuex'
import http from '@/api/index.ts'
import { CONTRACTS_SORTED, CONTRACTS_WITH_SIZE } from '@/api/routes.ts'
import { InjectionKey } from 'vue'

export interface Contract {
  id: string,
  number: string,
  type: string,
  client: string,
  price: number
  signDate: string,
  endDate: string,
  updated: string
}

interface State {
  sidebarShow: boolean
  sidebarMinimized: boolean
  contracts: Contract[][]
  totalPages: number
  activePage: number
}

export const key: InjectionKey<Store<State>> = Symbol()

export const store = createStore<State>({
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
      http.get(CONTRACTS_WITH_SIZE(page, 10))
        .then(({data}) => {
          commit('setContracts', {contracts: data.content, page});
          commit('setPages', data.pages)
          commit('setActivePage', page)
        })
        .catch(err => console.log(err))
    },
    fetchContractsSorted ({ state, commit }, { sort, direction }) {
      http.get(CONTRACTS_SORTED(state.activePage, 10, sort, direction))
        .then(({ data }) => {
          console.log(data)
          commit('setContracts', {contracts: data.content, page: state.activePage})
        })
        .catch(err => console.log(err))
    }
  },
  modules: {},
  getters: {}
})

export function useStore(): Store<State> {
  return baseUseStore(key);
}

declare module '@vue/runtime-core' {
  interface ComponentCustomProperties {
    $store: Store<State>;
  }
}
