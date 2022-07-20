package observer;

//Same as subscriber
public interface Observer {
	
	public void update(float temp, float humidity, float pressure);

}
