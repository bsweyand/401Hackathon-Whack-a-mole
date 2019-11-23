package assets;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ScoreWidget extends JPanel implements MoleObserver{
	private int score;
	JLabel scoreLabel;
	/**
	 * Create the panel.
	 */
	public ScoreWidget() {
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.WHITE);
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblScore, BorderLayout.WEST);
		
		scoreLabel = new JLabel("0");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(scoreLabel, BorderLayout.CENTER);

	}
	
	public int getScore()
	{
		return score;
	}
	
	/**
	 * sets the score back to zero and resets score label
	 */
	public void reset()
	{
		score = 0;
		scoreLabel.setText("0");
	}
	
	/** 
	 * update the score using the score passed in
	 */
	@Override
	synchronized public void update(int score) {
		this.score += score;
		scoreLabel.setText(Integer.toString(this.score));
		
	}

}
