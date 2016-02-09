package query;

import java.sql.Date;

public class Message {
	
	public int id;
	public int client;
	public String text;
	public Date date;
	
	public Message(int id, int client, String text, Date date) {
		super();
		this.id = id;
		this.client = client;
		this.text = text;
		this.date = date;
	}
	
}
