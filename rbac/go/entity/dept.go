package entity

import (
	"gorm.io/gorm"
	"rbac/db"
)

type Dept struct {
	gorm.Model
	Name string `gorm:"column:name;NOT NULL"`
}

func (u *Dept) Dept() string {
	return "dept"
}

func init() {
	db.Db.AutoMigrate(&Dept{})
}
