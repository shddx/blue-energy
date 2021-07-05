import { createStore, Store, useStore as baseUseStore } from 'vuex'
import { InjectionKey } from 'vue'

interface State {
  sidebarShow: boolean
  sidebarMinimized: boolean
}

export const key: InjectionKey<Store<State>> = Symbol()

export const store = createStore<State>({
  state: {
    sidebarShow: true,
    sidebarMinimized: false
  },
  mutations: {
    toggleSidebarShow (state) {
      state.sidebarShow = !state.sidebarShow;
    },
    toggleSidebarMinimized (state) {
      state.sidebarMinimized = !state.sidebarMinimized;
    }
  },
  actions: {
    toggleSidebarShow ({commit}) {
      commit('toggleSidebarShow');
    },
    toggleSidebarMinimized ({commit}) {
      commit('toggleSidebarMinimized');
    }
  }
})

export function useStore(): Store<State> {
  return baseUseStore(key);
}

declare module '@vue/runtime-core' {
  interface ComponentCustomProperties {
    $store: Store<State>;
  }
}
