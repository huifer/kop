package entity

import (
	"gorm.io/gorm"
	"rbac/db"
)

type Resource struct {
	gorm.Model
	// 资源编码
	Code string `gorm:"column:code;NOT NULL"`
	// 资源类型
	Type int `gorm:"column:type;NOT NULL"`
}

func (u *Resource) Resource() string {
	return "resource"
}

func init() {
	db.Db.AutoMigrate(&Resource{})
}
