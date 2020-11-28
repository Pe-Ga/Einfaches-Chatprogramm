package at.wg.chatprogramm;

import java.io.FileWriter;
import java.util.Scanner;

public class Userinterface {
	
	String user;
//	String password;
	String server;
	
	
	
	
public Userinterface() {
	init();
}

private void init() {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter username: . . .");
	this.user = scan.nextLine();
	System.out.println("Enter server: . . .");
	this.server = scan.nextLine();
	//scan.close();
	send(getMsg());
	

}

private boolean send(Message msg1) {
	
	 String fileSeperatorW = "\\";
	 String fileSeperatorL = "/";
	 String fileSeperator;
	 
	 if(OSValidator.isWindows()) {
		 fileSeperator = fileSeperatorW;
	} else {
		fileSeperator = fileSeperatorL;
	}
	 
	 String messagePath =  this.server + fileSeperator + msg1.recepient +".txt";
	 boolean returnValue;
	 
	 try {
		 FileWriter write = new FileWriter(messagePath);
		 write.write(msg1.txt);
		 write.close();
		 returnValue = true;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Nachricht konnte nicht versendet werden. Unter dem Pfad: " + messagePath );
		returnValue= false;
	}
	return returnValue;
}

private Message getMsg(){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Name thy recepient:");
		String recepient = scanner.nextLine();
		System.out.println("text input . . .");
		String input = scanner.nextLine();
		scanner.close();
		
		Message msg1 = new Message(input, recepient);
		return msg1;
	}

}
