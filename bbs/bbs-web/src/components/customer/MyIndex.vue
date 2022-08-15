<!--个人首页-->
<template>
<div>
  <el-tabs type="border-card">

    <el-tab-pane label="我的动态">
      <!--        <UserDynamicListSinglet></UserDynamicListSinglet>-->
      <user-dynamic-list-singlet></user-dynamic-list-singlet>
      <user-dynamic-list-singlet></user-dynamic-list-singlet>
      <user-dynamic-list-singlet></user-dynamic-list-singlet>
      <user-dynamic-list-singlet></user-dynamic-list-singlet>
      <user-dynamic-list-singlet></user-dynamic-list-singlet>
    </el-tab-pane>
    <el-tab-pane label="我的帖子">
      <user-invitation-list-singlet></user-invitation-list-singlet>
      <user-invitation-list-singlet></user-invitation-list-singlet>
    </el-tab-pane>
    <el-tab-pane label="收藏">
      <UserCollection></UserCollection>
    </el-tab-pane>
  </el-tabs>
</div>
</template>

<script>
import UserInvitationListSinglet from "@/components/customer/UserInvitationListSinglet";
import UserDynamicListSinglet from "@/components/customer/UserDynamicListSinglet";
import UserCollection from "@/components/customer/UserCollection";

export default {
  name: "MyIndex",
  components: {UserCollection, UserInvitationListSinglet, UserDynamicListSinglet},

}
</script>

<style scoped>

</style>