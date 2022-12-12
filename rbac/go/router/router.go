package router

import (
	"github.com/gin-gonic/gin"
	"rbac/handler"
)

func InitRoute() *gin.Engine {
	r := gin.Default()

	r.GET("/beat", handler.Beat)
	r.GET("/error", handler.Error)

	r.POST("/user/create", handler.CreateUser)
	r.POST("/user/update", handler.UpdateUser)
	r.GET("/user/byId", handler.ByIdUser)
	r.GET("/user/query", handler.QueryUser)

	r.POST("/company/create", handler.CreateCompany)
	r.POST("/company/update", handler.UpdateCompany)
	r.GET("/company/byId", handler.ByIdCompany)
	r.GET("/company/query", handler.QueryCompany)

	r.POST("/dept/create", handler.CreateDept)
	r.POST("/dept/update", handler.UpdateDept)
	r.GET("/dept/byId", handler.ByIdDept)
	r.GET("/dept/query", handler.QueryDept)

	return r

}
