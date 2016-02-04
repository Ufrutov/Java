package socket;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
 
// http://nowonbun.tistory.com/286

/** 
 * @ServerEndpoint gives the relative name for the end point
 * This will be accessed via ws://localhost:8080/EchoChamber/echo
 * Where "localhost" is the address of the host,
 * "EchoChamber" is the name of the package
 * and "echo" is the address to access this class from the server
 */
@ServerEndpoint("/chatsocket") 
public class chat {
    /**
     * @OnOpen allows us to intercept the creation of a new session.
     * The session class allows us to send data to the user.
     * In the method onOpen, we'll let the user know that the handshake was 
     * successful.
     */
	static Set<Session> sessionUsers = Collections.synchronizedSet(new HashSet<Session>());
	
    @OnOpen
    public void onOpen(Session session){
        System.out.println(session.getId() + " has opened a connection");
        
        sessionUsers.add(session);
        
        try {
            session.getBasicRemote().sendText("Connection Established");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    /**
     * When a user sends a message to the server, this method will intercept the message
     * and allow us to react to it. For now the message is read as a String.
     */
    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("Message from " + session.getId() + ": " + message);
        try {
//            session.getBasicRemote().sendText(message);
        	session.getBasicRemote().sendText("Served at web-chat");
        	handleMessage(message, session);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    public void handleMessage(String message, Session userSession) throws IOException{
		String username = (String)userSession.getId();
		if(username == null){
			userSession.getUserProperties().put("username", message);
			userSession.getBasicRemote().sendText("System: "+"you are now connected as "+message);
		}else{
			Iterator<Session> iterator = sessionUsers.iterator();
			while(iterator.hasNext()){
				iterator.next().getBasicRemote().sendText(message);
			}
		}
	}
    
    /**
     * The user closes the connection.
     * 
     * Note: you can't send messages to the client from this method
     */
    @OnClose
    public void onClose(Session session){
        System.out.println("Session " +session.getId()+" has ended");
    }
}