package project1.ver09;

import java.sql.SQLException;
import java.util.Scanner;

import project1.ver09.IConnectImpl;

/*
전체정보 출력 : dataAllShow()
 - Statement 클래스 이용
 */
public class ShowQuery extends IConnectImpl {
	
	public ShowQuery() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			String query = "SELECT * "
						+ " FROM phonebook_tb ";
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int iNum = rs.getInt("num");
				String iName = rs.getString("name");
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
		new ShowQuery().execute();
	}
}
