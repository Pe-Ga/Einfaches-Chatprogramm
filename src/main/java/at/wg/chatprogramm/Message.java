package at.wg.chatprogramm;

public class Message {
	
	// Attribute
	String txt;
	String recepient;
	
	// Konstruktor
	public Message(String txt, String recepient) {
		super();
		this.txt = txt;
		this.recepient = recepient;
	}

	public String getTxt() {
		if(txt == null) {
		return "";
		}else {
		return txt;
		}
		
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	
	
	// Methoden
	
	
	// -> soll später an Objekt "send" übergeben werden
	
	
	
	

}
