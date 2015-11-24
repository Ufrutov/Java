import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JTabbedPane;


public class GUIApp {

	private JFrame frame;
	private JTextField field_fname;
	private JTextField field_lname;
	private JTextField field_age;
	private JTextField field_job;
	private JTextArea txtrText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIApp window = new GUIApp();
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
	public GUIApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Person DB");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Add new", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblPersonForm = new JLabel("Person form:");
		lblPersonForm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(lblPersonForm);
		
		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("right:4dlu"),
				ColumnSpec.decode("left:max(50dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(lblNewLabel, "2, 2, right, default");
		
		field_fname = new JTextField();
		field_fname.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(field_fname, "4, 2, left, default");
		field_fname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(lblNewLabel_1, "2, 4, right, default");
		
		field_lname = new JTextField();
		field_lname.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(field_lname, "4, 4, left, default");
		field_lname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(lblNewLabel_2, "2, 6, right, default");
		
		field_age = new JTextField();
		field_age.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(field_age, "4, 6, left, default");
		field_age.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Job");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(lblNewLabel_3, "2, 8, right, default");
		
		field_job = new JTextField();
		field_job.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(field_job, "4, 8, left, default");
		field_job.setColumns(10);
		
		txtrText = new JTextArea();
		txtrText.setEditable(false);
		txtrText.setMargin(new Insets(10, 10, 10, 10));
		txtrText.setBackground(UIManager.getColor("Panel.background"));
		panel_2.add(txtrText, "2, 10, 3, 1, fill, fill");
		
		JPanel panel = new JPanel();
		panel_3.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Save person");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				byte age = 0;
				
				
				Person p = new Person(
					field_fname.getText(),
					field_lname.getText(),
					Byte.valueOf( (field_age.getText().length()==0) ? "0" : field_age.getText() ),
					field_job.getText()
				);
				
//				Validate new Person object
				if( !p.validateFName() ) {
					txtrText.setText("[E] Wrong first name input! ("+p.getFname()+")");
					return; }
				
				if( !p.validateLName() ) {
					txtrText.setText("[E] Wrong last name input! ("+p.getLname()+")");
					return; }
				
				if( !p.validateAge() ) {
					txtrText.setText("[E] Wrong person age input! ("+p.getAge()+")");
					return; }
				
				if( !p.validateLJob() ) {
					txtrText.setText("[E] Wrong person job input! ("+p.getJob()+")");
					return; }
				
				txtrText.setText("[S] Success saved "+p.getFname()+" "+p.getLname()+"!");
				p.save();
				clearForm();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("List", null, panel_4, null);
	}
	
	public void clearForm() {
		field_fname.setText(null);
		field_lname.setText(null);
		field_age.setText(null);
		field_job.setText(null);
	}

}
