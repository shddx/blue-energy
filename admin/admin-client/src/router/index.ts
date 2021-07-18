import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Container from '../layout/Container.vue'
import Houses from '../views/Houses.vue'
import ContractsPlus from '../views/Contracts.vue'


const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/contracts',
    name: 'Container',
    component: Container,
    children: [
      {
        path: '/contracts',
        name: 'Contracts',
        component: ContractsPlus
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
