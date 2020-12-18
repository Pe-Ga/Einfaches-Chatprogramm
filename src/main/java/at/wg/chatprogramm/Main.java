package at.wg.chatprogramm;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

public class Main
{
	public static void main(String[] args)
	{
		// configure logger
		String log4jConfPath = "./src/main/resources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		System.out.println( "Welcome to \"Einfaches Chatprogramm\" . . . " );
		
		Userinterface ui1 = new Userinterface();
		
		
		
		
		
		
		
	
		
	}	
}
