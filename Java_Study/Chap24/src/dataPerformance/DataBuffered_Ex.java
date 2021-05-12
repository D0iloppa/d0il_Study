package dataPerformance;

import java.io.*;

public class DataBuffered_Ex {
    public static void main(String[] args) throws Exception {
        OutputStream out1 = new FileOutputStream("D:/Github/d0il_Study/Java_Study/data1.bin");
        DataOutputStream dataOut = new DataOutputStream(out1);
        Data_Performance.performance(dataOut);
        dataOut.close();

        OutputStream out2 = new FileOutputStream("D:/Github/d0il_Study/Java_Study/data2.bin");
        BufferedOutputStream buf1 = new BufferedOutputStream(out2,1024*10); // 10KB
        DataOutputStream dataOut2 = new DataOutputStream(buf1);
        Data_Performance.performance(dataOut2);
        dataOut2.close();

    }
}
