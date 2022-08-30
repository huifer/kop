<template>
  <div>
    <!--  头部搜索栏-->
    <div id="head">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="系列名称">
          <el-input v-model="name" placeholder="输入系列名称"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">Query</el-button>
          <el-button type="primary" @click="dialogVisible = true">添加</el-button>
        </el-form-item>
      </el-form>

    </div>
    <!--  表格-->
    <div id="table">
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column label="系列名称" prop="name" width="180"/>
        <el-table-column label="系列图片" prop="image" width="180"/>
        <el-table-column label="排序" prop="order"/>
        <el-table-column label="是否展示" prop="isShow"/>
      </el-table>
      <el-pagination
          v-model:currentPage="curPage"
          v-model:page-size="pageSize"
          :page-sizes="[25, 50, 100]"
          :total="total"
          layout="sizes, prev, pager, next"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </div>

    <!--    添加弹框-->
    <div>
      <el-dialog
          v-model="dialogVisible"
          title="添加系列"
          width="75%"
      >
        <el-form
            ref="ruleFormRef"
            :model="create"
            class="demo-ruleForm"
            label-width="120px"
            status-icon
        >
          <!--系列名称
          系列图片
          排序值
          是否展示-->
          <el-form-item label="系列名称">
            <el-input v-model="create.name" type="textarea"/>
          </el-form-item>
          <el-form-item label="系列图片">
            <el-input v-model="create.image" type="textarea"/>
          </el-form-item>
          <el-form-item label="排序值">
            <el-input v-model="create.order" type="textarea"/>
          </el-form-item>

          <el-form-item label="是否展示">
            <el-switch v-model="create.isShow"/>
          </el-form-item>


          <el-form-item>
            <el-button type="primary" @click="submitForm"
            >创建
            </el-button
            >
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>

  </div>


</template>

<script>

import {craeteCategory, pageCategory} from "../../api/category";

export default {
  name: "GoodsCategory",
  data() {
    return {
      name: "",
      dialogVisible: false,
      create: {
        name: "",
        image: "",
        order: "",
        isShow: true,

      },
      total: 0,
      curPage: 1,
      pageSize: 10,
      tableData: []
    }
  },
  methods: {
    onSubmit() {
      pageCategory(this.curPage, this.pageSize, {name: this.name}).then(
          res => {
            console.log(res);
            this.curPage = res.data.data.current;
            this.total = res.data.data.total;
            this.tableData = res.data.data.records;
          }
      ).catch(e => {
        console.log(e);
      })

    },
    submitForm() {
      console.log(this.create);
      craeteCategory(this.create)
      .then(res => {
        if (res.data.code == 20000) {
          this.dialogVisible = false;
          pageCategory(this.curPage, this.pageSize).then(
              res => {
                console.log(res);
                this.curPage = res.data.data.current;
                this.total = res.data.data.total;
                this.tableData = res.data.data.records;
              }
          ).catch(e => {
            console.log(e);
          })

        }
      });
    },

    handleSizeChange() {
      pageCategory(this.curPage, this.pageSize).then(
          res => {
            console.log(res);
            this.curPage = res.data.data.current;
            this.total = res.data.data.total;
            this.tableData = res.data.data.records;
          }
      ).catch(e => {
        console.log(e);
      })

    },
    handleCurrentChange() {
      pageCategory(this.curPage, this.pageSize).then(
          res => {
            console.log(res);
            this.curPage = res.data.data.current;
            this.total = res.data.data.total;
            this.tableData = res.data.data.records;
          }
      ).catch(e => {
        console.log(e);
      })

    },
  },
  created() {
    pageCategory(this.curPage, this.pageSize).then(
        res => {
          console.log(res);
          this.curPage = res.data.data.current;
          this.total = res.data.data.total;
          this.tableData = res.data.data.records;
        }
    ).catch(e => {
      console.log(e);
    })
  }
}
</script>

<style scoped>

</style>