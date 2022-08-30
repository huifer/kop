import {createRouter, createWebHashHistory} from 'vue-router'


const routes = [

    {
        path: '/demo1',
        name: '商品管理',
        children: [
            {
                path: '/demo2',
                component: () => import ('../components/GoodsCategory.vue'),
                name: '系列管理',
            },
            {
                path: '/demo3',
                component: () => import ('../components/GoodsPage.vue'),
                name: '商品管理',
            }
        ]
    },

]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router;