import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import query.Client;
import query.Query;

public class GUIChatAdmin {

	private JFrame frame;
	public Query db_query;
	private static JTextField field_clients_online;
	private static JComboBox<String> combo_clients_online;
	private static JTextArea area_messages;
	
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
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		Field with information about online clients
		field_clients_online = new JTextField("No clients online");
		field_clients_online.setBounds(10, 10, 200, 20);
		field_clients_online.setHorizontalAlignment(0);
		field_clients_online.setEditable(false);
		field_clients_online.setVisible(true);
		frame.add(field_clients_online);
		
		combo_clients_online = new JComboBox<String>();
		combo_clients_online.setBounds(10, 40, 200, 30);
		combo_clients_online.setVisible(true);
		frame.add(combo_clients_online);
		
		area_messages = new JTextArea();
		area_messages.setBounds(10, 80, 400, 100);
		area_messages.setVisible(true);
		frame.add(area_messages);
		
		combo_clients_online.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String client = combo_clients_online.getSelectedItem().toString();
				System.out.println(client);
			}
		} );
		
		this.db_query = new Query();
		
		updateStatus();
	}
	
	public void updateStatus() {
		Timer update = new Timer();

		update.schedule(new TimerTask() {
			public void run() {
//				Run update functions
				updateClients();
			}
		}, 0, 5000);
	}
	
	public void updateClients() {
		String message;
		int online = Query.online();
		
		if( online > 0 )
			message = String.format("Online %d clients", online);
		else
			message = "There is not clients online";
		
		field_clients_online.setText(message);
		
		ArrayList<Client> list = Query.listOnline();
		String[] map = new String[list.size()];
		
		for( int i = 0; i < list.size(); i++ )
			map[i] = String.format("%s", list.get(i).name);
		
		if( !combo_clients_online.isPopupVisible() )
			combo_clients_online.setModel( new DefaultComboBoxModel<String>( map ) );
	}
	
	public void loadMessages(String client) {
//		List messages
	}

//	Send message from UI
	
}
