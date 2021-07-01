import { createApp } from 'vue'

import '@coreui/coreui/dist/css/coreui.min.css'
import '@coreui/coreui/dist/js/coreui.min.js'
import '@coreui/icons/css/free.min.css'
import '@popperjs/core/dist/umd/popper.min.js'

import App from './App.vue'
import router from './router'
import { store } from '@/store'

createApp(App).use(store).use(router).mount('#app')
