package online.exam.datacenter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    private String email;

    public Student(String email) {
        this.email = email;
    }

    public Student() {
    }
}
