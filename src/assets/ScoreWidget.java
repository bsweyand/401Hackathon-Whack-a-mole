package assets;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ScoreWidget extends JPanel {

	/**
	 * Create the panel.
	 */
	public ScoreWidget() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblScore, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblNewLabel, BorderLayout.CENTER);

	}

}
