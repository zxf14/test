package online.exam.datacenter.service;

import online.exam.datacenter.VO.ExamResponse;
import online.exam.datacenter.model.Exam;
import online.exam.datacenter.model.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface OnlineExamService {

    List<Student> importFile(InputStream valueAs) throws IOException;

    ExamResponse createExam(Exam exam);
}
