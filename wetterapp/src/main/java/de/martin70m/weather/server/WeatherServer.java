package martin70m.weather.server;

import martin70m.weather.data.WetterTransfer;

public class WeatherServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Server starts...");
		WetterTransfer.start(true);
	}

}
