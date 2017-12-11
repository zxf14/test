package online.exam.datacenter.model;

import java.io.Serializable;

import org.joda.time.DateTime;

public class TestInfo implements Serializable {

    private String examName;
    private String course;
    private int questionNum;
    private int questionScore;
    private DateTime startTime;
    private DateTime endTime;

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public int getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(int questionScore) {
        this.questionScore = questionScore;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TestInfo [examName=" + examName + ", course=" + course + ", questionNum=" + questionNum
                + ", questionScore=" + questionScore + ", startTime=" + startTime + ", endTime=" + endTime + "]";
    }


}
