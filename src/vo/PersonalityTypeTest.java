package vo;

import java.io.Serializable;

public class PersonalityTypeTest implements Serializable {
	private int number, age;
	private String question, type, answer, date, id, sex;

	// 문제 가져오기 ( -> ClientTypeTest)
	public PersonalityTypeTest(int number, String question, String answer, String type) {
		this.number = number; // 문제 번호
		this.question = question; // 질문사항
		this.type = type; // 유형
		this.answer = answer; // 특정 문제번호에 따른 성격 유형의 특징
	}

	// 검사 결과 (-> Result class <결과 화면>)
	public PersonalityTypeTest(String id, String answer, String type) {
		this.id = id; // 아이디
		this.answer = answer; // 결과로 도출된 성격 유형 특징
		this.type = type; // 타입 
	}

	// 성별, 나이대 ( -> HistogramPanel, HistogramPanel2)
	public PersonalityTypeTest(int age, String sex, String type) {
		this.sex = sex;
		this.age = age;
		this.type = type;
	}

	// 전체 결과 ( -> Recheck <이전 검사내역 화면>)
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
