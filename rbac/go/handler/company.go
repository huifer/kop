package handler

import (
	"github.com/gin-gonic/gin"
	"rbac/db"
	"rbac/entity"
	"rbac/request"
	"rbac/utils"
)

// 创建
func CreateCompany(c *gin.Context) {
	req := request.CompanyCreateRequest{}
	err := c.BindJSON(req)
	if err != nil {
		company := entity.Company{Name: req.Name}

		db.GetDB().Save(company)

		utils.Ok(c, true)

	}
	utils.Error(c, -1, "创建失败")

}

// 查询
func QueryCompany(c *gin.Context) {

}

// 修改
func UpdateCompany(c *gin.Context) {

}

// 查看
func ByIdCompany(c *gin.Context) {

}
