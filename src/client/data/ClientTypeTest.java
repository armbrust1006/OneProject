package client.data;

import java.util.ArrayList;

import vo.PersonalityTypeTest;

public class ClientTypeTest {
	private ClientManager manager = null;
	private ArrayList<PersonalityTypeTest> typeTest = null; // DB_������

	private ArrayList<Integer> type1 = new ArrayList<>();// �ұ���
	private ArrayList<Integer> type2 = new ArrayList<>();// �ӱ� ���� �Ƿ���
	private ArrayList<Integer> type3 = new ArrayList<>();// ������
	private ArrayList<Integer> type4 = new ArrayList<>();// ������
	private ArrayList<Integer> type5 = new ArrayList<>();// ���������

	private ArrayList<Integer> questionNum = new ArrayList<>(); // ����������ȣ
	private ArrayList<String> question = new ArrayList<>(); // ������������
	private ArrayList<String> answer = new ArrayList<>(); // ��������
	private ArrayList<String> answerType = new ArrayList<>(); // ���信 ������ Ÿ��
	private int state = 0;// ���� ���� Ƚ��
	private int checkState = 0; // ���� Ǭ Ƚ��
	private int[] check = new int[5]; // ��� ������ üũ
	private int max = 0; // ���õ� Ÿ��
	private String typeSelect;
	private String answerSelect;
	private ArrayList<Integer> selectNum;
	private ArrayList<String> selectAnswer;

	public ClientTypeTest(ClientManager manager) {
		this.manager = manager;
		typeTest = manager.memberTest();
		// ���� ���� ���� �Ϸ�
		for (int i = 0; i < 20; i++) {
			InsertTypeTest();
		}
		for (int i = 0; i < 20; i++) {
			makeQuestion();
		}
	}

	// �˻� ��� DB ����
	public String[] requestType() {
		selectNum = new ArrayList<>();
		selectAnswer = new ArrayList<>();
		int maxSelect = 0, selCheck = 0;// �ְ� ���� ���� Ƚ��, ���� Ƚ��
		// ���õ� Ÿ�� ����
		for (PersonalityTypeTest types : typeTest) {
			if (max == type1.size()) {
				if (types.getNumber() == type1.get(0)) {
					typeSelect = types.getType();
					break;
				}
			} else if (max == type2.size()) {
				if (types.getNumber() == type2.get(0)) {
					typeSelect = types.getType();
					break;
				}
			} else if (max == type3.size()) {
				if (types.getNumber() == type3.get(0)) {
					typeSelect = types.getType();
					break;
				}
			} else if (max == type4.size()) {
				if (types.getNumber() == type4.get(0)) {
					typeSelect = types.getType();
					break;
				}
			} else if (max == type5.size()) {
				if (types.getNumber() == type5.get(0)) {
					typeSelect = types.getType();
					break;
				}
			}
		}

		// ������ Ÿ���� �ȳ��� 1�� ���͸�
		for (Integer numbers : questionNum) {
			if (max == type1.size()) {
				selectNum.add(numbers);
			} else if (max == type2.size()) {
				selectNum.add(numbers);
			} else if (max == type3.size()) {
				selectNum.add(numbers);
			} else if (max == type4.size()) {
				selectNum.add(numbers);
			} else if (max == type5.size()) {
				selectNum.add(numbers);
			}
		}

		// ������ Ÿ���� �ȳ��� 2�� ���͸�
		for (int i = 0; i < questionNum.size(); i++) {
			if (questionNum.get(i) == selectNum.get(i)) {
				selectAnswer.add(answerType.get(i));
			}
		}

		// ������ Ÿ���� �ȳ��� 3�� ���͸�
		for (String an : selectAnswer) {
			for (int i = 0; i < selectAnswer.size(); i++) {
				if (an.equals(selectAnswer.get(i))) {
					selCheck++;
				}
			}
			if (maxSelect < selCheck) {
				maxSelect = selCheck;
			}
			selCheck = 0;
		}
		// ������ Ÿ���� �ȳ��� ���� ����
		for (String an : selectAnswer) {
			for (int i = 0; i < selectAnswer.size(); i++) {
				if (an.equals(selectAnswer.get(i))) {
					selCheck++;
				}
			}
			if (maxSelect == selCheck) {
				answerSelect = an;
			}
		}
		String[] ans = { answerSelect, typeSelect };
		return ans;
	}

