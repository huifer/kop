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
 * 问卷结果表
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Getter
@Setter
@TableName("answer")
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 问卷历史id
     */
    @TableField("survey_history_id")
    private Integer surveyHistoryId;

    /**
     * 问题id
     */
    @TableField("question_id")
    private Integer questionId;

    /**
     * 选项id
     */
    @TableField("option_id")
    private Integer optionId;

    /**
     * 选项内容
     */
    @TableField("option_content")
    private String optionContent;

    /**
     * 答题人
     */
    @TableField("user_id")
    private Integer userId;


}
