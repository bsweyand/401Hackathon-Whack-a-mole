package assets;

public interface Mole {
	public boolean isUp();
	public void popUp();
	public void hide();
	public void start();
	public void stop();
	public void addMoleObserver(MoleObserver observer);
	
}
