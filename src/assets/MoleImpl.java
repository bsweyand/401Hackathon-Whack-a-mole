package assets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoleImpl extends JPanel implements Mole, Runnable{
	
	//set variables for the amount of time a mole spends up, the minWaitTime before popping up, the maxWaitTime before popping up
	private int upTime;
	private int minWaitTime;
	private int maxWaitTime;
	private boolean isUp;
	private final String IMAGE_PATH = "/mole.png";
	JLabel picture;
	
	public MoleImpl(int upTime, int minWaitTime, int maxWaitTime)
	{
		this.upTime = upTime;
		this.minWaitTime = minWaitTime;
		this.maxWaitTime = maxWaitTime;
		
		try {
		setLayout(new BorderLayout());
		setBackground(new Color(1,1,1));
		BufferedImage myPicture = ImageIO.read(getClass().getResource(IMAGE_PATH));
		picture = new JLabel(new ImageIcon(myPicture));
		add(picture, BorderLayout.CENTER);
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean isUp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void popUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
