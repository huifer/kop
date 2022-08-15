<!--用户帖子单个-->
<template>
  <div>
    <el-card class="box-card " style="margin-top: 30px ;width: 100% ">
      <div style="">

        <div style="display: flex">
          <div style="width: 50px">
            <div style="">
              <el-avatar :size="50" :src="circleUrl"/>
            </div>

          </div>

          <div style="padding-left: 20px ;width: 100%">
            <div style="display: flex ;    justify-content: space-between;">

              <div>
                <div style="font-size: 18px">张三</div>
                <div>
                  <div style="font-size: 14px">1天前</div>
                </div>
              </div>


              <div style="">
                <div style="display:flex;  ">
                  <div style="font-size: 16px">
                    <span>访问数</span>
                    <span>100</span>
                  </div>
                </div>
                <div>
                  <div style="font-size: 16px">
                    <span>回复数</span>
                    <span>100</span>
                  </div>
                </div>
              </div>


            </div>


            <div style="margin-top: 10px ; border-top: 1px solid #ebebeb; padding-top: 10px">
              <div>帖子标题</div>
              <div>帖子内容</div>
            </div>
            <div style="margin-top: 10px ;  border-top: 1px solid #ebebeb;padding-top: 10px">
              <div style="display: flex ">
                <div class="c"
                     style=" text-align: center;align-items: center;justify-content: center;flex: 1 1 33.333%;position: relative">
                  <span>最后评论人: </span>
                  <span>张三</span>
                </div>
                <div
                    style=" text-align: center;align-items: center;justify-content: center;flex: 1 1 33.333%;position: relative">
                  <span>最后评论时间: </span>
                  <span>2022-01-01 20:20:02</span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div
            style="display: flex;margin-top: 10px; padding-top: 10px;    border-top: 1px solid #ebebeb;  ">
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
            <span style="">分析</span>
          </div>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "UserInvitationListSinglet"
}
</script>

<style scoped>
.c :after {
  content: "";
  position: absolute;
  top: 50%;
  right: 0;
  margin-top: -1rem;
  width: 1px;
  height: 2rem;
  background-color: #ebebeb;


}

.c:before {
  content: "";
  position: absolute;
  top: 50%;
  right: 0;
  margin-top: -1rem;
  width: 1px;
  height: 2rem;
  background-color: #ebebeb;


}
</style>