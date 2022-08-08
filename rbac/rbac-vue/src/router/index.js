import {createRouter, createWebHashHistory} from 'vue-router'


const routes = [
    {
        path: "/",
        redirect: {
            name: '测试页面3'
        }
    },
    {
        path: '/demo1',
        name: '测试页面1',
        children: [
            {
                path: '/demo3',
                component: () => import ('../components/MyTest.vue'),
                name: '测试页面3',
            }
        ]
    },
    {
        path: '/demo2',
        name: '测试页面2',
        children: [

        ]
    }

]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router;