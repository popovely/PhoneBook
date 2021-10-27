package project1.ver08;

import java.io.FileInputStream;
/*
프로그램 시작 직후 전체정보를 조회하면 기존에 입력된 정보들이 출력되어야 한다.
 */
public class ObjectInputStream
{
	PhoneBookManager pMgr = new PhoneBookManager();
	
	public void readInfo() {
		try {
			/*
			인스턴스의 복원(역직렬화)를 위한 스트림을 생성하고 readObject()를
			통해 복원한다. 
			 */
			java.io.ObjectInputStream in =
					new java.io.ObjectInputStream(
							new FileInputStream("src/project1/ver08/PhoneBook.obj")
							);
			while(true) {
				PhoneInfo pInfo = (PhoneInfo)in.readObject();
				pMgr.info.add(pInfo);
				if(pInfo==null) break;
			}
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
