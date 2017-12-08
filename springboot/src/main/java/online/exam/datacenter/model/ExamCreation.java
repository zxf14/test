package online.exam.datacenter.model;

public class ExamCreation {
	private String status;
	private String examID;
	private String password;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExamID() {
		return examID;
	}
	public void setExamID(String examID) {
		this.examID = examID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password; 
	}
	@Override
	public String toString() {
		return "ExamCreation [status=" + status + ", examID=" + examID + ", password=" + password + "]";
	}
	
	
	

}
