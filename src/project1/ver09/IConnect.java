package project1.ver09;

public interface IConnect
{
	/*
	멤버상수
	 : 인터페이스에 선언된 변수는 무조건 public static final이 붙어서
	   정적 상수로 선언된다.
	 */
	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	/*
	멤버추상메소드
	 : public abstract가 생략되어있는 추상메소드로 선언된다.
	 */
	void connect(String user, String pass);//DB연결
	void execute();//쿼리실행
	void close();//자원반납
	
	
	//사용자 입력을 위한 추상메소드 선언
	String scanValue(String title);
}
