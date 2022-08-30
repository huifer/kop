<template>
  <div>
    <!--  搜索框-->
    <div id="head">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item label="系列名称">
          <el-select v-model="categoryName" filterable placeholder="Select">
            <el-option
                v-for="item in options"
                :key="item.id"
                :label="item.name"
                :value="item.name"
            />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">Query</el-button>
          <el-button type="primary" @click="dialogVisible = true">添加</el-button>
        </el-form-item>
      </el-form>

    </div>


    <div>
      <el-dialog
          v-model="dialogVisible"
          title="添加商品"
          width="75%"
      >
        <el-form
            ref="ruleFormRef"
            :model="create"
            class="demo-ruleForm"
            label-width="120px"
            status-icon
        >

          <!--          商品名字
                        商品标题
                        商品展示图
                        商品轮播图
                        商品售价
                        商品介绍
                        排序值
                        开始售卖时间
                        结束结束时间
                        总份额
                        销售量
                        剩余份额
                        公司名称
                        公司头像
                        创作者
                        作品标签
                        所属分类
                        -->

          <el-form-item label="商品名字">
            <el-input v-model="create.name" type="textarea"/>
          </el-form-item>
          <el-form-item label="商品标题">
            <el-input v-model="create.title" type="textarea"/>
          </el-form-item>
          <el-form-item label="商品展示图">
            <el-input v-model="create.image" type="textarea"/>
          </el-form-item>
          <el-form-item label="商品轮播图">
            <el-input v-model="create.images" type="textarea"/>
          </el-form-item>
          <el-form-item label="商品售价">
            <el-input v-model="create.price" type="textarea"/>
          </el-form-item>
          <el-form-item label="商品介绍">
            <el-input v-model="create.content" type="textarea"/>
          </el-form-item>
          <el-form-item label="排序值">
            <el-input v-model="create.order" type="textarea"/>
          </el-form-item>
          <el-form-item label="开始售卖时间">
            <el-input v-model="create.startTime" type="textarea"/>
          </el-form-item>
          <el-form-item label="结束结束时间">
            <el-input v-model="create.endTime" type="textarea"/>
          </el-form-item>
          <el-form-item label="总份额">
            <el-input v-model="create.stock" type="textarea"/>
          </el-form-item>
          <el-form-item label="销售量">
            <el-input v-model="create.sales" type="textarea"/>
          </el-form-item>
          <el-form-item label="剩余份额">
            <el-input v-model="create.surplus" type="textarea"/>
          </el-form-item>
          <el-form-item label="公司名称">
            <el-input v-model="create.companyName" type="textarea"/>
          </el-form-item>
          <el-form-item label="公司头像">
            <el-input v-model="create.companyImage" type="textarea"/>
          </el-form-item>
          <el-form-item label="创作者">
            <el-input v-model="create.creator" type="textarea"/>
          </el-form-item>
          <el-form-item label="作品标签">
            <el-input v-model="create.label" type="textarea"/>
          </el-form-item>
          <el-form-item label="所属分类">
            <el-input v-model="create.goodsCategoryId" type="textarea"/>
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
import {ListCategory} from "../../api/category";

export default {
  name: "GoodsPage",
  data() {
    return {
      categoryName: "",
      options: [],
      dialogVisible: false,
      create: {
        name: "",
        title: "",
        image: "",
        images: "",
        price: "",
        content: "",
        order: "",
        startTime: "",
        endTime: "",
        stock: "",
        sales: "",
        surplus: "",
        companyName: "",
        companyImage: "",
        creator: "",
        label: "",
        goodsCategoryId: "",
      }
    }
  },
  methods: {
    onSubmit() {

    }
  },
  created() {
    ListCategory().then(res => {
      console.log(res);
      this.options = res.data.data
    }).catch(e => {
      console.log(e);
    })

  }
}
</script>

<style scoped>

</style>