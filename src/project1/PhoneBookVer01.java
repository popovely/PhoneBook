package project1;

import project1.ver01.PhoneInfo;

public class PhoneBookVer01
{

	public static void main(String[] args)
	{
		PhoneInfo pi1 = new PhoneInfo("유비", "010-1111-1111", "1980-10-10");
		pi1.showPhoneInfo();
		
		PhoneInfo pi2 = new PhoneInfo("손오공", "010-2222-2222");
		pi2.showPhoneInfo();
	}
}
