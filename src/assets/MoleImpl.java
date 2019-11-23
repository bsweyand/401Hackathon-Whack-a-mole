package assets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoleImpl extends JPanel implements Mole, Runnable, MouseListener{
	
	//set variables for the amount of time a mole spends up, the minWaitTime before popping up, the maxWaitTime before popping up
	private double upTime;
	private double minWaitTime;
	private double maxWaitTime;
	private boolean isUp;
	private boolean gameRunning;
	private final String IMAGE_PATH = "/moleimg.png";
	private List<MoleObserver> observers;
	JLabel picture;
	Thread thread;
	
	public MoleImpl(double upTime, double minWaitTime, double maxWaitTime)
	{
		this.upTime = upTime;
		this.minWaitTime = minWaitTime;
		this.maxWaitTime = maxWaitTime;
		
		try {
		setLayout(new BorderLayout());
		setBackground(Color.decode("#34eb95"));
		
		//load picture from path
		BufferedImage myPicture = ImageIO.read(getClass().getResource(IMAGE_PATH));
		picture = new JLabel(new ImageIcon(myPicture));
		add(picture, BorderLayout.CENTER);
		
		picture.setVisible(false);
		isUp = false;
		observers = new ArrayList<MoleObserver>();
		gameRunning = false;
		addMouseListener(this);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	public void addMoleObserver(MoleObserver observer)
	{
		observers.add(observer);
	}
	
	public void removeMoleObserver(MoleObserver observer)
	{
		observers.remove(observer);
	}
	
	/**
	 * returns true if mole is up
	 */
	@Override
	public boolean isUp() {
		return isUp;
	}
	
	/**
	 * shows mole icon and set isUp flag to true
	 */
	@Override
	public void popUp() {
		isUp = true;
		picture.setVisible(true);
		
	}
	
	
	@Override
	public void hide()
	{
		isUp = false;
		picture.setVisible(false);
	}
	
	@Override
	public void start() {
		thread = new Thread(this);
		gameRunning = true;
		thread.start();	
	}

	@Override
	public void run() {
		while(gameRunning)
		{
			if(isUp())
			{
				try {
					Thread.sleep((long) (upTime * 1000));
					hide();
				} catch (InterruptedException e) {
					hide();
				}
				
			}
			else
			{
				double difference = maxWaitTime - minWaitTime;
				try {
					Thread.sleep((long) (minWaitTime + Math.random() * difference) * 1000);
					popUp();
				} catch (InterruptedException e) {
					hide();
				}
				
			}
		}
		
	}
	
	//stops the thread responsible for popping up and hiding the mole and sets gameRunning flag to false
	@Override
	public void stop() {
		gameRunning = false;
		thread.interrupt();
	}
	
	//notify observers given a passed in score
	public void notifyObservers(int score)
	{
		for(MoleObserver observer : observers)
			observer.update(score);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}
	
	//notifies observers based on whether or not the mole is up. Negative points are received if the mole is down
	@Override
	public void mousePressed(MouseEvent e) {
		if(gameRunning) {
			if(isUp())
			{
				notifyObservers(1);
				hide();
			}
			else
				notifyObservers(-1);
		}	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
