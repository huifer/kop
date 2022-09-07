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
 * 问卷历史表
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Getter
@Setter
@TableName("survey_history")
public class SurveyHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("sv")
    private Integer sv;

    @TableField("survey_id")
    private Integer surveyId;

    /**
     * 1. 使用	0. 未使用
     */
    @TableField("used")
    private Integer used;


}
