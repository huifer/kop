package com.github.kop.questionnaire.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 问卷表
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Getter
@Setter
@TableName("survey")
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("description")
    private String description;

    /**
     * 1发布 2 未发布
     */
    @TableField("status")
    private Integer status = 0 ;


}
