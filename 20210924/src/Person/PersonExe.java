package Person;

import Person.ScanUtil;

public class PersonExe {
	private static PersonExe singleton = new PersonExe();
	private Person[] persons;

	private PersonExe() {
		persons = new Person[100];
//		persons[0] = new Person("홍길동", Gender.MALE, "1111-1234");
//		persons[1] = new Person("홍길상", Gender.FEMALE, "3333-1234");
//		persons[2] = new Student("김학교", Gender.FEMALE, "5678-1234", "협성고등학교");
//		persons[3] = new Worker("최직장", Gender.MALE, "5432-5678", "예담회사");
	}

	public static PersonExe getInstance() {
		return singleton;
	}

	public void excute() {
		while (true) {
			System.out.println("-------------------------");
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.println("-------------------------");

			int menu = ScanUtil.readInt("메뉴를 선택하세요: ");

			if (menu == 1) {
				System.out.println("====추가 메뉴 입니다.====");
				addPerson();
			} else if (menu == 2) {
				System.out.println("====조회 메뉴 입니다.====");
				showList();
			} else if (menu == 3) {
				System.out.println("====수정 메뉴 입니다.====");
				modify();
			} else if (menu == 4) {
				System.out.println("====삭제 메뉴 입니다.====");
				delete();
			} else if (menu == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		System.out.println("끝.");
	}

	private void addPerson() {
		// Person, Student, Worker
		Person person = null;
		System.out.println("1. Person | 2. Student | 3. Worker");
		int selectType = ScanUtil.readInt("추가할 유형을 선택하여 주십시오: ");
		String name = ScanUtil.readStr("이름을 입력해 주십시오: ");

		System.out.println("1. 남성 | 2. 여성");
		int selectGender = ScanUtil.readInt("성별을 선택해 주십시오: ");
		Gender gender = null;
		if (selectGender == 1) {
			gender = Gender.MALE;
		} else if (selectGender == 2) {
			gender = Gender.FEMALE;
		} else {
			System.out.println("입력이 잘못되었습니다.");
		}

		String phone = ScanUtil.readStr("전화번호를 입력해 주십시오: ");

		if (selectType == 1) {
			person = new Person(name, gender, phone);
		} else if (selectType == 2) {
			String school = ScanUtil.readStr("학교명을 입력해주세요: ");
			person = new Student(name, gender, phone, school);
		} else if (selectType == 3) {
			String company = ScanUtil.readStr("회사명을 입력해주세요: ");
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
		String name = ScanUtil.readStr("조회할 이름 입력해주세요: ");
//		Gender gender = null;
		System.out.println("1. 남성 | 2. 여성");
		String selectGender = ScanUtil.readStr("조회할 성별을 선택해주세요: ");
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
			} // for 문 끝

		}
	}

	private void modify() {
		System.out.println("[목록]");
		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null) {
				System.out.println("[" + i + "] " + persons[i].toString());
			}
		}
		int num = ScanUtil.readInt("수정할 항목을 선택하세요: ");
		if (persons[num] != null) {
			Gender gender = null;
			System.out.println("1. 남성 | 2. 여성");
			String selectGender = ScanUtil.readStr("바꿀 성별을 선택하세요: ");
			if (!selectGender.equals("")) {
				if (selectGender.equals("1")) {
					gender = Gender.MALE;
					persons[num].setGender(gender);
				} else if (selectGender.equals("2")) {
					gender = Gender.FEMALE;
					persons[num].setGender(gender);
				}
			}

			String phone = ScanUtil.readStr("바꿀 전화번호를 입력하세요: ");
			if (!phone.equals("")) {
				persons[num].setPhone(phone);
			}

			if (persons[num] instanceof Student) {
				String school = ScanUtil.readStr("바꿀 학교 명을 입력하세요: ");
				if (!school.equals("")) {
					((Student) persons[num]).setSchool(school);
				}
			} else if (persons[num] instanceof Worker) {
				String company = ScanUtil.readStr("바꿀 직장 명을 입력하세요: ");
				if (!company.equals("")) {
					((Worker) persons[num]).setCompany(company);
				}
			}
			System.out.println("수정 완료!");
		} else {
			System.out.println("존재하지 않는 항목입니다.");
		}
	}

	private void delete() {
		System.out.println("[목록]");
		for (int i = 0; i < persons.length; i++) {
			if (persons[i] != null) {
				System.out.println("[" + i + "] " + persons[i].toString());
			}
		}
		int num = ScanUtil.readInt("삭제할 항목을 선택하세요: ");
		if (persons[num] != null) {
			persons[num] = null;
			System.out.println("삭제 완료");
		} else {
			System.out.println("삭제할 정보가 없습니다.");
		}

	}
}
