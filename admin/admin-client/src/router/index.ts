import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import {RouterRecords} from "@/types/RouterRecords";

const routes: Array<RouterRecords> = [
  {
    path: '/',
    redirect: '/contracts',
    name: 'Container',
    meta: {
      title: 'Home',
      icon: ''
    },
    component: () => import('../layout/Container.vue'),
    children: [
      {
        path: '/contracts',
        name: 'Contracts',
        meta: {
          title: 'Договоры',
          icon: 'el-icon-document'
        },
        component: () => import('../views/Contracts.vue')
      },
      {
        path: 'houses',
        name: 'Houses',
        meta: {
          title: 'Дома',
          icon: 'el-icon-house'
        },
        component: () => import('../views/Houses.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: routes as RouteRecordRaw[]
})

export default router
