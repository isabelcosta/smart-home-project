package com.example.server;


import com.example.utils.DomoBusConfigLoader;
import com.example.utils.domain.HomeConfigEntity;

import java.util.HashMap;

public class HouseControlServer {

	public static int PORT = 9000;

	HomeConfigEntity homeConfiguration;

	/**
	 * { device_ID, device_current_value }
	 */
	HashMap<String, String> devicesValues = new HashMap<>();


	public static void main(String[] args) {


		DomoBusConfigLoader configLoader = new DomoBusConfigLoader("basic_config_1.xml", true);

		// start http server
		SimpleHttpServer httpServer = new SimpleHttpServer();
		httpServer.start(PORT);
		HouseControlCommand commandReceiver = new HouseControlCommand();
		commandReceiver.start();
	}
}
