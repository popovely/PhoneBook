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
			
			/*
			4. 인파라미터 설정
			 - ?의 순서대로 설정하고, 인덱스는 1부터 시작
			 - 인파라미터 설정시 사용하는 메소드
			   자료형이
					숫자면 setInt()
			  		문자면 setString()
			  		날짜면 setDate()
			 - 입력값이 문자이거나 날짜이면 싱글쿼테이션이 자동으로 삽입된다.
			 */
			psmt.setString(1, iName);
			psmt.setString(2, iPhone);
			psmt.setString(3, iBirth);//String이므로 sqlDeveloer에서 Date타입인거 알려줘야할듯?
			
//			//날짜를 문자열로 입력하는 경우
//			psmt.setString(4, "2021-11-20");
			
			//날짜를 date타입으로 입력하는 경우
			/*
				현재날짜를 java에서 입력하는 경우 아래와 같은 변환과정을 거쳐야한다.
				util패키지로 시간을 가져온 후 sql패키지로 타입을 변환한다.
				이때는 date형으로 입력되므로 setDate()로 인파라미터를 설정해야 한다.
			 */
//			java.util.Date utilDate = new java.util.Date();
//			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//			psmt.setDate(4, sqlDate);
			
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
