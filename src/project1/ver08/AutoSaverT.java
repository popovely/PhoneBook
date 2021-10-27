package project1.ver08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
쓰레드를 통해  주소록이 텍스트 형식으로 자동저장 될 수 있도록 기능을 추가한다. 
 - 자동저장은 5초에 한번씩 이루어진다.
 - 저장될파일명 : AutoSaveBook.txt
 */
//쓰레드로 정의할 클래스
public class AutoSaverT extends Thread
{
	PhoneBookManager pMgr = new PhoneBookManager();
	
	@Override
	public void run()
	{
		while(true) {
			try {
				try {
					java.io.ObjectOutputStream out =
							new java.io.ObjectOutputStream(
									new FileOutputStream("src/project1/ver08/AutoSaveBook.txt")
									);
					for(PhoneInfo pInfo : pMgr.info) {
						out.writeObject(pInfo);
					}
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				sleep(5000);
				System.out.println("주소록이 텍스트로 자동저장되었습니다.");
			}
			catch (InterruptedException e) {
				System.out.println("자동저장시 오류발생");
				e.printStackTrace();
			}
		}
	}
}
