package entity

import (
	"gorm.io/gorm"
	"rbac/db"
)

type UserBindDept struct {
	gorm.Model
	// 资源编码
	UserId string `gorm:"column:user_id;NOT NULL"`
	// 资源类型
	DeptId int `gorm:"column:dept_id;NOT NULL"`
}

func (u *UserBindDept) UserBindDept() string {
	return "user_bind_dept"
}

func init() {
	db.Db.AutoMigrate(&UserBindDept{})
}
