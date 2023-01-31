package fr.dawan.solid.loskov.good;

public class TransportationDeviceWithEngine extends TransportationDevice{
	
	private Engine engine;
	
	@Override
	public void startMoving() {
		engine.startEngine();
	}

}
