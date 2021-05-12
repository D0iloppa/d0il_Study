package dataPerformance;

import java.io.DataOutputStream;

public class Data_Performance {


    public static void performance(DataOutputStream dataOut) throws Exception{

        long startTime = System.currentTimeMillis();

        for(int i=0;i<1000;i++){
            for(int j=0; j<1000;j++){
                dataOut.writeDouble(12.345);
            }
        }

        dataOut.flush();

        long endTime = System.currentTimeMillis();
        System.out.println("경과시간 : " + (endTime-startTime));
    }

}
