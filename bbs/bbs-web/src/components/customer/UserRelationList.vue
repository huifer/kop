<!--用户关系详情-->
<template>
  <div>

    <el-table :data="tableData" height="300" style="width: 100%">
      <el-table-column fixed label="用户名" prop="username" width="150"/>
      <el-table-column label="操作时间" prop="operation_time" width="120"/>
      <el-table-column label="头像" width="120">
        <template #default="scope">
          <img :src="scope.row.avatar" alt="" style="width: 100px;height: 100px">
        </template>

      </el-table-column>

      <el-table-column label="操作" width="100">
        <template v-if="title!='我的粉丝'" #default="scope">
          <el-button size="small" @click="click(scope)"
          >取消{{ title }}
          </el-button>
        </template>
        <template v-if="title=='我的粉丝'">
          <el-button size="small" @click="click(scope)"
          >查看
          </el-button>

        </template>
      </el-table-column>
    </el-table>
    <!--  todo: 分页-->
  </div>
</template>

<script>
export default {
  name: "UserRelationList",
  props: {
    title: String,
  },
  created() {
    console.log(this.title)
  },
  methods: {
    click(row) {
      console.log(row);
    }
  },
  data() {
    return {
      tableData: [
        {
          "username": "张三",
          "operation_time": "2011-11-11 11:11:11",
          "avatar": "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",

        }, {
          "username": "张三",
          "operation_time": "2011-11-11 11:11:11",
          "avatar": "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",

        }
      ]
    }
  }
}
</script>

<style scoped>

</style>