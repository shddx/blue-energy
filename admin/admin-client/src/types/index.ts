export interface RouterRecords {
    parentId?: number | string
    id?: number | string
    path: string
    name: string
    redirect?: string
    meta: {
        title: string
        icon: string
    }
    component: (() => Promise<typeof import('*.vue')>) | string
    children?: Array<RouterRecords>
}
export enum ServiceTypes {
    VDGO = 'ВДГО',
    VKGO = 'ВКГО'
}
