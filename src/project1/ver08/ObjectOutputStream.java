package project1.ver08;

import java.io.FileOutputStream;
/*
파일의 저장은 프로그램을 종료하는 시점에 이루어져야 한다.
 - 저장될파일명 : PhoneBook.obj
 */
public class ObjectOutputStream
{
	PhoneBookManager pMgr = new PhoneBookManager();
	
	public void saveInfo() {
		try {
			//인스턴스를 파일에 저장하기 위해 출력스트림을 생성한다. 
			java.io.ObjectOutputStream out =
					new java.io.ObjectOutputStream(
							new FileOutputStream("src/project1/ver08/PhoneBook.obj")
							);
			//인스턴스를 생성한 후 파일에 저장한다. 
			for(PhoneInfo pInfo : pMgr.info) {
				out.writeObject(pInfo);
			}
			System.out.println("obj 파일로 저장되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
