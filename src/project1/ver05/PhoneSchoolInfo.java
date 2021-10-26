package project1.ver05;

public class PhoneSchoolInfo extends PhoneInfo
{
	//확장할 멤버변수
	String major;	//전공
	int grade;	//학년
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade)
	{
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	
	@Override
	public void showPhoneInfo()
	{
		super.showPhoneInfo();
		System.out.println("전공:"+ major);
		System.out.println("학년:"+ grade);
	}
}
