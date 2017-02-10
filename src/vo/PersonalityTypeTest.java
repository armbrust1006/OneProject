package vo;

import java.io.Serializable;

public class PersonalityTypeTest implements Serializable {
	private int number, age;
	private String question, type, answer, date, id, sex;

	// ���� �������� ( -> ClientTypeTest)
	public PersonalityTypeTest(int number, String question, String answer, String type) {
		this.number = number; // ���� ��ȣ
		this.question = question; // ��������
		this.type = type; // ����
		this.answer = answer; // Ư�� ������ȣ�� ���� ���� ������ Ư¡
	}

	// �˻� ��� (-> Result class <��� ȭ��>)
	public PersonalityTypeTest(String id, String answer, String type) {
		this.id = id; // ���̵�
		this.answer = answer; // ����� ����� ���� ���� Ư¡
		this.type = type; // Ÿ�� 
	}

	// ����, ���̴� ( -> HistogramPanel, HistogramPanel2)
	public PersonalityTypeTest(int age, String sex, String type) {
		this.sex = sex;
		this.age = age;
		this.type = type;
	}

	// ��ü ��� ( -> Recheck <���� �˻系�� ȭ��>)
	public PersonalityTypeTest(String id, String date, String answer, String type) {
		this.date = date;
		this.id = id;
		this.type = type;
		this.answer = answer;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
