package project1.ver06;

//사용자정의 예외클래스
public class MenuSelectException extends Exception
{
	public MenuSelectException() {
		super("1~5사이의 숫자를 입력하세요.");
	}
}
