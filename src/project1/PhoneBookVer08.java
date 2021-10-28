package project1;

import java.util.Scanner;

import project1.ver08.PhoneBookManager;
import project1.ver08.AutoSaverT;
import project1.ver08.MenuItem;

public class PhoneBookVer08
{
	public static void main(String[] args)
	{
		Scanner scanner =  new Scanner(System.in);
		PhoneBookManager pMgr = new PhoneBookManager();
		//1.쓰레드 객체 만들어 놓고
		AutoSaverT asT = new AutoSaverT(pMgr);
		
		//프로그램 시작 직후 전체정보를 조회하면 기존에 입력된 정보들이 출력
		pMgr.readInfo();
	
		while(true) {
			pMgr.printMenu();
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case MenuItem.INPUT:
				pMgr.dataInput();
				break;
			case MenuItem.SEARCH:
				pMgr.dataSearch();
				break;
			case MenuItem.DELETE:
				pMgr.dataDelete();
				break;
			case MenuItem.PRINT:
				pMgr.dataAllShow();
				break;
			case MenuItem.AUTO_SAVE:
				//2.쓰레드가 실행중이지 않을때는 쓰레드를 새로 만들어서 던짐
				if(!asT.isAlive()) {
					asT = new AutoSaverT(pMgr);
					pMgr.autoSave(asT);
				}
				//3.쓰레드가 실행중일 때는 만들어놓은(=이미사용중인) 쓰레드를 던짐
				else {
					pMgr.autoSave(asT);
				}
				break;	
			case MenuItem.TERMINATE:
				//프로그램 종료시 컬렉션에 저장된 객체들을 직렬화
				pMgr.writeInfo();
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
