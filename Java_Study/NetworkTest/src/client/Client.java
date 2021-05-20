package client;


import java.io.*;
import java.net.Socket;

public class Client {
	

	public static void main(String[] args) {
		  BufferedReader in = null;
	      BufferedWriter out = null;
	      Socket socket = null;

	        try {
	            socket = new Socket("localhost", 5001); 
	            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

	            String inputMessage = in.readLine();
	            System.out.println(inputMessage + " from Server.");
	            
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                socket.close();
	            } catch (IOException e) {
	                System.out.println("Error!");
	            }
	        }

	}

}
