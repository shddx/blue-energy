import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Container from '../layout/Container.vue'
import Contracts from '../views/Contracts.vue'

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
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
