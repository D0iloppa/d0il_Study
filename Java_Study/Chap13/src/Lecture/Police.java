package Lecture;

public class Police {
	Gun pistol; // 경찰이 소유하고 있는 권총
	
	public Police(int bnum) {
	     if(bnum!=0) pistol=new Gun(bnum);
	     else pistol=null;
	   }  

}
