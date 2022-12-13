package main

import (
	ginzap "github.com/gin-contrib/zap"
	"github.com/swaggo/gin-swagger"
	"github.com/swaggo/gin-swagger/swaggerFiles"
	"go.uber.org/zap"
	"rbac/router"
	"time"
)

func main() {
	logger, _ := zap.NewProduction()

	route := router.InitRoute()
	route.Use(ginzap.Ginzap(logger, time.RFC3339, true))

	// Logs all panic to error log
	//   - stack means whether output the stack info.
	route.Use(ginzap.RecoveryWithZap(logger, true))
	route.GET("/swagger/*any", ginSwagger.WrapHandler(swaggerFiles.Handler))
	route.Run(":9011")

}
