package project1.ver09;

import project1.ver09.IConnectImpl;
/*
삭제 : dataDelete()
 - PreparedStatement 클래스 이용
 - delete로 구현
 */
public class DeleteSQL extends IConnectImpl
{
	public DeleteSQL() {
		super("kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			//1. 쿼리문준비
			String query = "DELETE FROM phonebook_tb WHERE name=?";
			//2. 쿼리문을 인자로 prepared객체 생성
			psmt = con.prepareStatement(query);
			//3. 인파라미터 설정
			psmt.setString(1, scanValue("삭제할 이름"));
			//4. 쿼리실행 및 출력
			System.out.println(psmt.executeUpdate() +"행이 삭제되었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new DeleteSQL().execute();
	}
}
