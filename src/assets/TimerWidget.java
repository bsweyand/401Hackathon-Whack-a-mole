package assets;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimerWidget extends JPanel {

	/**
	 * Create the panel.
	 */
	public TimerWidget() {
		setLayout(new BorderLayout());
		
		JLabel timerLabel = new JLabel("60");
		timerLabel.setBounds(44, 84, 373, 110);
		timerLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(timerLabel, BorderLayout.NORTH);
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {


			int i = 60;
			@Override
			public void actionPerformed(ActionEvent e) {
				Timer t = new Timer(1000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						i--;
						if(i>= 0) {
							timerLabel.setText(""+i);
						}
					}
					
				});
				t.start();
			}

			
		});
		startButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		startButton.setBounds(132, 219, 203, 53);
		add(startButton);

	}

}
