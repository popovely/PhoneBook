package project1.ver08;

import java.io.FileWriter;
import java.io.PrintWriter;

/*
쓰레드를 통해  주소록이 텍스트 형식으로 자동저장 될 수 있도록 기능을 추가한다. 
 - 자동저장은 5초에 한번씩 이루어진다.
 - 저장될파일명 : AutoSaveBook.txt
 */
//쓰레드로 정의할 클래스
public class AutoSaverT extends Thread
{
	PhoneBookManager pMgr;
	
	public AutoSaverT(PhoneBookManager pMgr)
	{
		this.pMgr = pMgr;
	}

	@Override
	public void run()
	{
		try {
			while(true) {
				PrintWriter out = new PrintWriter(
						new FileWriter("src/project1/ver08/AutoSaveBook.txt"));
				
				for(PhoneInfo pInfo : pMgr.info) {
					out.println(pInfo);
					out.close();
				}
				sleep(5000);
				System.out.println("주소록이 텍스트로 자동저장되었습니다.");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
