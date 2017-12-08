package online.exam.datacenter.mapper;

import online.exam.datacenter.model.Question;
import online.exam.datacenter.sqlprovide.QuestionSqlProvide;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface QuestionMapper {

    @SelectProvider(type = QuestionSqlProvide.class, method = "findByQuestionID")
    Question findByQuestionID(@Param("questionID") String questionID);

    @SelectProvider(type = QuestionSqlProvide.class, method = "findByCidCategory")
    List<Question> findQuestions(@Param("course_id") long course_id, @Param("category") String category);
}
