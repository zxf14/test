package online.exam.datacenter.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import online.exam.datacenter.model.TestInfo;
import online.exam.datacenter.sqlprovide.TestSqlProvide;

public interface TestMapper {
    @SelectProvider(type = TestSqlProvide.class, method = "findTestByID")
    TestInfo findTestByID(@Param("examID") String examID);
}
