package project1.ver09;

import java.util.Scanner;

public class PhoneBookManager
{
	//연락처 저장할 배열
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
		
		System.out.println("데이터 입력을 시작합니다..");
		
		InsertSQL insert = new InsertSQL();
		insert.execute();
		
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	//검색
	public void dataSearch() {
//		boolean find = false;	//검색한 정보의 유무 확인을 위한 변수
		System.out.println("데이터 검색을 시작합니다.");
		
		SelectQuery search = new SelectQuery();
		search.execute();
		
		System.out.println();
	}
	//삭제
	public void dataDelete() {
		System.out.println("데이터 삭제를 시작합니다..");
		
		DeleteSQL delete = new DeleteSQL();
		delete.execute();
		
		System.out.println();
	}
	//주소록전체출력
	public void dataAllShow() {
		ShowQuery show = new ShowQuery();
		show.execute();
	}
}
