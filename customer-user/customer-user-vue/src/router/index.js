import {createRouter, createWebHashHistory} from 'vue-router'

const routes = [{
    path: '/register',
    name: 'register',
    component: () =>
        import ('../components/MyRegister.vue')
},
    {
        path: '/blackList',
        name: 'BlackList',
        component: () =>
            import ('../components/BlackList.vue')
    },
    {
        path: '/WhiteList',
        name: 'WhiteList',
        component: () =>
            import ('../components/WhiteList.vue')
    },
    {
        path: '/MyDynamic',
        name: 'MyDynamic',
        component: () =>
            import ('../components/MyDynamic.vue')
    },
    {
        path: '/UserList',
        name: 'UserList',
        component: () =>
            import ('../components/UserList.vue')
    }

]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router;