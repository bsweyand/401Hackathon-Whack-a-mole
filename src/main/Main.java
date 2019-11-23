package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import assets.TimerWidget;

public class Main {
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Whack-a-mole");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(750,780));
		frame.setResizable(false);
		frame.setContentPane(new WhackAMoleWidget());
		frame.pack();
		frame.setVisible(true);
	}
}
