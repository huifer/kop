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
 * 问题选项表
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Getter
@Setter
@TableName("option")
public class Option implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 问卷id
     */
    @TableField("survey_id")
    private Integer surveyId;

    /**
     * 问题表
     */
    @TableField("question_id")
    private Integer questionId;

    /**
     * 选项名称
     */
    @TableField("name")
    private String name;


}
