package at.wg.chatprogramm;

import java.io.*;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

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

//private changeConfig Methode wo user und server übergeben wird

// 2. methode saveConfig speichert config und bekommt von changeConfig Daten


private void createConfigFile() {
	
	try {
		FileWriter config = new FileWriter("Config.txt");
		config.write(this.user + "\n" + this.server );
		config.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private void readConfigFile() {
	
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


// Lese-Methode
private Message readMsg() {
	
	Message returnValue = null;
//	Message msg2 = new Message
	
	// Name des Empfängers  = user - dateipfad!
	//Dateipfad richtig?
	
	//namen checken, 
	 
	 String fileSeperatorW = "\\";
	 String fileSeperatorL = "/";
	 String fileSeperator;
	 
	 if(OSValidator.isWindows()) {
		 fileSeperator = fileSeperatorW;
	} else {
		fileSeperator = fileSeperatorL;
	}
	 
	 String messagePath =  this.server + fileSeperator + user +".txt";

	 
	File file = new File("C:\\Users\\Lenovo\\Desktop\\Server\\" + user + ".txt"); // +user
	
	if(file.exists()) {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			String st; 
			String txt = "";
			try {
				while ((st = br.readLine()) != null) {
					System.out.println(st);
					txt = txt + st;
					}
				
			returnValue = new Message(txt, user);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
	}else {
	   returnValue = null;
	}
	
	return returnValue;
}

private void receive() {
	Message read = readMsg();
	if (read != null) {
	 System.out.println(read.getTxt());
	}
}
	
public static void main(String[] args)
	{
		Userinterface face = new Userinterface();		
		face.receive();
	}	
}


	  



























