import { ComponentCustomProperties } from 'vue'
import { Store } from 'vuex'

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

declare module '@vue/runtime-core' {
  // declare your own store states
  interface State {
    sidebarShow: boolean,
    sidebarMinimized: boolean
    contracts: Array<Array<Contract>>
    pages: number
  }
  // provide typings for `this.$store`
  interface ComponentCustomProperties {
    $store: Store<State>
  }
}
