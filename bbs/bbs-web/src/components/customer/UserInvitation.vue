<!--用户帖子-->
<template>
  <div>
    <!--    头-->
    <div style="display: flex">
      <div style="line-height: 20px;;display: flex">
        <div style="display: flex;width: 300px;background:#E5EDF2">

          <div style="">
            <span>查看数: </span>
            <span style=" font-size: 16px ;  color: red">100</span>
          </div>
          <div style="padding-left: 30px">
            <span>阅读数: </span>
            <span style=" font-size: 16px ;  color: red">100</span>
          </div>
        </div>

        <div style="padding-left: 20px">帖子名称</div>

      </div>

    </div>

    <UserInvitationComment></UserInvitationComment>
    <UserInvitationComment></UserInvitationComment>
    <UserInvitationComment></UserInvitationComment>


  </div>
</template>

<script>
import UserInvitationComment from "@/components/customer/UserInvitationComment";
export default {
  name: "UserInvitation",
  components: {UserInvitationComment}
}
</script>

<style scoped>

</style>