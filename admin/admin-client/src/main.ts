import '@popperjs/core/dist/umd/popper.min.js'
import 'element-plus/lib/theme-chalk/index.css';

import App from './App.vue'
import { createApp } from 'vue'
import router from './router'
import { createPinia } from 'pinia'
import ElementPlus from 'element-plus';

createApp(App)
  .use(ElementPlus)
  .use(createPinia())
  .use(router)
  .mount('#app')
