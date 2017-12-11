package online.exam.datacenter.VO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExamResponse {
    private String status;
    private long examID;
    private String password;
}
