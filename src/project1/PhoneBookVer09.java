package project1;

import java.util.Scanner;

import project1.ver09.PhoneBookManager;
import project1.ver09.PhoneInfo;

public class PhoneBookVer09
{

	public static void main(String[] args)
	{
		Scanner scanner =  new Scanner(System.in);
		PhoneBookManager pMgr = new PhoneBookManager();
	
		while(true) {
			pMgr.printMenu();
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				pMgr.dataInput();
				break;
			case 2:
				pMgr.dataSearch();
				break;
			case 3:
				pMgr.dataDelete();
				break;
			case 4:
				pMgr.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
