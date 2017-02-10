package vo;

import java.io.Serializable;

public class MemberShipData implements Serializable {
	private String name, sex, id, password, email;
	private int age;

	public MemberShipData() {
	}

	public MemberShipData(String name, int age, String sex, String email, String id, String password) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.email = email;
		this.id = id;
		this.password = password;
	}

	public MemberShipData(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
