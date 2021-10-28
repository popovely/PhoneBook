package project1.ver09;

import java.util.Scanner;
import project1.ver09.IConnectImpl;
/*
입력 : dataInput()
 - PreparedStatement 클래스 이용
 - insert로 구현
 */
public class InsertSQL extends IConnectImpl
{
	public InsertSQL() {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	@Override
	public void execute() {
		try {
			//1. 쿼리문준비 - 값의 세팅이 필요한 부분을 ?(인파라미터)로 대체한다.
			String query = "INSERT INTO phonebook_tb "
					+ " VALUES (seq_phonebook.nextval, ?, ?, ?)";
			
			//2. prepared객체 생성 - 생성시 위에서 준비한 쿼리문을 인자로 전달한다. 
			psmt = con.prepareStatement(query);
			
			//3. 입력할 내용을 사용자로부터 입력받는다.
			Scanner scan = new Scanner(System.in);
			System.out.print("이름:");
			String iName = scan.nextLine();
			System.out.print("전화번호:");
			String iPhone = scan.nextLine();
			System.out.print("생년월일:");
			String iBirth = scan.nextLine();
			
			psmt.setString(1, iName);
			psmt.setString(2, iPhone);
			psmt.setString(3, iBirth);//String이므로 sqlDeveloer에서 Date타입인거 알려줘야할듯?
			
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 입력되었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new InsertSQL().execute();
	}
}
