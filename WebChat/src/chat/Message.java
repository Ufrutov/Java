package chat;

public class Message {
	
	public int id;
	public String message;
	public String date;
	public String ip;
	
	public Message(int id, String message, String date, String ip) {
		super();
		this.id = id;
		this.message = message;
		this.date = date;
		this.ip = ip;
	}
	
}
