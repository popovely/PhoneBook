package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02
{

	public static void main(String[] args)
	{
		Scanner scanner =  new Scanner(System.in);
		String name, phoneNum, birthday;
		while(true) {
			System.out.println("선택하세요...");
			System.out.println("1.데이터 입력");
			System.out.println("2.프로그램 종료");
			System.out.print("선택:");
			int choice = scanner.nextInt();
			if(choice==1) {
				scanner.nextLine();
				System.out.print("이름:");
				name = scanner.nextLine();
				System.out.print("전화번호:");
				phoneNum = scanner.nextLine();
				System.out.print("생년월일:");
				birthday = scanner.nextLine();
				
				PhoneInfo phoneInfo = new PhoneInfo(name, phoneNum, birthday);
				System.out.print("입력된 정보 출력...");
				phoneInfo.showPhoneInfo();
			}
			else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
