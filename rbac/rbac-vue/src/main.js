import {createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

var elementApp = createApp(App);
elementApp.use(ElementPlus);
elementApp.mount('#app')
