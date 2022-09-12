package com.github.kop.questionnaire.req;

import com.github.kop.questionnaire.entity.Survey;
import java.util.List;
import lombok.Data;

@Data
public class CreateSurveyReq extends Survey {

  private List<Integer> questionIds;

}
