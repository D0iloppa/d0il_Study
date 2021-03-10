package lecture;

public class ArrayCopyByFor_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] oldArr = {1,2,3};
		int[] newArr = new int[5];
		
		for(int i=0;i<oldArr.length;i++) {
			newArr[i] = oldArr[i];
		}

	}

}
