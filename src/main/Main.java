package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Whack-a-mole");
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension((int)screen.getWidth()/ 2, (int)screen.getHeight()/ 2));
		
		frame.setContentPane(new WhackAMoleWidget());
		frame.pack();
		frame.setVisible(true);
	}
}
