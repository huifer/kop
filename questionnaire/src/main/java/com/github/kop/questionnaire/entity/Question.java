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
 * 问题表
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Getter
@Setter
@TableName("question")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 问卷id
     */
    @TableField("survey_id")
    private Integer surveyId;

    /**
     * 1 单选 2多选 3填空
     */
    @TableField("type")
    private Integer type;

    /**
     * 题目名称
     */
    @TableField("name")
    private String name;

    /**
     * 排序号
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 是否必填
     */
    @TableField("require")
    private Integer require;


}
