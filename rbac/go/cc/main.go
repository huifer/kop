package main

import (
	"github.com/gin-gonic/gin"
	"github.com/huifer/rbac/docs"
	swaggerfiles "github.com/swaggo/files"
	ginSwagger "github.com/swaggo/gin-swagger"
	"net/http"
)

// @Summary ping example
// @Schemes
// @Description do ping
// @Tags example
// @Accept json
// @Produce json
// @Success 200 {string} Helloworld
// @Router /example/helloworld [get]
func Helloworld(g *gin.Context) {
	g.JSON(http.StatusOK, "helloworld")
}

func main() {
	r := gin.Default()
	docs.SwaggerInfo.BasePath = "/api/v1"
	v1 := r.Group("/api/v1", gin.Logger(), gin.Recovery())
	{
		v1.GET("/example/helloworld", Helloworld)

	}

	r.GET("/swagger/*any", ginSwagger.WrapHandler(swaggerfiles.Handler))
	r.Run(":8080")

}
