import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class SaveImgDiallog {

	private JFrame frame;
	private JTextField textField;
	public JTextPane textPane;
	private JProgressBar progressBar;
	private Boolean running = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveImgDiallog window = new SaveImgDiallog("Save image from web page v.1.0");
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
	public SaveImgDiallog(String title) {
		initialize(title);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String title) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
//		Dialog layout
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblUrl = new JLabel("URL:");
		panel.add(lblUrl);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(15);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnSaveIt = new JButton("Save it!");
		btnSaveIt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String url = textField.getText();
				if(url.length() != 0 && !running) {
					if(Util.openStream(url)) {
						textPane.setText("");
						Util.appendText(textPane, "Start to download from "+url, "default");
						Util.getImg(running, url, textPane, progressBar);
					} else
						Util.appendText(textPane, "Error Url: "+url, "error");
				}
			}
		});
		panel_1.add(btnSaveIt);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		progressBar = new JProgressBar();
		panel_2.add(progressBar, BorderLayout.SOUTH);
		
		textPane = new JTextPane();
		panel_2.add(textPane, BorderLayout.CENTER);
	}
}
