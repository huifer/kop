<template>
  <!--  <router-view></router-view>-->
  <el-container>

    <el-aside width="200px">
      <el-menu
          class="el-menu-vertical-demo"
          default-active="2"
          router
      >

        <el-menu-item index="/register"
                      route="/register"
        >
          <span>注册页</span>
        </el-menu-item>
        <el-menu-item index="/UserList"
                      route="/UserList">
          <span>用户列表</span>
        </el-menu-item>
        <el-menu-item index="/WhiteList"
                      route="/WhiteList">
          <span>白名单</span>
        </el-menu-item>
        <el-menu-item index="/blackList"
                      route="/blackList">
          <span>黑名单</span>
        </el-menu-item>
        <el-menu-item index="/MyDynamic"
                      route="/MyDynamic">
          <span>动态信息</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>

export default {
  name: 'App',
  components: {}
}
</script>

<style>
</style>
