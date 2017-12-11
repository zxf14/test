package online.exam.datacenter.sqlprovide;

import online.exam.datacenter.model.Question;
import org.apache.ibatis.jdbc.SQL;

public class OnlineExamSqlProvide {
    public String createQuestion(Question question) {

        return new SQL() {{
            this.INSERT_INTO("question").VALUES("course_id, category, description, selections, answer","#{question.course_id}, #{question.category}, #{question.description}, #{question.selections}, #{question.answer}");
        }}.toString();
    }

}
