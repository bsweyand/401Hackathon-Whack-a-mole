package main;

import java.awt.GridLayout;

import javax.swing.JPanel;

import assets.MoleImpl;
import assets.MoleObserver;

public class WhackAMoleWidget extends JPanel implements MoleObserver{
	
	public WhackAMoleWidget()
	{
		setLayout(new GridLayout(4,4));
		for(int i=0; i < 16; i++)
			add(new MoleImpl(1,1,1));
	}
	@Override
	public void update(int score) {
		// TODO Auto-generated method stub
		
	}

}
