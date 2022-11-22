package router

import (
	"github.com/gin-gonic/gin"
	"rbac/handler"
)

func InitRoute() *gin.Engine {
	r := gin.Default()

	r.GET("/beat", handler.Beat)
	r.GET("/error", handler.Error)
	return r

}
