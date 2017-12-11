package online.exam.datacenter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Exam {
    private Long examID;
    private String startTime;
    private String endTime;
    private int questionNum;
    private int questionScore;
    private String examName;
    private String course;
    private String groupBy;
    private String participants;

}
