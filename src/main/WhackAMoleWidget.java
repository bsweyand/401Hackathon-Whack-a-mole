package main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import assets.Mole;
import assets.MoleImpl;
import assets.MoleObserver;
import assets.ScoreWidget;
import assets.TimerObserver;
import assets.TimerWidget;

public class WhackAMoleWidget extends JPanel implements TimerObserver,ActionListener{
	
	private TimerWidget timer;
	private ScoreWidget score;
	private List<Mole> moles;
	boolean running = false;
	JButton startButton;
	public WhackAMoleWidget()
	{
		JPanel molePanel = new JPanel();
		score = new ScoreWidget();
		timer = new TimerWidget(20);
		moles = new ArrayList<Mole>();
		timer.addTimerObserver(this);
		GridLayout layout = new GridLayout(4,4);
		layout.setVgap(0);
		layout.setHgap(0);
		molePanel.setLayout(layout);
		for(int i=0; i < 16; i++)
		{
			
			MoleImpl mole = new MoleImpl(3 + (int)(Math.random() * 2), 3 + (int)(Math.random() * 3) ,6 + (int)(Math.random() * 4));
			molePanel.add(mole);
			mole.addMoleObserver(score);
			moles.add(mole);
		}
		
		//create start button
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		startButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		startButton.setBounds(132, 219, 203, 53);
		startButton.addActionListener(timer);
		startButton.addActionListener(this);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(timer, BorderLayout.CENTER);
		bottomPanel.add(score, BorderLayout.WEST);
		bottomPanel.add(startButton, BorderLayout.EAST);
		
		this.setLayout(new BorderLayout());
		add(molePanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!running)
		{
			running = true;
			score.reset();
			for(Mole mole : moles)
			{
				mole.start();
			}
		}
	}

	@Override
	public void timeOut() {
		for(Mole mole : moles)
			mole.stop();
		running = false;
		JOptionPane.showMessageDialog(null, "Your Score is:  " + score.getScore());
		
	}

}
