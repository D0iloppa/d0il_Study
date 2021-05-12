package SelfTest;


import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileWriter_Ex {
    public static void main(String[] args) throws Exception{
        OutputStream out2 = new FileOutputStream("Temp/data.txt");
        BufferedOutputStream buf1 = new BufferedOutputStream(out2,1024*10); // 10KB
        DataOutputStream dataOut2 = new DataOutputStream(buf1);
        Data_Performance.performance(dataOut2);
        dataOut2.close();

    }


}