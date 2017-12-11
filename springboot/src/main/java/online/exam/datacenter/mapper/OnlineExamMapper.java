package online.exam.datacenter.mapper;

import online.exam.datacenter.model.Exam;
import online.exam.datacenter.sqlprovide.OnlineExamSqlProvide;
import org.apache.ibatis.annotations.*;

public interface OnlineExamMapper {
    @Insert("insert into exam (startTime, endTime, questionNum, questionScore, examName, course, groupBy, participants, password) values(#{startTime}, #{endTime}, #{questionNum}, #{questionScore}, #{examName}, #{course}, #{groupBy}, #{participants}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int createExam(Exam examInfo);

    @SelectProvider(type = OnlineExamSqlProvide.class, method = "getExam")
    Exam getExam(@Param("examId") int examId);
}
