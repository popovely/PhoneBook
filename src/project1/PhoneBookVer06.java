package project1;

import java.util.Scanner;

import project1.ver04.PhoneBookManager;
import project1.ver04.PhoneInfo;
import project1.ver05.MenuItem;
import project1.ver06.MenuSelectException;

public class PhoneBookVer06
{
	public static void main(String[] args) throws MenuSelectException
	{
		Scanner scanner =  new Scanner(System.in);
		PhoneBookManager pMgr = new PhoneBookManager();
//		int choice;
	
		while(true) {
			pMgr.printMenu();
			
			try {
				int choice = scanner.nextInt();
			}
			catch(MenuSelectException e) {
				System.out.println("[예외발생]"+ e.getMessage());
			}
			
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
			case MenuItem.TERMINATE:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
