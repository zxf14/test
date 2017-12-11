package online.exam.datacenter.mapper;

import online.exam.datacenter.model.Question;
import online.exam.datacenter.sqlprovide.OnlineExamSqlProvide;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import online.exam.datacenter.model.TestInfo;
import online.exam.datacenter.sqlprovide.TestSqlProvide;

public interface OnlineExamMapper {
    @SelectProvider(type = TestSqlProvide.class, method = "findTestByID")
    TestInfo findTestByID(@Param("examID") String examID);

    @InsertProvider(type = OnlineExamSqlProvide.class, method = "createQuestion")
    void createStudent(@Param("question") Question question);

}
