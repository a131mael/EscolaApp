package org.provasUfsc.aaf.model;

import java.util.List;

/**
 * Created by Abimael Fidencio on 10/11/2016.
 */
public class QuestionsService extends Service{


    public List<Question> getQuestionsByDiscipline(String discipline, String year) {
        String endPoint =  EndPoints.QUESTIONS_BY_YEAR_AND_DISCIPLINE.replace("*1", discipline).replace("*2",year);
        return (List<Question>)getObject(endPoint);
    }

}
