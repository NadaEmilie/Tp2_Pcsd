package Tp2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceivingHandler extends Thread {

	
	Socket socket;
	DataInputStream din;
	String sender;
	
	public ReceivingHandler(Socket socket,String sender) {
		this.socket = socket;
		this.sender = sender;
	}
	
	public void run() {

		try {
			
			din = new DataInputStream(socket.getInputStream());
			String msg;
			while (true) {
				
				msg = din.readUTF();
				if (msg.equalsIgnoreCase("quit")) {
					break;
				}
				System.out.println(sender+": "+msg);
			}
			
			din.close();
			socket.close();
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}