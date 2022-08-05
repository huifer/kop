import {createRouter, createWebHashHistory} from 'vue-router'

const routes = [
    {
        path: '/demo1',
        component: () => import ('../components/MyTest.vue'),
        name: '测试页面1',
        children: []
    },
    {
        path: '/demo2',
        component: () => import ('../components/MyTest.vue'),
        name: '测试页面2',
        children: []
    }

]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router;