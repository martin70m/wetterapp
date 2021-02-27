package martin70m.weather.server;

import martin70m.weather.data.WetterTransfer;

public class WeatherServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Server starts...");
		boolean download = false;
		for(String arg:args) {
			if(arg.equals("true"))
				download = true;
		}
		WetterTransfer.start(download);
	}

}
