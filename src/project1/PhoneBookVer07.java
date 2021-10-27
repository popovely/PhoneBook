package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver04.PhoneBookManager;
import project1.ver04.PhoneInfo;
import project1.ver05.MenuItem;
import project1.ver06.MenuSelectException;

public class PhoneBookVer07
{
	public static void main(String[] args) throws MenuSelectException
	{
		PhoneBookManager pMgr = new PhoneBookManager();
		int choice = 0;
	
		while(true) {
			pMgr.printMenu();
			
			try {
				choice = selectMenu();
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
	
	public static int selectMenu() throws MenuSelectException {
		Scanner scanner =  new Scanner(System.in);
		int inputNum = 0;
		try {
			inputNum = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
			System.out.println("다시 입력하세요.");
		}
		if(inputNum<1 || inputNum>5) {
			MenuSelectException ex = new MenuSelectException();
			throw ex;
		}
		return inputNum;
	}
}
