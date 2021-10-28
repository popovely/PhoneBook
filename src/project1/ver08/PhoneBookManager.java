package project1.ver08;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Scanner;

public class PhoneBookManager
{
	PhoneBookManager pMgr;
	
	//정보저장을 위한 컬렉션 생성
	HashSet<PhoneInfo> info;
	//파일 저장경로
	String directory = "src/project1/ver08/PhoneBook.obj";
	Scanner scanner = new Scanner(System.in);
	
	//생성자
	public PhoneBookManager()
	{
		info = new HashSet<PhoneInfo>();
	}
	
	//멤버메소드
	//메뉴출력
	public void printMenu() {
		System.out.println();
		System.out.println("===============메뉴를 선택하세요====================");
		System.out.print("1.주소록 입력 ");
		System.out.print("2.검색 ");
		System.out.print("3.삭제 ");
		System.out.print("4.출력 ");
		System.out.print("5.저장옵션 ");
		System.out.println("6.종료");
		System.out.println("====================================================");
		System.out.print("메뉴선택:");
	}
	//입력
	public void dataInput()	{
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
	//저장옵션 - 오토 On/Off
	public void autoSave(AutoSaverT asT) {
		System.out.println("==저장옵션선택==");
		System.out.println("저장옵션을 선택하세요.");
		System.out.println("1.자동저장On, 2.자동저장Off");
		System.out.print("선택:");
		int option = scanner.nextInt();
		//쓰레드 객체를 통한 쓰레드 실행
		if(option==1) {
			if(!asT.isAlive()) {	//sa.isAlive() : 쓰레드가 살아있는지 확인
				System.out.println("\n자동저장을 시작합니다.");
				//쓰레드 객체생성
				asT.setDaemon(true);//데몬쓰레드
				asT.start();
			}
			else {
				System.out.println("이미 자동저장이 실행중입니다.");
			}
		}
		else if(option==2) {
			if(asT.isAlive()) {
				System.out.println("\n자동저장을 종료합니다.");
				asT.interrupt();
			}
		}
		else {
			System.out.println("메뉴를 잘못입력하셨습니다.");
		}
	}
	//저장
	public void writeInfo() {
		try {
			//인스턴스를 파일에 저장하기 위해 출력스트림을 생성한다. 
			java.io.ObjectOutputStream out =
					new java.io.ObjectOutputStream(
							new FileOutputStream(directory)
							);
			//인스턴스를 생성한 후 파일에 저장한다. 
			for(PhoneInfo pInfo : info) {
				out.writeObject(pInfo);
			}
			out.close();
			System.out.println("obj 파일로 저장되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	//기존정보 불러오기
	public void readInfo() {
		boolean flag = true;
		try {
			/*
			인스턴스의 복원(역직렬화)를 위한 스트림을 생성하고 readObject()를
			통해 복원한다. 
			 */
			java.io.ObjectInputStream in =
					new java.io.ObjectInputStream(
							new FileInputStream(directory)
							);
			while(flag) {
				PhoneInfo pInfo = (PhoneInfo)in.readObject();
				info.add(pInfo);
				if(pInfo==null) break;
			}
			in.close();
		}
		catch(EOFException e) {
			e.printStackTrace();
			flag = false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
