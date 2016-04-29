package in.mhatre.sagar.spring.rest.models;

public class User {
	private int id;
	private String loginId;
	private String passwd;
	private int age;
	private boolean isEmployed; 
	private char gender; 
	private String role; 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getLoginId() {
		return loginId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isEmployed() {
		return isEmployed;
	}

	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginId=" + loginId + ", passwd=" + passwd + ", age=" + age + ", isEmployed="
				+ isEmployed + ", gender=" + gender + ", role=" + role + "]";
	}
	
	

}
