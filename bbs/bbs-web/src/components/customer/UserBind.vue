<!--用户绑定界面-->
<template>
  <div>
    <h2>绑定信息</h2>

    <div style="display: flex ;font-size: 1.2rem;
    ">
      <div style="display: flex; padding: 20px 0 ;  ">
        <div style="width: 300px">
          <div style="padding-top: 10px;width: 200px ;height: 30px">微信</div>
          <div style="padding-top: 10px;width: 200px ;height: 30px">钉钉</div>
          <div style="padding-top: 10px;width: 200px ;height: 30px">GitHub</div>
          <div style="padding-top: 10px;width: 200px ;height: 30px">手机号</div>
        </div>

        <div>
          <div style="padding-top: 10px ;width: 200px ;height: 30px">{{ this.wechat }}</div>
          <div style="padding-top: 10px ;width: 200px ;height: 30px">{{ this.dingding }}</div>
          <div style="padding-top: 10px ;width: 200px ;height: 30px">{{ this.github }}</div>
          <div style="padding-top: 10px ;width: 200px ;height: 30px">{{ this.phone }}</div>
        </div>
        <div>
          <div style=" padding-top: 10px  ;width: 200px ;height: 30px   ">
            <el-button>绑定</el-button>
          </div>
          <div style="  padding-top: 10px ;width: 200px ;height: 30px   ">
            <el-button>绑定</el-button>
          </div>
          <div style=" padding-top: 10px  ;width: 200px ;height: 30px   ">
            <el-button>绑定</el-button>
          </div>
          <div style=" padding-top: 10px  ;width: 200px ;height: 30px   ">
            <el-button>绑定</el-button>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserBind",
  data() {
    return {
      wechat: "微信号",
      dingding: "钉钉号",
      github: "github用户名",
      phone: "手机号",

    }
  }
}
</script>

<style scoped>

</style>