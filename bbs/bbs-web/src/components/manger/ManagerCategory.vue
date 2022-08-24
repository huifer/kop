<template>
  <div>
    <el-button type="primary" @click="dialogVisible = true"
    >添加板块
    </el-button
    >
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column label="板块名称" prop="categoryName" width="180"/>
      <el-table-column label="板块图标" prop="categoryIcon" width="180"/>
      <el-table-column label="父板块名称" prop="parentName" width="180"/>
    </el-table>

    <!--    板块添加窗口-->
    <div>
      <el-dialog
          v-model="dialogVisible"
          title="添加板块"
          width="30%"
      >
        <div>
          <el-form :model="form" label-width="120px">
            <el-form-item label="板块名称">
              <el-input v-model="form.categoryName"/>
            </el-form-item>
            <el-form-item label="板块图标">
              <el-input v-model="form.categoryIcon"/>
            </el-form-item>
            <el-form-item label="父板块">
              <el-input v-model="form.parentId"/>
            </el-form-item>
          </el-form>
        </div>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="dialogVisible = false"
        >Confirm</el-button
        >
      </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  name: "ManagerCategory",
  data() {
    return {
      dialogVisible: false,
      tableData: [
        {
          categoryName: "板块1",
          categoryIcon: "",
          parentName: "父板块名称"

        }
      ],
      form: {
        categoryName: "",
        categoryIcon: "",
        parentId: "",

      }

    }
  }
}
</script>

<style scoped>

</style>