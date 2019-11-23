package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import assets.MoleImpl;
import assets.MoleObserver;
import assets.ScoreWidget;
import assets.TimerWidget;

public class WhackAMoleWidget extends JPanel implements MoleObserver{
	
	private TimerWidget tm = new TimerWidget();
	
	public WhackAMoleWidget()
	{
		JPanel molePanel = new JPanel();
		
		molePanel.setLayout(new GridLayout(4,4));
		for(int i=0; i < 16; i++)
			molePanel.add(new MoleImpl(1,1,1));

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(new TimerWidget(), BorderLayout.EAST);
		bottomPanel.add(new ScoreWidget(), BorderLayout.WEST);
		
		this.setLayout(new BorderLayout());
		add(molePanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	@Override
	public void update(int score) {
		// TODO Auto-generated method stub
		
	}

}
