package random_lotto;

import java.util.Random;

public class Random_Lotto {
	
	public int[] raw_Lotto_Num() {
		
		final int MIN = 1 , MAX = 45;
		
		int LottoNumber[] = new int[6];
	    Random random = new Random();
	    
	    for (int i = 0; i < LottoNumber.length; i++) {
	    	
	    	LottoNumber[i] = (random.nextInt((MAX - MIN) + 1) + MIN);
	    	
	    	for (int j = 0; j < i; j++)
            
	    		if (LottoNumber[i] == LottoNumber[j]) i--;
	    }
	

		return LottoNumber;
	}

}
