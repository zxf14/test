package online.exam.datacenter.mapper;

import online.exam.datacenter.model.Exam;
import online.exam.datacenter.model.Question;
import online.exam.datacenter.sqlprovide.OnlineExamSqlProvide;
import org.apache.ibatis.annotations.*;

import online.exam.datacenter.model.TestInfo;
import online.exam.datacenter.sqlprovide.TestSqlProvide;

public interface OnlineExamMapper {
    @SelectProvider(type = TestSqlProvide.class, method = "findTestByID")
    TestInfo findTestByID(@Param("examID") String examID);

    @Insert("insert into exam (startTime, endTime, questionNum, questionScore, examName, course, groupBy, participants) values(#{startTime}, #{endTime}, #{questionNum}, #{questionScore}, #{examName}, #{course}, #{groupBy}, #{participants})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int createExam(Exam examInfo);

    @InsertProvider(type = OnlineExamSqlProvide.class, method = "createExam")
    void getExam(@Param("examName") Exam exam);
}
