package project1.ver06;

import java.util.Scanner;

public class PhoneBookManager
{
	private PhoneInfo[] infoArr;
	//실제 저장된 연락처 개수
	private int numOfFriends;
	
	public PhoneBookManager()
	{
		infoArr = new PhoneInfo[100];
		numOfFriends = 0;
	}
	
	//멤버메소드
	//메뉴출력
	public void printMenu() {
		System.out.println("선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("선택:");
	}
	//입력
	public void dataInput()	{
		Scanner scanner = new Scanner(System.in);
		String iName, iPhone, iMajor, iCompany;
		int iGrade;
		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.print("선택>>");
		int select = scanner.nextInt();
		switch(select) {
		case SubMenuItem.DEFAULT:
			scanner.nextLine();
			System.out.print("이름:");
			iName = scanner.nextLine();
			System.out.print("전화번호:");
			iPhone = scanner.nextLine();
			System.out.println("데이터 입력이 완료되었습니다.");
			
			PhoneInfo pInfo = new PhoneInfo(iName, iPhone);
			infoArr[numOfFriends++] = pInfo;
			break;
		case SubMenuItem.SCHOOL_FRIEND:
			scanner.nextLine();
			System.out.print("이름:");
			iName = scanner.nextLine();
			System.out.print("전화번호:");
			iPhone = scanner.nextLine();
			System.out.print("전공:");
			iMajor = scanner.nextLine();
			System.out.print("학년:");
			iGrade = scanner.nextInt();
			System.out.println("데이터 입력이 완료되었습니다.");
			
			PhoneSchoolInfo pSchoolInfo = new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade);
			infoArr[numOfFriends++] = pSchoolInfo;
			break;
		case SubMenuItem.COWORKER:
			scanner.nextLine();
			System.out.print("이름:");
			iName = scanner.nextLine();
			System.out.print("전화번호:");
			iPhone = scanner.nextLine();
			System.out.print("회사:");
			iCompany = scanner.nextLine();
			System.out.println("데이터 입력이 완료되었습니다.");
			
			PhoneCompanyInfo pCompanyInfo = new PhoneCompanyInfo(iName, iPhone, iCompany);
			infoArr[numOfFriends++] = pCompanyInfo;
			break;
		}
		System.out.println();
	}
	//검색
	public void dataSearch() {
		boolean find = false;	//검색한 정보의 유무 확인을 위한 변수
		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름:");
		String searchName = scanner.nextLine();
		System.out.println();
		
		for(int i=0; i<numOfFriends; i++) {
			if(searchName.compareTo(infoArr[i].name)==0) {
				infoArr[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
				find = true;
			}
		}
		if(find==false) {
			System.out.println("찾는 정보가 없습니다.");
		}
		System.out.println();
	}
	//삭제
	public void dataDelete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.print("이름:");
		String deleteName = scanner.nextLine();
		
		int deleteIndex = -1;
		for(int i=0; i<numOfFriends; i++) {
			if(deleteName.compareTo(infoArr[i].name)==0) {
				infoArr[i] = null;
				System.out.println("데이터 삭제가 완료되었습니다.");
				deleteIndex = i;
				numOfFriends--;
				break;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("삭제된 데이터가 없습니다.");
		}
		else {
			for(int i=deleteIndex; i<numOfFriends; i++) {
				infoArr[i] = infoArr[i+1];
			}
			System.out.printf("데이터 %d번이 삭제되었습니다.", deleteIndex);
		}
		System.out.println();
	}
	//주소록전체출력
	public void dataAllShow() {
		for(int i=0; i<numOfFriends; i++) {
			infoArr[i].showPhoneInfo();
		}
	}
}
