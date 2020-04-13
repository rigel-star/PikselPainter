package org.piksel.piksel;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class PikselPainterWindow extends JFrame implements PikselPainterInit {

	private static final long serialVersionUID = 1L;

	/*If title not provided*/
	public PikselPainterWindow(int w, int h) {
		this(w, h, null);
	}
	
	public PikselPainterWindow(int w, int h, String title) {
		setSize(w, h);
		setTitle(title);
		setDefaultCloseOperation(PikselPainterWindow.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		add(new PaintCanvas(), BorderLayout.CENTER);
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	/**Internal frame!
	 * PikselPainterWindow class extends JFrame so we cannot use that class when we need internal window.
	 * This class helps bringing internal window if needed. This window also have canvas as same as main class.
	 * We can use both in different cases.
	 * */
	static class InternalWindow extends JInternalFrame {
		private static final long serialVersionUID = 1L;
		
		public InternalWindow(int w, int h) {
			this(w, h, null);
		}
		public InternalWindow(int w, int h, String title) {
			setSize(w, h);
			setTitle(title);
			setVisible(true);
			setLayout(new BorderLayout());
			add(new PaintCanvas(), BorderLayout.CENTER);			
		}
		
	}
	
	/*Helper class for applying canvas (drawing background) in frame*/
	static class PaintCanvas extends Canvas {
		private static final long serialVersionUID = 1L;
		
		public PaintCanvas() {
			setBackground(Color.white);
		}
		
		//pixelated background
		private void paintBackground(Graphics2D g2){
		    g2.setPaint(Color.LIGHT_GRAY);
		    int i;
		    int width = getSize().width;
		    int height = getSize().height;
		    int rows = 50, cols = 50;

		    // draw the rows
		    int rowHt = height / (rows) + 5;
		    for (i = 0; i < width; i++)
		      g2.drawLine(0, i * rowHt, width, i * rowHt);

		    // draw the columns
		    int rowWid = width / (cols) + 5;
		    for (i = 0; i < height; i++)
		      g2.drawLine(i * rowWid, 0, i * rowWid, height);
	    }
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			this.paintBackground(g2);
		}
	}
}
