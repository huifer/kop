package entity

import (
	"gorm.io/gorm"
	"rbac/db"
)

type Company struct {
	gorm.Model
	Name string `gorm:"column:name;NOT NULL"`
}

func (u *Company) Company() string {
	return "company"
}

func init() {
	db.Db.AutoMigrate(&Company{})
}
