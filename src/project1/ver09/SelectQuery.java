package project1.ver09;

import java.sql.SQLException;
import java.util.Scanner;

import project1.ver09.IConnectImpl;

/*
ResultSet 클래스
 : Select문 실행시 쿼리의 실행결과가 ResultSet 객체에 저장된다.
   결과로 반환된 레코드의 처음부터 마지막까지 next()메소드를 통해
   확인후 반복 추출한다.
   
 - getXXX() 계열의 메소드
   오라클의 자료형이
   		number타입 : getInt()
   		char/varchar2타입 : getString()		→ 오라클 자료형에 상관없이
   											  모든 타입을 추출할 수 있다.
   		date타입 : getDate()
 - 인자는 select절의 순서대로 인덱스(1부터시작)를 사용하거나
   컬럼명을 사용할 수 있다.
 */
/*
검색 : dataSearch()
 - Statement 클래스 이용
 - like를 이용한 select로 구현
 */
public class SelectQuery extends IConnectImpl {
	
	public SelectQuery() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			
			//검색할 내용을 사용자로부터 입력받는다.
			Scanner scan = new Scanner(System.in);
			System.out.print("이름:");
			String iName = scan.nextLine();
			
			String query = "SELECT * "
						+ " FROM phonebook_tb "
						+ " WHERE name LIKE '%"+ iName +"%'";
			
			rs = stmt.executeQuery(query);//
			
			while(rs.next()) {
				int iNum = rs.getInt("num");
				iName = rs.getString("name");
//				String iName = rs.getString("name");
				String iPhone = rs.getString("phone_number");
				String iBirth = rs.getString("birthday");
				System.out.printf("%d %s %s %s\n", iNum, iName, iPhone, iBirth);
			}
		}
		catch (SQLException e) {
			System.out.println("쿼리오류");
			e.printStackTrace();
		}
		finally {
			close();//DB 자원반납
		}
	}
	public static void main(String[] args) {
		new SelectQuery().execute();
	}
}
