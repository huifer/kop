package handler

import (
	"github.com/gin-gonic/gin"
	"rbac/utils"
)

func Beat(c *gin.Context) {
	utils.Ok(c, "beat")
	return

}

func Error(c *gin.Context) {
	panic("this is error!")

}
