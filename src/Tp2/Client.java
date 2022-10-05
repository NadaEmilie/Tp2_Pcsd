package Tp2;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

final class Client {
	void run {
		try {
				Socket s = new Socket("localhost",2500);
				String  str;
				int taille;
				Scanner scan = new Scanner(System.in);
				OutputStream os = s.getOutputStream();
				PrintWriter pw = new PrintWriter(os,true);
				InputStream is = s.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				do {
					System.out.print("Entres un message:");
					str = scan.nextLine();
					pw.println(str);
				}while(str.equals("quitter"));
				scan.close();
				s.close();

}
