import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HangmanDrawing extends JPanel {

	private JPanel contentPane;
	private HangmanList list;
	
	public HangmanDrawing(HangmanList hangman) {
		list = hangman;
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(100, 300, 100, 50);
        g.drawLine(200, 50, 100, 50);
        g.drawLine(200, 100, 200, 50);
        switch(list.getGuesses()) {
        case 5: drawHead(g);
        	break;
        case 4: drawHead(g);
        		drawBody(g);
        	break;
        case 3: drawHead(g);
				drawBody(g);
        		drawRightArm(g);
        	break;
        case 2: drawHead(g);
				drawBody(g);
				drawRightArm(g);
				drawLeftArm(g);
        	break;
        case 1: drawHead(g);
        		drawBody(g);
        		drawRightArm(g);
        		drawLeftArm(g);
        		drawRightLeg(g);
        	break;
        case 0: drawHead(g);
				drawBody(g);
				drawRightArm(g);
				drawLeftArm(g);
				drawRightLeg(g);
				drawLeftLeg(g);
			break;
        }
	}
	
	private void drawHead(Graphics g) {
		 g.drawOval(50, 300, 100, 50);
	     g.drawOval(175, 100, 50, 50);
	}
	
	private void drawBody(Graphics g) {
		g.drawLine(200, 200, 200, 150);
	}
	
	private void drawRightLeg(Graphics g) {
		g.drawLine(200, 200, 250, 250);
	}
	
	private void drawLeftLeg(Graphics g) {
		g.drawLine(200, 200, 150, 250);
	}
	
	private void drawLeftArm(Graphics g) {
        g.drawLine(150, 150, 200, 175);
	}
	
	private void drawRightArm(Graphics g) {
		g.drawLine(250, 150, 200, 175);
	}

}