	// �˻� ��� ����
	public boolean answerCount(ArrayList<String> answer, int checkState) {
		this.answer = answer;
		this.checkState = checkState;
		type1.clear();
		type2.clear();
		type3.clear();
		type4.clear();
		type5.clear();
		for (int i = 0; i < this.answer.size(); i++) {
			if (this.answer.get(i).equals("Y")) {
				int check = questionNum.get(i);
				if (check > 0 && check <= 20) {
					type1.add(check);
				} else if (check > 20 && check <= 40) {
					type2.add(check);
				} else if (check > 40 && check <= 60) {
					type3.add(check);
				} else if (check > 60 && check <= 80) {
					type4.add(check);
				} else if (check > 80 && check <= 100) {
					type5.add(check);
				}
			}
		}
		int cnt = 0;
		check[0] = type1.size();
		check[1] = type2.size();
		check[2] = type3.size();
		check[3] = type4.size();
		check[4] = type5.size();
		max = 0;
		for (int i = 0; i < check.length; i++) {
			if (max < check[i]) {
				max = check[i];
			}
		}
		for (int i = 0; i < check.length; i++) {
			if (max == check[i]) {
				cnt++;
				if (this.checkState == 20) {
					return true;
				} else if (cnt >= 2) {
					return false;
				}
			}
		}
		return true;
	}

	// ���� ������
	public ArrayList<String> getQuestion() {
		return question;
	}

	// ���� ����
	public void makeQuestion() {
		int[] index = new int[5];// ���� ����
		int indexCheck = 0;// ���� ���� üũ
		// ������ ���� ���� ���� ����
		loop: for (int i = 0; i < 5; i++) {
			indexCheck = (int) ((Math.random() * 5) + 1);
			for (Integer j : index) {
				if (j == indexCheck) {
					i--;
					continue loop;
				}
			}
			index[i] = indexCheck;
		}
		// ���� ����Ʈ ����
		for (Integer integer : index) {
			switch (integer) {
			case 1:
				for (PersonalityTypeTest ptt : typeTest) {
					if (type1.get(state).equals(ptt.getNumber())) {
						question.add(ptt.getQuestion());
						answerType.add(ptt.getAnswer());
					}
				}
				questionNum.add(type1.get(state));
				break;
			case 2:
				for (PersonalityTypeTest ptt : typeTest) {
					if (type2.get(state).equals(ptt.getNumber())) {
						question.add(ptt.getQuestion());
						answerType.add(ptt.getAnswer());
					}
				}
				questionNum.add(type2.get(state));
				break;
			case 3:
				for (PersonalityTypeTest ptt : typeTest) {
					if (type3.get(state).equals(ptt.getNumber())) {
						question.add(ptt.getQuestion());
						answerType.add(ptt.getAnswer());
					}
				}
				questionNum.add(type3.get(state));
				break;
			case 4:
				for (PersonalityTypeTest ptt : typeTest) {
					if (type4.get(state).equals(ptt.getNumber())) {
						question.add(ptt.getQuestion());
						answerType.add(ptt.getAnswer());
					}
				}
				questionNum.add(type4.get(state));
				break;
			case 5:
				for (PersonalityTypeTest ptt : typeTest) {
					if (type5.get(state).equals(ptt.getNumber())) {
						question.add(ptt.getQuestion());
						answerType.add(ptt.getAnswer());
					}
				}
				questionNum.add(type5.get(state));
				break;
			} // switch
		} // in for
		state++;
	}

	// ���� ��ȣ ���� ����
	public void InsertTypeTest() {
		type1.add(notOverlap(type1));
		type2.add(notOverlap(type2));
		type3.add(notOverlap(type3));
		type4.add(notOverlap(type4));
		type5.add(notOverlap(type5));
	}

	// ���� ��ȣ ���� ���� �ߺ� üũ
	public int notOverlap(ArrayList<Integer> type) {
		loop: while (true) {
			int check = 0;
			if (type == type1) {
				check = (int) ((Math.random() * 20) + 1);
			} else if (type == type2) {
				check = (int) ((Math.random() * 20) + 21);
			} else if (type == type3) {
				check = (int) ((Math.random() * 20) + 41);
			} else if (type == type4) {
				check = (int) ((Math.random() * 20) + 61);
			} else if (type == type5) {
				check = (int) ((Math.random() * 20) + 81);
			}
			for (Integer integer : type) {
				if (integer == check) {
					continue loop;
				}
			}
			return check;
		}
	}
}
