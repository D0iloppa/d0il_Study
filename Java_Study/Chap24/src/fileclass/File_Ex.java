package fileclass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File_Ex {
    public static void main(String[] args) throws IOException {

        File dir = new File("./Temp/Dir");
        File file1 = new File("./Temp/file1.txt");
        File file2 = new File("./Temp/file2.txt");

        if(!dir.exists()){
            dir.mkdir();
        }
        if(!file1.exists()){
            file1.createNewFile();
        }
        if (!file2.exists()) {
            file2.createNewFile();
        }

        File tmp = new File("./Temp");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
        File[] contents = tmp.listFiles();
        System.out.println("날짜 \t\t 시간 \t\t 형태 \t\t 크기 \t\t 이름");
        System.out.println("____________________________________________________________");
        for(File file : contents){
            System.out.print(sdf.format(new Date(file.lastModified())));
            if(file.isDirectory()) // 폴더일 경우
                System.out.print("\t <DIR> \t\t\t\t\t"+ file.getName());
            else{
                System.out.print("\t\t\t\t "+file.length());
                System.out.print("\t\t\t"+file.getName());
            }
            System.out.println();


        }
    }
}
