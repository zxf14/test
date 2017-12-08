package online.exam.datacenter.model;

public class RandomInfo {

    private Long count;

    private String category;

    private long course_id;

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "RandomInfo{" +
                "count=" + count +
                ", category='" + category + '\'' +
                ", course_id='" + course_id + '\'' +
                '}';
    }
}
