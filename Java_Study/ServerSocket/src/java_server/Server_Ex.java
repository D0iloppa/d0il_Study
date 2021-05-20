package java_server;

import com.example.mission_0514.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ex {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(11000);
            System.out.println("서버 소켓이 만들어졌습니다.");

            while(true){
                // 네트워크와 파일 입출력을 활용해 서버에 데이터를 저장하는 자바 프로그램
                Socket socket = serverSocket.accept();
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                Object obj = inputStream.readObject();
                System.out.println("입력받은 내용 : " + obj);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                
                if(obj.equals("WRITE")){ // 쓰기모드
                    int count = (int) inputStream.readObject();
                    ObjectOutputStream fileSave = new ObjectOutputStream(new FileOutputStream(new File("list.txt")));
                    fileSave.writeObject(count);
                    System.out.println("전달받은 리스트 뷰의 갯수 : " + count);

                    for(int i=0;i<count;i++){
                        Object itemObj = inputStream.readObject();
                        SongItem item = (SongItem) itemObj;
                        fileSave.writeObject(item);
                    }

                    fileSave.flush();
                    fileSave.close();
                    System.out.println("파일 list.txt에 데이터 쓰기 완료");

                } else if (obj.equals("READ")) { // 읽기 모드
                    ObjectInputStream fileOpen = new ObjectInputStream(new FileInputStream(new File("list.txt")));
                    int count = (int)fileOpen.readObject();
                    outputStream.writeObject(count);
                    for(int i=0;i<count;i++){
                        SongItem item = (SongItem) fileOpen.readObject();
                        outputStream.writeObject(item);
                    }

                    outputStream.flush();
                    fileOpen.close();
                    System.out.println("파일 list.txt의 데이터 읽기 완료");
                }

                inputStream.close();
                outputStream.close();
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
