<template>
  <div>
    <el-container>


      <el-aside width="200px">
        <el-menu
            class="el-menu-vertical-demo"
            default-active="/demo3"
            router="true"
        >

          <el-sub-menu v-for="(it , index) in routes" :key="index" :index="it.path">
            <template #title>
              <span>{{ it.name }}</span>
            </template>
            <!-- 二级菜单 -->
            <el-menu-item
                v-for="item2 in it.children"
                :key="item2.id"
                :index="item2.path"
            >{{ item2.name }}
            </el-menu-item>
          </el-sub-menu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>

</template>

<script>
export default {

  name: 'App',
  data() {
    return {
      routes: [],

    }
  },
  components: {},
  created() {
    this.routes = this.$router.options.routes;
  }
}
</script>

<style>
</style>
