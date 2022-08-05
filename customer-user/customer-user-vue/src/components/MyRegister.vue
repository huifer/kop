<template>
  <div class="demo-input-suffix">
    <el-row :gutter="20">
      <span class="ml-3 w-35 text-gray-600 inline-flex items-center"
      >登录名</span
      >
      <el-input
          v-model="name"
          class="w-50 m-2"
          placeholder="输入登录名"
      />

    </el-row>
    <el-row :gutter="20">
      <span class="ml-3 w-35 text-gray-600 inline-flex items-center"
      >联系方式</span
      >
      <el-input
          v-model="phone"
          class="w-50 m-2"
          placeholder="输入联系方式"
      />

    </el-row>
    <el-row :gutter="20">
      <span class="ml-3 w-35 text-gray-600 inline-flex items-center"
      >性别</span
      >
      <el-input
          v-model="grade"
          class="w-50 m-2"
          placeholder="选择性别"
      />

    </el-row>
    <el-row :gutter="20">
      <span class="ml-3 w-35 text-gray-600 inline-flex items-center"
      >密码</span
      >
      <el-input
          v-model="password"
          class="w-50 m-2"
          placeholder="输入密码"
      />

    </el-row>
    <el-button type="success" @click="register">注册</el-button>
  </div>
</template>

<script>
import {register} from "@/api/api";
import {ElMessage} from "element-plus";

export default {
  name: "my-register",
  data() {
    return {
      name: "",
      phone: "",
      grade: "",
      password: "",

    }
  },
  methods: {
    register() {
      register(this.name, this.phone, this.grade, this.password)
          .then(res => {
            if (res.data.msg) {
              ElMessage({
                showClose: true,
                message: '注册成功',
                center: true,
              });
            } else {
              ElMessage({
                showClose: true,
                message: '注册失败',
                center: true,
              });
            }
          }).catch(e => {
        console.log(e);
      })
    }
  }
}
</script>

<style scoped>

</style>