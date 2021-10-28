package project1.ver09;

import java.sql.SQLException;
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
			
			String query = "SELECT "
						+ " name, phone_number, to_char(birthday, 'yyyy.mm.dd') "
						+ " FROM phonebook_tb ";
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String iName = rs.getString("name");
				String iPhone = rs.getString("phone_number");
				String iBirth = rs.getString("birthday");
//				/*
//				오라클의 date타입을 getDate()로 추출하면
//				0000-00-00 형태로 출력된다.
//				이 경우 date형 자료이므로
//				java.sql.Date클래스의 참조변수로 저장해야 한다.
//				 */
//				java.sql.Date regidate = rs.getDate("regidate");
//				/*
//				오라클의 date타입을 getString()으로 추출하면
//				0000-00-00 00:00:00 형태로 시간까지 출력가능.
//				만약 적당한 크기로 자르고 싶다면 substring()을 사용한다.
//				 */
//				String regidate2 = rs.getString("regidate");
//				String regidate3 = rs.getString("regidate").substring(0,13);
//				//쿼리문에 사용한 별칭을 사용가능
//				String regidate4 = rs.getString("d1");
				
				System.out.printf("%s %s %s\n",
						iName, iPhone, iBirth);
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
