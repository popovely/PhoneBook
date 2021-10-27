package project1.ver08;

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
	@Override
	public String toString()
	{
		return "\n이름:" + name +
				"\n전화번호:" + phoneNumber +"\n";
	}
	
	@Override
	public int hashCode()
	{
		int nameHashCode = name.hashCode();
		System.out.println("nameHashCode="+ nameHashCode);
		return nameHashCode;
	}
	@Override
	public boolean equals(Object obj)
	{
		PhoneInfo pInfo = (PhoneInfo)obj;
		System.out.println("equals()메소드 호출됨");
		//이름에 대한 비교를 진행
		if(pInfo.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
}
