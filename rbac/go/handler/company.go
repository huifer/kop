package handler

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"rbac/db"
	"rbac/entity"
	"rbac/request"
	"rbac/utils"
)

// 创建
func CreateCompany(c *gin.Context) {
	// 获取json
	req := request.CompanyCreateRequest{}
	err := c.BindJSON(&req)
	if err != nil {
		company := entity.Company{Name: req.Name}

		db.GetDB().Save(company)

		utils.Ok(c, true)

	}
	utils.Error(c, -1, "创建失败")

}

// 查询
func QueryCompany(c *gin.Context) {
	// 获取请求参数
	query := request.CompanyQuery{}
	err := c.ShouldBindQuery(&query)
	if err != nil {
		return
	}

	pageindex := 1
	pagesize := 5

	compList := make([]entity.Company, 0)

	db.GetDB().Where("name like ?", "%"+query.Name+"%").Offset((pageindex - 1) * pagesize).Limit(pagesize).Find(&compList)
	fmt.Printf("", query)

}

// 修改
func UpdateCompany(c *gin.Context) {

}

// 查看
func ByIdCompany(c *gin.Context) {

}
