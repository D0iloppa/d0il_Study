package java_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Ex {
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedReader stin = null;
        BufferedWriter out = null;
        ServerSocket listener = null;
        Socket socket = null;

        System.out.println("연결 대기중..\n");

        try{
            listener = new ServerSocket(9999);
            socket = listener.accept();
            System.out.println("클라이언트와 연결됨");
            // 각 스트림 인스턴스화
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터의 입력스트림
            stin = new BufferedReader(new InputStreamReader(System.in)); // 키보드로부터의 입력스트림
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로의 출력 스트림

            String inputMessage;
            while(true){
                inputMessage = in.readLine();
                if(inputMessage.equalsIgnoreCase("bye")) break;
                System.out.println(inputMessage);
                System.out.print(">");
                String outputMessage = stin.readLine();
                out.write("서버>"+outputMessage+"\n");
                out.flush();

            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
                listener.close();
            } catch (IOException e){
                System.out.println("클라이언트와 채팅 중 오류가 발생했습니다.");
            }
        }

    }
}
