package utils

import (
	"github.com/gin-gonic/gin"
	"net/http"
	"time"
)

type ResultResponse struct {
	Time time.Time   `json:"timed"`
	Code int         `json:"code"`
	Msg  string      `json:"msg"`
	Data interface{} `json:"data"`
}

func Ok(c *gin.Context, data interface{}) {
	if data == nil {
		data = gin.H{}

	}
	response := ResultResponse{}
	response.Time = time.Now()
	response.Code = int(ApiCode.SUCCESS)
	response.Msg = ApiCode.GetMessage(ApiCode.SUCCESS)
	response.Data = data
	c.JSON(http.StatusOK, response)
}
func Error(c *gin.Context, code int, msg string) {
	res := ResultResponse{}
	res.Time = time.Now()
	res.Code = code
	res.Msg = msg
	res.Data = gin.H{}

	c.JSON(http.StatusOK, res)
}
