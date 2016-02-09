import java.awt.EventQueue;

import javax.swing.JFrame;

import query.Query;

public class GUIChatAdmin {

	private JFrame frame;
	public Query db_query;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIChatAdmin window = new GUIChatAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIChatAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.db_query = new Query();
		clientsOnline();
	}
	
	public void clientsOnline() {
		int online = Query.online();
		System.out.println(online);
	}

}
