package Tp2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SendingHandler extends Thread {

	
	Socket socket;
	DataOutputStream dout;
	
	public SendingHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {

		try {
			
			dout = new DataOutputStream(socket.getOutputStream());
			Scanner scanner = new Scanner(System.in);
			String msg;
			while (true) {
				msg = scanner.nextLine();
				dout.writeUTF(msg);
				if (msg.equalsIgnoreCase("quit")) {
					break;
				}
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
