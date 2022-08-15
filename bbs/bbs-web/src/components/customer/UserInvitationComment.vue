<template>
  <div style="">
    <!--      如果是回复帖子评论-->
    <div style="display: flex;margin-top: 10px; border:3px solid #ebebeb  ;height: 300px">
      <div style="line-height: 20px;width: 300px;border-right:3px solid #ebebeb ">
        <!--          左侧用户-->

        <div>用户名</div>

        <div style="margin-top: 10px">
          <img alt="" src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
               style="width: 100px;height: 100px">
        </div>

      </div>


      <div style="flex: 1; height: 300px">
        <div style=" height: 30px;  width: 100%;border-bottom: 3px solid #ebebeb ;">
          <span>发表于</span>
          <span> 2021-6-2 11:52</span>
        </div>
        <div style="height: calc(300px - 30px - 30px)">
          <a style="color: #329898">@张三</a>，你好
        </div>
        <div style="height: 30px">
          <!--          按钮区域-->
          <div style="display: flex; ;    border-top: 3px solid #ebebeb;  ">
            <div class="c"
                 style=" text-align: center;align-items: center;justify-content: center;flex: 1 1 33.333%;position: relative">
              <span style="">点赞</span>
            </div>
            <div class="c"
                 style=" text-align: center;align-items: center;justify-content: center;flex: 1 1 33.333%;position: relative">
              <span style="">评论</span>
            </div>
            <div
                style=" text-align: center;align-items: center;justify-content: center;flex: 1 1 33.333%;position: relative">
              <span style="">分享</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserInvitationComment"
}
</script>

<style scoped>
.c :after {
  content: "";
  position: absolute;
  top: 50%;
  right: 0;
  margin-top: -1rem;
  width: 3px;
  height: 2rem;
  background-color: #ebebeb;


}

.c:before {
  content: "";
  position: absolute;
  top: 50%;
  right: 0;
  margin-top: -1rem;
  width: 3px;
  height: 2rem;
  background-color: #ebebeb;



}
</style>