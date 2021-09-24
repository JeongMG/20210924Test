package Person;

public class Worker extends Person {
	private String company;
	
	public Worker(String name, Gender gender, String phone, String company) {
		super(name, gender, phone);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "Worker [이름: " + this.getName() + ", 성별: " + this.getGender() + ", 연락처: " + this.getPhone() + ", 직장: " + company +"]";
	}
}
