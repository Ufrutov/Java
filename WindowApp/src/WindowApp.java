import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Button;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;


public class WindowApp {

	private JFrame frame;
	private JTextField textField;
	public byte click1 = 1;
	public byte click2 = 1;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowApp window = new WindowApp();
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
	public WindowApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(this.getClass().getName().toString());
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		final JButton btnNewButton_1 = new JButton("Button");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField_1.setText(String.valueOf(click2++)+" clicks");
				btnNewButton_1.setText("Reverted");
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Magic button");
		
		btnNewButton.setToolTipText("Hit me again!");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				textField.setText(String.valueOf(click1++)+" clicks");
				btnNewButton_1.setText("No so much magic");
			}
		});
		panel.add(btnNewButton);
		
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("138px"),
				ColumnSpec.decode("66px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),}));
		
		JLabel label = new JLabel("No so magic button:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(label, "2, 2, right, default");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_1.add(textField_1, "4, 2, left, default");
		
		JLabel lblMagicButton = new JLabel("Magic button:");
		lblMagicButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(lblMagicButton, "2, 4, left, center");
		
		textField = new JTextField();
		panel_1.add(textField, "4, 4, left, top");
		textField.setColumns(10);
	}

}
