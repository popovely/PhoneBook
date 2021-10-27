package project1.ver08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager
{
	//정보저장을 위한 컬렉션 생성
	HashSet<PhoneInfo> info;
	
	//생성자
	public PhoneBookManager()
	{
		info = new HashSet<PhoneInfo>();
	}
	
	//멤버메소드
	//메뉴출력
	public void printMenu() {
		System.out.println();
		System.out.println("[메뉴를 선택하세요]");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("메뉴선택:");
	}
	//입력
	public void dataInput()	{
		Scanner scanner = new Scanner(System.in);
		String iName, iPhone, iMajor, iCompany;
		int iGrade;
		
		System.out.println("==주소록을 입력==");
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.print("선택>>");
		int select = scanner.nextInt();
		
		//기본정보 입력(공통사항)
		scanner.nextLine();
		System.out.print("이름:");
		iName = scanner.nextLine();
		System.out.print("전화번호:");
		iPhone = scanner.nextLine();
		
		PhoneInfo pInfo = null;
		
		switch(select) {
		case SubMenuItem.DEFAULT:
			pInfo = new PhoneInfo(iName, iPhone);
			break;
		case SubMenuItem.SCHOOL_FRIEND:
			System.out.print("전공:");
			iMajor = scanner.nextLine();
			System.out.print("학년:");
			iGrade = scanner.nextInt();
			
			PhoneSchoolInfo pSchoolInfo = new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade);
			pInfo = pSchoolInfo;
			break;
		case SubMenuItem.COWORKER:
			System.out.print("회사:");
			iCompany = scanner.nextLine();
			
			PhoneCompanyInfo pCompanyInfo = new PhoneCompanyInfo(iName, iPhone, iCompany);
			pInfo = pCompanyInfo;
			break;
		}
		boolean overwrite = info.add(pInfo);
		//중복확인
		if(overwrite==false) {
			System.out.println("이미 저장된 데이터입니다.");
			System.out.println("덮어쓸까요?  Y / N");
			char owChoice = scanner.next().charAt(0);
			if(owChoice=='Y' || owChoice=='y') {
				info.remove(pInfo);
				info.add(pInfo);
				System.out.println("===입력한 정보가 저장되었습니다.===");
			}
		}
		else {
			System.out.println("===입력이 완료되었습니다.===");
		}
		System.out.println();
	}
	//검색
	public void dataSearch() {
		boolean find = false;	//검색한 정보의 유무 확인을 위한 변수
		Scanner scanner = new Scanner(System.in);
		System.out.println("==데이터 검색 시작==");
		System.out.print("이름:");
		String searchName = scanner.nextLine();
		System.out.println();
		
		for(PhoneInfo pInfo : info) {
			if(searchName.compareTo(pInfo.name)==0) {
				pInfo.showPhoneInfo();
				System.out.println("===데이터 검색이 완료되었습니다.===");
				find = true;
			}
		}
		if(find==false) {
			System.out.println("===찾는 정보가 없습니다.===");
		}
		System.out.println();
	}
	//삭제
	public void dataDelete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("==데이터 삭제 시작==");
		System.out.print("이름:");
		String deleteName = scanner.nextLine();
		
		int deleteIndex = -1;
		for(PhoneInfo pInfo : info) {
			if(deleteName.compareTo(pInfo.name)==0) {
				info.remove(pInfo);
				deleteIndex = 1;
				break;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("===삭제된 데이터가 없습니다.===");
		}
		else {
			System.out.println("===데이터 삭제가 완료되었습니다.===");
		}
	}
	//주소록전체출력
	public void dataAllShow() {
		for(PhoneInfo pInfo : info) {
			System.out.print(pInfo.toString());
		}
	}
}
