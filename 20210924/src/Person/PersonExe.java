package Person;

import Person.ScanUtil;

public class PersonExe {
	private static PersonExe singleton = new PersonExe();
	private Person[] persons;

	private PersonExe() {
		persons = new Person[100];
//		persons[0] = new Person("ȫ�浿", Gender.MALE, "1111-1234");
//		persons[1] = new Person("ȫ���", Gender.FEMALE, "3333-1234");
//		persons[2] = new Student("���б�", Gender.FEMALE, "5678-1234", "��������б�");
//		persons[3] = new Worker("������", Gender.MALE, "5432-5678", "����ȸ��");
	}

	public static PersonExe getInstance() {
		return singleton;
	}

	public void excute() {
		while (true) {
			System.out.println("-------------------------");
			System.out.println("1.�߰� 2.��ȸ 3.���� 4.���� 5.����");
			System.out.println("-------------------------");

			int menu = ScanUtil.readInt("�޴��� �����ϼ���: ");

			if (menu == 1) {
				System.out.println("====�߰� �޴� �Դϴ�.====");
				addPerson();
			} else if (menu == 2) {
				System.out.println("====��ȸ �޴� �Դϴ�.====");
				showList();
			} else if (menu == 3) {
				System.out.println("====���� �޴� �Դϴ�.====");
				modify();
			} else if (menu == 4) {
				System.out.println("====���� �޴� �Դϴ�.====");
				delete();
			} else if (menu == 5) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
		System.out.println("��.");
	}

	private void addPerson() {
		// Person, Student, Worker
		Person person = null;
		System.out.println("1. Person | 2. Student | 3. Worker");
		int selectType = ScanUtil.readInt("�߰��� ������ �����Ͽ� �ֽʽÿ�: ");
		String name = ScanUtil.readStr("�̸��� �Է��� �ֽʽÿ�: ");

		System.out.println("1. ���� | 2. ����");
		int selectGender = ScanUtil.readInt("������ ������ �ֽʽÿ�: ");
		Gender gender = null;
		if (selectGender == 1) {
			gender = Gender.MALE;
		} else if (selectGender == 2) {
			gender = Gender.FEMALE;
		} else {
			System.out.println("�Է��� �߸��Ǿ����ϴ�.");
		}

		String phone = ScanUtil.readStr("��ȭ��ȣ�� �Է��� �ֽʽÿ�: ");

		if (selectType == 1) {
			person = new Person(name, gender, phone);
		} else if (selectType == 2) {
			String school = ScanUtil.readStr("�б����� �Է����ּ���: ");
			person = new Student(name, gender, phone, school);
		} else if (selectType == 3) {
			String company = ScanUtil.readStr("ȸ����� �Է����ּ���: ");
			person = new Worker(name, gender, phone, company);
		}

		for (int i = 0; i < persons.length; i++) {
			if (persons[i] == null) {
				persons[i] = person;
				break;
			}
		}
	}

	private void showList() {
		String name = ScanUtil.readStr("��ȸ�� �̸� �Է����ּ���: ");
//		Gender gender = null;
		System.out.println("1. ���� | 2. ����");
		String selectGender = ScanUtil.readStr("��ȸ�� ������ �������ּ���: ");
//		if (selectGender.equals("1")) {
//			gender = Gender.MALE;
//		} else if(selectGender.equals("2")) {
//			gender = Gender.FEMALE;
//		} else if (selectGender.equals("")) {
//			
//		}
		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null) {
				if (!name.equals("") && !selectGender.equals("")) {
					if (selectGender.equals("1")) {
						if (persons[i].getName().indexOf(name) != -1 && persons[i].getGender() == Gender.MALE) {
							System.out.println(persons[i].toString());
						}
					} else if (selectGender.equals("2")) {
						if (persons[i].getName().indexOf(name) != -1 && persons[i].getGender() == Gender.FEMALE) {
							System.out.println(persons[i].toString());
						}
					}
				} else if (!name.equals("")) {
					if (persons[i].getName().indexOf(name) != -1) {
						System.out.println(persons[i].toString());
					}
				} else if (!selectGender.equals("")) {
					if (selectGender.equals("1")) {
						if (persons[i].getGender() == Gender.MALE) {
							System.out.println(persons[i].toString());
						}
					} else if (selectGender.equals("2")) {
						if (persons[i].getGender() == Gender.FEMALE) {
							System.out.println(persons[i].toString());
						}
					}
				} else {
					System.out.println(persons[i].toString());
				}
			} // for �� ��

		}
	}

	private void modify() {
		System.out.println("[���]");
		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null) {
				System.out.println("[" + i + "] " + persons[i].toString());
			}
		}
		int num = ScanUtil.readInt("������ �׸��� �����ϼ���: ");
		if (persons[num] != null) {
			Gender gender = null;
			System.out.println("1. ���� | 2. ����");
			String selectGender = ScanUtil.readStr("�ٲ� ������ �����ϼ���: ");
			if (!selectGender.equals("")) {
				if (selectGender.equals("1")) {
					gender = Gender.MALE;
					persons[num].setGender(gender);
				} else if (selectGender.equals("2")) {
					gender = Gender.FEMALE;
					persons[num].setGender(gender);
				}
			}

			String phone = ScanUtil.readStr("�ٲ� ��ȭ��ȣ�� �Է��ϼ���: ");
			if (!phone.equals("")) {
				persons[num].setPhone(phone);
			}

			if (persons[num] instanceof Student) {
				String school = ScanUtil.readStr("�ٲ� �б� ���� �Է��ϼ���: ");
				if (!school.equals("")) {
					((Student) persons[num]).setSchool(school);
				}
			} else if (persons[num] instanceof Worker) {
				String company = ScanUtil.readStr("�ٲ� ���� ���� �Է��ϼ���: ");
				if (!company.equals("")) {
					((Worker) persons[num]).setCompany(company);
				}
			}
			System.out.println("���� �Ϸ�!");
		} else {
			System.out.println("�������� �ʴ� �׸��Դϴ�.");
		}
	}

	private void delete() {
		System.out.println("[���]");
		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null) {
				System.out.println("[" + i + "] " + persons[i].toString());
			}
		}
		int num = ScanUtil.readInt("������ �׸��� �����ϼ���: ");
		if (persons[num] != null) {
			persons[num] = null;
			System.out.println("���� �Ϸ�");
		} else {
			System.out.println("������ ������ �����ϴ�.");
		}

	}
}
