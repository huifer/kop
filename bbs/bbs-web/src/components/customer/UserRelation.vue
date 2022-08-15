<!--用户关系-->
<template>
  <div>
    <el-tabs type="border-card">
      <el-tab-pane label="关注">
      <UserRelationList title="关注"/>
      </el-tab-pane>
      <el-tab-pane label="拉黑">
        <UserRelationList title="拉黑"/>

      </el-tab-pane>
      <el-tab-pane label="我的粉丝">
        <UserRelationList title="我的粉丝" />

      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import UserRelationList from "@/components/customer/UserRelationList";
export default {
  name: "UserRelation",
  components: {UserRelationList}
}
</script>

<style scoped>

</style>