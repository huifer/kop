<!--动态详情-->
<template>
  <div>
    <el-card class="box-card " style="margin-top: 30px ;width: 75% " >
      <div style="width: 300px;">

        <div style="display: flex">
          <div style="">
            <el-avatar :size="50" :src="circleUrl"/>
          </div>

          <div style="padding-left: 10px">
            <div style="font-size: 18px">张三</div>
            <div>
              <div style="font-size: 14px">1天前</div>
            </div>
          </div>
        </div>
        <div style="padding-left: 60px">
          <!--        todo: 字数太多处理-->
          <div style="font-size: 15px;color: #5c6066;">
            我发布了一个动态我发布了一个动态我发布了一个动态我发布了一个动态我发布了一个动态我发布了一个动态我发布了一个动态我发布了一个动态我发布了一个动态我发布了一个动态我发布了一个动态我发布了一个动态
          </div>
        </div>

        <div style="display: flex; padding-top: 10px;    border-top: 1px solid #ebebeb;  ">
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
  name: "UserDynamicListSinglet"
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