package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Whack-a-mole");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600,600));
		frame.setResizable(false);
		frame.setContentPane(new WhackAMoleWidget());
		frame.pack();
		frame.setVisible(true);
	}
}
