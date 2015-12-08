package personajes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Animal extends Thread {
	
	private String name;
	private String img_url;
	private ImageIcon icon;
	private JLabel label;
	private Boolean stop = false;
	private String direction = "right";
	
	public void run() {
		while( !this.stop ) {
			try {
				System.out.println(this.label.getX());
			} catch(Exception e) {
				System.out.println(e);
			}
			
			switch( this.direction ) {
				case "left":
					if( this.label.getX() < 0  )
						move("right");
					else
						move("left");
					break;
				case "right":
					if( this.label.getX() > 400  )
						move("left");
					else
						move("right");
					break;
			}

			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void move(String direct) {
		int x = this.label.getX();
		int y = this.label.getY();
		
		switch( direct ) {
			case "left":
				x = (int)(x-(1+Math.random())*10);
				break;
			case "right":
				x = (int)(x+(1+Math.random())*10);
				break;
		}
		
		this.label.setBounds((int)(x-1-Math.random()*10), y, 74, 74);
		this.direction = direct;
	}
	
	public void moveLeft() {
//		Move on 10px to left
		move("left");
	}
	
	public void moveRight() {
//		Move on 10px to right
		move("right");
	}
	
	public Animal( String name, String img_url ) {
		this.name = name;
		this.img_url = img_url;
		
//		Create image object
		BufferedImage image = null;
//		Load image content from assests 
		try {
			image = ImageIO.read( new File(this.img_url) );
//			Create new graphic object
			this.icon = new ImageIcon(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	Show image at the app window
	public void show( JFrame window ) {
		this.label = new JLabel();
		this.label.setBounds(10, 10, 74, 74);
		this.label.setIcon(this.icon);
		
		window.getContentPane().add(this.label);
		
//		Force window refresh
		window.repaint();
	}
}
