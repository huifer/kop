<!--个人资料-->
<template>
  <div>
    <h2>个人资料</h2>

    <div style="display: flex  ">
      <div style="display: flex; width: 70%">
        <el-form :model="form" label-width="30%" size="large">
          <el-form-item label="用户名 ">
            <el-input v-model="username" disabled/>
          </el-form-item>
          <el-form-item label="昵称">
            <el-input v-model="nickname"/>
          </el-form-item>
          <el-form-item label="注册时间">
            <el-input v-model="register_time"/>
          </el-form-item>
          <div></div>
          <div></div>
        </el-form>
      </div>
      <div style="display: flex;width: 30%">
        <el-avatar :size="50" :src="circleUrl"/>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  name: "MyProfile",
  data() {
    return {
      username: "用户名",
      nickname: "昵称",
      register_time: "注册时间",
      avatar: "头像",
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
    }
  }
}
</script>

<style scoped>

</style>