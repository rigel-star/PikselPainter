package org.piksel.piksel;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class PikselPainter extends JFrame {
	private static final long serialVersionUID = 1L;

	public PikselPainter() {
		setSize(600, 600);
		setTitle("Test");
		setDefaultCloseOperation(PikselPainterWindow.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		
		JDesktopPane p = new JDesktopPane();
		p.add(new PikselPainterWindow.InternalWindow(300, 300));
		
		add(p);
	}
	
	public static void main(String[] args) {
		new PikselPainter();
		new PikselPainterWindow(500, 500, "My window");
	}
}
