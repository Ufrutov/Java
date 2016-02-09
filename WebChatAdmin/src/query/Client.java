package query;

import java.util.Date;

public class Client {

	public int id;
	public String name;
	public Boolean status;
	public Date first_connect;
	public Date last_connect;
	
	public Client(int id, String name, Boolean status, Date first_connect, Date last_connect) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.first_connect = first_connect;
		this.last_connect = last_connect;
	}
	
	public void toggleStatus(Boolean status) {
		Query.update("clients", this.id, "status", status.toString());
	}
	
	public void addMessage(Message msg) {
		Query.insertMessage("message", this.id, msg);
	}
	
}
