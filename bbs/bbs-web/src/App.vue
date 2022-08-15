<template>
  <div>
    <el-container>
      <el-aside width="200px">
        <el-menu
            class="el-menu-vertical-demo"
            default-active="2"
            router
        >
          <el-menu-item v-for="(it ,index ) in routes" :key="index" :index="it.path"
                        :route="it.path">
            <span>{{it.name}}</span>
          </el-menu-item>
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
