package Tp2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerClient {

	public static void main(String[] args) {

		ExecutorService eservice = Executors.newFixedThreadPool(2);
		Scanner scanner = new Scanner(System.in);
		String c;
		boolean b = true;
		while (b) {
			System.out.println("Choose a Role:\n1- Server\n2- Client");
			c = scanner.nextLine();
			if (c.equals("1")||c.equalsIgnoreCase("server")) {
				b = false;
				System.out.println("Server Started, Waiting for a Connection...");
				try {
					ServerSocket server = new ServerSocket(2017);
					Socket socket;
					while (true) {
						socket = server.accept();
						System.out.println("a Client is Connected");
						eservice.execute(new SendingHandler(socket));
						eservice.execute(new ReceivingHandler(socket,"Client"));
					}					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if (c.equals("2")||c.equalsIgnoreCase("client")) {
				b = false;
				try {
					Socket socket = new Socket("localhost",2017);
					System.out.println("Successfully Connected to the Server");
					eservice.execute(new SendingHandler(socket));
					eservice.execute(new ReceivingHandler(socket,"Server"));			
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				b = true;
			}
		}
		
		
		

	}

}

