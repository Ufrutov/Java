package ui;

import javax.swing.JFrame;

import personajes.Animal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppUi {
//	App window reference
	private static JFrame window;
	private static final int screenWidth = 500;
	private static final int screenHeight = 500;
//	Main function
	public static void main( String[] arg ){
//		Create app window
		window = new JFrame("My cool game");
		window.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Clicked on "+arg0.getX()+":"+arg0.getY());
			}
		});
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		window.setBounds(100, 100, screenWidth, screenHeight);
		
		window.setVisible(true);
		
		Animal sheep = new Animal("sheep", "assets\\sheep.png");
		sheep.start();
		sheep.show(window);
	}
	
}
