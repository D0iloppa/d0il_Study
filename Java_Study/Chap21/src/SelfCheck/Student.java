package SelfCheck;

public class Student {
	
	private int sNum; // 학번
	private String name,phone,e_Mail; // 이름,전화번호,이메일
	
	
	public Student(int sNum, String name, String phone, String e_Mail) {
		super();
		this.sNum = sNum;
		this.name = name;
		this.phone = phone;
		this.e_Mail = e_Mail;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-5s\t|%-5s\t|%s\t|%s",sNum,name,phone,e_Mail);
//		return sNum + "\t|" + name + "\t\t|" + phone + "\t|" + e_Mail;
	}
	
	
	
	
	

}
