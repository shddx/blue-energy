import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import {RouterRecords, ZObject} from "@/types";

const Components:ZObject<() => Promise<typeof import('*.vue')>> = {
  Container: (() => import('@/layout/Container.vue')) as unknown as () => Promise<typeof import('*.vue')>,
  Contracts: (() => import('@/views/Contracts.vue')) as unknown as () => Promise<typeof import('*.vue')>,
  Houses: (() => import('@/views/Houses.vue')) as unknown as () => Promise<typeof import('*.vue')>
}

const routes: Array<RouterRecords> = [
  {
    path: '/',
    redirect: 'contracts',
    name: 'Container',
    meta: {
      title: 'Home',
      icon: ''
    },
    component: Components['Container'],
    children: [
      {
        path: 'contracts',
        name: 'Contracts',
        meta: {
          title: 'Договоры',
          icon: 'el-icon-document'
        },
        component: Components['Contracts']
      },
      {
        path: 'houses',
        name: 'Houses',
        meta: {
          title: 'Дома',
          icon: 'el-icon-house'
        },
        component: Components['Houses']
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: routes as RouteRecordRaw[]
})

export default router
