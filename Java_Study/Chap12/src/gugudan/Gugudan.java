package gugudan;

public class Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] num = new int [9][9];
		
		for(int i=0;i<num.length;i++) {
			for(int k=0; k<num[i].length;k++) {
				System.out.printf("%3d*%d=%2d", k+1,i+1,(i+1)*(k+1));
			} System.out.println();
		}

	}

}
