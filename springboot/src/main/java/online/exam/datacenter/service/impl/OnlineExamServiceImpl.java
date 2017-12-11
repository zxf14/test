package online.exam.datacenter.service.impl;

import online.exam.datacenter.VO.ExamResponse;
import online.exam.datacenter.mapper.OnlineExamMapper;
import online.exam.datacenter.model.Exam;
import online.exam.datacenter.model.Student;
import online.exam.datacenter.service.OnlineExamService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class OnlineExamServiceImpl implements OnlineExamService {
    @Autowired
    private OnlineExamMapper onlineExamMapper;

    @Override
    public List<Student> importFile(InputStream inputStream) throws IOException {
        XSSFSheet xssfSheet = new XSSFWorkbook(inputStream).getSheetAt(0);
        List<Student> students = new ArrayList<Student>();

        //第0行为标题
        for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
            students.add(new Student(xssfRow.getCell(0).getStringCellValue()));;
        }
        return students;
    }

    @Override
    public ExamResponse createExam(Exam exam) {
        onlineExamMapper.createExam(exam);
        return null;
    }


}
