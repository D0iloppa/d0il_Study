package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) {
		  BufferedReader in = null;
	      BufferedReader stin = null;
	      BufferedWriter out = null;
	      ServerSocket listener = null;
	      Socket socket = null;
	      
	      // 시작, 연결대기	        
	      System.out.println("Starting Java Socket Server...");
	      System.out.println("Listening at port 5001...");
	      
	      
	        try{
	            listener = new ServerSocket(5001);
	            socket = listener.accept();
	            System.out.println("A Client connected. host : "+ socket.getInetAddress()+ ", port : " + socket.getPort());
	           
	            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
	            stin = new BufferedReader(new InputStreamReader(System.in)); 
	            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 

	           
	            System.out.print("Input : ");
	            String outputMessage = stin.readLine();
	            
	            out.write(outputMessage);
	            
	            out.flush();

	        } catch (IOException e){
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                socket.close();
	                listener.close();
	            } catch (IOException e){
	                System.out.println("Error");
	            }
	        }


	}

}
