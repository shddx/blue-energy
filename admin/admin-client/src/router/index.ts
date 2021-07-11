import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Container from '../layout/Container.vue'
import Contracts from '../views/Contracts.vue'
import Houses from '../views/Houses.vue'


const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/contracts',
    name: 'Contract',
    component: Container,
    children: [
      {
        path: 'contracts',
        name: 'Contracts',
        component: Contracts
      },
      {
        path: 'houses',
        name: 'Houses',
        component: Houses
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
