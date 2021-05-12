package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Nio_Ex {
    public static void main(String[] args) {
        Path src = Path.of("./Temp/NioTest.txt"); // 복사할 대상 파일
        Path dst = Path.of("./Temp/Copied_NioTest.txt"); // 사본 이름

        // 하나의 버퍼 생성
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // try에서 두 개의 채널 생성(input채널,output채널)
        try(FileChannel ifc = FileChannel.open(src, StandardOpenOption.READ);
            FileChannel ofc = FileChannel.open(dst, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            int num;
            while(true) {
                num = ifc.read(buf); // 채널 ifc에서 버퍼로 읽어 들임
                if(num == -1) // 읽어 들인 데이터가 없다면
                    break;
                buf.flip(); // 모드 변환!
                ofc.write(buf); // 버퍼에서 채널 ofc로 데이터 전송
                buf.clear(); // 버퍼 비우기
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}
