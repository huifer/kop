import {createRouter, createWebHashHistory} from 'vue-router'

const routes = [
  {
    path: '/demo1',
    name: '测试页面1',
    component: () => import ('../components/customer/HelloWorld'),

  },

  {
    path: '/profile',
    name: '个人信息',
    component: () => import ('../components/customer/MyProfile'),

  }, {
    path: '/user_bind',
    name: '用户绑定界面',
    component: () => import ('../components/customer/UserBind'),
  }, {
    path: '/relation',
    name: '用户关系',
    component: () => import ('../components/customer/UserRelation'),

  }, {
    path: '/my_index',
    name: '个人首页',
    component: () => import ('../components/customer/MyIndex'),

  }, {
    path: '/UserInvitation',
    name: '帖子详情',
    component: () => import ('../components/customer/UserInvitation'),

  }, {
    path: '/UserDynamic',
    name: '用户动态',
    component: () => import ('../components/customer/UserDynamic'),

  },
  {
    path: '/collection',
    name: '用户收藏',
    component: () => import ('../components/customer/UserCollection'),

  },
  {
    path: '/bbs_index',
    name: '论坛首页',
    component: () => import ('../components/customer/BbsIndex'),

  }, {
    path: '/category_index',
    name: '板块首页',
    component: () => import ('../components/customer/CategoryIndex'),
  },

  {
    path: '/manager_category',
    name: '管理端板块',
    component: () => import ('../components/manger/ManagerCategory'),
  },

]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router;