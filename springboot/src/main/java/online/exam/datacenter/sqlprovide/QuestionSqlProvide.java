package online.exam.datacenter.sqlprovide;

import org.apache.ibatis.jdbc.SQL;


public class QuestionSqlProvide {

    public String findByQuestionID(String questionID) {

        return new SQL() {{
            this.SELECT("*").FROM("question").WHERE("questionID = #{questionID}");
        }}.toString();
    }

    public String findByCidCategory(long course_id, String category) {

        return new SQL() {{
            this.SELECT("*").FROM("question").WHERE("course_id = #{course_id}")
                    .WHERE("category = #{category}");
        }}.toString();
    }
}
