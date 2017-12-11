package online.exam.datacenter.sqlprovide;

import online.exam.datacenter.model.Exam;
import online.exam.datacenter.model.Question;
import org.apache.ibatis.jdbc.SQL;

public class OnlineExamSqlProvide {
    public String createExam(Exam exam) {

        return new SQL() {{
            this.INSERT_INTO("exam").VALUES("course_id, category, description, selections, answer","#{exam.course_id}, #{question.category}, #{question.description}, #{question.selections}, #{question.answer}").SELECT("examID");

        }}.toString();
    }

}
