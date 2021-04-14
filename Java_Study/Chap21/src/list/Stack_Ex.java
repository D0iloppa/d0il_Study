package list;

import java.util.Stack;

public class Stack_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Stack<Coin> coinBox = new Stack<>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		while(!coinBox.isEmpty())
			System.out.println("꺼내온 동전 : " + coinBox.pop().getValue()+"원");
	
		
		
		

	}

}
