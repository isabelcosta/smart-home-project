package com.example.server;


import com.example.utils.DomoBusConfigLoader;
import com.example.utils.domain.HomeConfigEntity;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HouseControlServer {

	public static int PORT = 9000;
	public static String configFileName = "basic_config_1.xml";

	private HomeConfigEntity homeConfiguration;

	/**
	 * { device_ID, device_current_value }
	 */
	private ConcurrentHashMap<String, String> devicesValues = new ConcurrentHashMap<>();



	// Getters and Setters

	public HomeConfigEntity getHomeConfiguration() {
		return homeConfiguration;
	}

	public void setHomeConfiguration(HomeConfigEntity homeConfiguration) {
		this.homeConfiguration = homeConfiguration;
	}

	// Helpers

	public void populateDeviceValues(){

	}

	// Main

	public static void main(String[] args) {

		System.out.println("=> Creating Server");
		HouseControlServer houseControl = new HouseControlServer();

		// parsing configuration file
		System.out.println("=> Parsing configuration file ...");
		DomoBusConfigLoader configLoader = new DomoBusConfigLoader(configFileName, true);
		HomeConfigEntity homeConfig = configLoader.getHomeConfig();

		if (homeConfig == null) {
			System.out.println("!!! Error parsing the house configuration file! :( !!!");
		} else {
			houseControl.setHomeConfiguration(configLoader.getHomeConfig());

			// start http server
			System.out.println("=> Starting HTTP Server ...");
			SimpleHttpServer httpServer = new SimpleHttpServer();
			httpServer.start(PORT);

			// start command receiver
			System.out.println("=> Starting Command Receiver ...");
			ControlCommandReceiver commandReceiver = new ControlCommandReceiver();
			commandReceiver.start();
		}
	}
}
