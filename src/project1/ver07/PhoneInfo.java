package project1.ver07;

public class PhoneInfo
{
	String name;	//이름
	String phoneNumber;	//전화번호
	
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phoneNumber);
	}
}
