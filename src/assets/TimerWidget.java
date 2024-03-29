package assets;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TimerWidget extends JPanel implements ActionListener{

	private JButton startButton;
	private boolean running = false;
	/**
	 * Create the panel.
	 */
	private List<TimerObserver> observers;
	private int seconds;
	private int initialSeconds;
	private JLabel timerLabel;
	private Timer timer;
	public TimerWidget(int seconds) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		//create observer list and timer label
		observers = new ArrayList<TimerObserver>();
		timerLabel = new JLabel(Integer.toString(seconds) + " seconds left");
		timerLabel.setBounds(44, 84, 373, 110);
		timerLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(timerLabel, BorderLayout.NORTH);
		
		this.seconds = seconds;
		initialSeconds = seconds;

	}
	
	//Add observer for timeout
	public void addTimerObserver(TimerObserver observer)
	{
		observers.add(observer);
	}
	
	//remove observer for timeout
	public void removeTimerObserver(TimerObserver observer)
	{
		observers.remove(observer);
	}
	
	//notify all observers of timeout
	public void notifyObservers()
	{
		for(TimerObserver observer : observers)
			observer.timeOut();
	}
	
	/**
	 * adds action listener to the button in the widget
	 * @param actionListener - the actionlistener to add
	 */
	public void addActionListener(ActionListener actionListener)
	{
		startButton.addActionListener(actionListener);
	}

	/**
	 * Creates a new timer when start button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!running) {
			if(timer == null) {
				timer = new Timer(1000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						seconds--;
						if(seconds >= 0) {
							timerLabel.setText("" + seconds + " seconds left");
						}
						if(seconds == 0)
						{
							notifyObservers();
							running = false;
						}
					}
					
				});
				running = true;
				timer.start();
			}
			else
			{
				seconds = initialSeconds;
				timer.restart();
			}
		}
	}
}
