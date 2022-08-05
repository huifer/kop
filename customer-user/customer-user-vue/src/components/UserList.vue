<template>
  <div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="名称" prop="name" width="180"/>
      <el-table-column label="联系方式" prop="phone" width="180"/>
      <el-table-column fixed="right" label="操作" width="180">
        <template #default="row">
          <el-button v-if="!row.row.follow" link size="small" type="primary" @click="follower(row)">关注</el-button>
          <el-button v-if="row.row.follow" link size="small" type="primary" @click="follower(row)">取消关注</el-button>

          <el-button v-if="!row.row.black" link size="small" type="danger" @click="black(row)">拉黑</el-button>
          <el-button v-if="row.row.black" link size="small" type="danger" @click="black(row)">取消拉黑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        :total="total"
        background
        class="mt-4"
        layout="prev, pager, next"
        small
        @current-change="handleCurrentChange"
    />

  </div>
</template>

<script>
import {black, cancelBlack, cancelFollower, follower, getUserList} from "@/api/api";

export default {
  name: "UserList",
  data() {
    return {
      total: 0,
      tableData: [],
      curUserId: 1,
      curPage: 0

    }
  },
  methods: {
    handleCurrentChange(e) {
      this.curPage = e;
      getUserList(e, 10, this.curUserId).then(res => {
        this.tableData = res.data.data.records;
        this.total = Number(res.data.data.total);
      }).catch(e => {
        console.log(e);
      })

    },
    page() {
      getUserList(0, 10, this.curUserId).then(res => {
        this.tableData = res.data.data.records;
        this.total = Number(res.data.data.total);
      }).catch(e => {
        console.log(e);
      })
    },
    follower(b) {

      console.log("follower")
      console.log(b);
      //
      if (!b.row.follow) {
        follower(this.curUserId, b.row.userId).then(res => {
          console.log(res);
          getUserList(this.curPage, 10, this.curUserId).then(res => {
            this.tableData = res.data.data.records;
            this.total = Number(res.data.data.total);
          }).catch(e => {
            console.log(e);
          })
        }).catch(e => {
          console.log(e);
        })
      } else {
        cancelFollower(this.curUserId, b.row.userId).then(res => {
          console.log(res);
          getUserList(this.curPage, 10, this.curUserId).then(res => {
            this.tableData = res.data.data.records;
            this.total = Number(res.data.data.total);
          }).catch(e => {
            console.log(e);
          })
        }).catch(e => {
          console.log(e);
        })

      }


    },
    black(b) {
      console.log("black")
      console.log(b);

      if (!b.row.black) {
        black(this.curUserId, b.row.userId).then(res => {
          console.log(res);
          getUserList(this.curPage, 10, this.curUserId).then(res => {
            this.tableData = res.data.data.records;
            this.total = res.data.data.total;
          }).catch(e => {
            console.log(e);
          })
        }).catch(e => {
          console.log(e);
        })
      } else {
        cancelBlack(this.curUserId, b.row.userId).then(res => {
          console.log(res);
          getUserList(this.curPage, 10, this.curUserId).then(res => {
            this.tableData = res.data.data.records;
            this.total = res.data.data.total;
          }).catch(e => {
            console.log(e);
          })
        }).catch(e => {
          console.log(e);
        })

      }

    },
  },
  created() {
    this.page();
  }
}
</script>

<style scoped>

</style>