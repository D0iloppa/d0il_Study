package SelfTest;

import java.io.DataOutputStream;

public class Data_Performance {
    public static void performance(DataOutputStream dataOut) throws Exception{


        char startChar = 'A';
        for(int i=0;i<26;i++) dataOut.writeChar(startChar++);


        dataOut.flush();
    }
}
