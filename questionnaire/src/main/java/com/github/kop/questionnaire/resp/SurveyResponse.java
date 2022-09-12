package com.github.kop.questionnaire.resp;

import com.github.kop.questionnaire.entity.OptionImage;
import com.github.kop.questionnaire.entity.QuestionImage;
import com.github.kop.questionnaire.entity.Survey;
import java.util.List;
import lombok.Data;

@Data
public class SurveyResponse extends Survey {


  private List<QuestionResponse> questionImages;

  @Data
  public static class QuestionResponse extends QuestionImage {

    private List<OptionImage> optionImages;

  }

}
