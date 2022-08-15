<!--用户收藏: 1. 帖子，动态-->
<template>
  <div>
    <el-tabs type="border-card">
      <el-tab-pane label="帖子">
        <user-invitation-list-singlet></user-invitation-list-singlet>
        <user-invitation-list-singlet></user-invitation-list-singlet>
        <user-invitation-list-singlet></user-invitation-list-singlet>
      </el-tab-pane>
      <el-tab-pane label="动态">
<!--        <UserDynamicListSinglet></UserDynamicListSinglet>-->
        <user-dynamic-list-singlet></user-dynamic-list-singlet>
        <user-dynamic-list-singlet></user-dynamic-list-singlet>
        <user-dynamic-list-singlet></user-dynamic-list-singlet>
        <user-dynamic-list-singlet></user-dynamic-list-singlet>
        <user-dynamic-list-singlet></user-dynamic-list-singlet>
      </el-tab-pane>

    </el-tabs>
  </div>
</template>

<script>
import UserDynamicListSinglet from "@/components/customer/UserDynamicListSinglet";
import UserInvitationListSinglet from "@/components/customer/UserInvitationListSinglet";
export default {
  name: "UserCollection",
  components: {UserInvitationListSinglet, UserDynamicListSinglet},
}
</script>

<style scoped>

</style>