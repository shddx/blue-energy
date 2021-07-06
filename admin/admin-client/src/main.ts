import '@coreui/coreui/dist/css/coreui.min.css'
import '@coreui/coreui/dist/js/coreui.min.js'
import '@coreui/icons/css/free.min.css'
import '@popperjs/core/dist/umd/popper.min.js'

import App from './App.vue'
import { createApp } from 'vue'
import router from './router'
import { key, store } from '@/store'
import { createPinia } from 'pinia'

createApp(App).use(createPinia()).use(store, key).use(router).mount('#app')
