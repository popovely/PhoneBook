package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.PhoneBookManager;
import project1.ver08.PhoneInfo;
import project1.ver08.MenuItem;

public class PhoneBookVer08
{
	public static void main(String[] args)
	{
		Scanner scanner =  new Scanner(System.in);
		PhoneBookManager pMgr = new PhoneBookManager();
	
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
			case MenuItem.TERMINATE:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
