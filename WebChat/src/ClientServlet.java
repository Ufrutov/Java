

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;

import chat.Message;
import chat.MessageQuery;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/client" })
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        MessageQuery.start();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Message: "+request.getParameter("message")+"; ip: "+request.getParameter("ip"));
		
		Message msg = new Message(0, request.getParameter("message"), String.valueOf(System.currentTimeMillis() / 1000L), request.getParameter("ip"));
		MessageQuery.insert(msg);
		
		response.setHeader("content-type", "application/json");
		response.getWriter().append("true");
//		MessageQuery.stop();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
