package entity

import (
	"gorm.io/gorm"
	"rbac/db"
)

type CompanyBindDept struct {
	gorm.Model
	// 资源编码
	CompanyId string `gorm:"column:company_id;NOT NULL"`
	// 资源类型
	DeptId int `gorm:"column:dept_id;NOT NULL"`
}

func (u *CompanyBindDept) CompanyBindDept() string {
	return "company_bind_dept"
}

func init() {
	db.Db.AutoMigrate(&CompanyBindDept{})
}
