package Person;

public class Student extends Person {
	private String school;
	
	public Student(String name, Gender gender, String phone, String school) {
		super(name, gender, phone);
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	@Override
	public String toString() {
		return "Student [이름: " + this.getName() + ", 성별: " + this.getGender() + ", 연락처: " + this.getPhone() + ", 학교: " + school +"]";
	}
}
