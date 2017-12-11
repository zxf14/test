package online.exam.datacenter.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamCreation {
    private String status;
    private String examID;
    private String password;

    @Override
    public String toString() {
        return "ExamCreation [status=" + status + ", examID=" + examID + ", password=" + password + "]";
    }
}
