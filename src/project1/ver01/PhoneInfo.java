package project1.ver01;

public class PhoneInfo
{
	String name;	//이름
	String phoneNumber;	//전화번호
	String birthday;	//생년월일
	
	//3개의 매개변수를 갖는 생성자 : 이름과 전화번호는 필수입력
	public PhoneInfo(String name, String phoneNumber, String birthday)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	//2개의 매개변수를 갖는 생성자 오버로딩 : 생년월일은 선택사항
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = "입력되지않음";
	}
	public void showPhoneInfo() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phoneNumber);
		System.out.println("생년월일:"+ birthday);
	}
}
