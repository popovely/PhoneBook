package project1.ver07;

public class PhoneCompanyInfo extends PhoneInfo
{
	//확장할 멤버변수
	String companyName;	//회사명

	public PhoneCompanyInfo(String name, String phoneNumber, String companyName)
	{
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	
	@Override
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("회사명:"+ companyName);
	}
	@Override
	public String toString()
	{
		return "\n이름:" + name +
				"\n전화번호:" + phoneNumber +
				"\n회사명:"+ companyName +"\n";
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}
}
