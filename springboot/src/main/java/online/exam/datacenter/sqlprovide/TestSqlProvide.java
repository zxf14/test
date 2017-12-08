package online.exam.datacenter.sqlprovide;

import org.apache.ibatis.jdbc.SQL;

public class TestSqlProvide {
    public String findTestByID(String examId) {

        return new SQL() {{
            this.SELECT("*").FROM("exam").WHERE("examID = #{examID}");
        }}.toString();
    }

}
