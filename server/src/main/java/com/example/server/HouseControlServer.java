package com.example.server;


import com.example.server.httpentities.InitialValuesLoader;
import com.example.utils.DomoBusConfigLoader;
import com.example.utils.domain.HomeConfigEntity;
import com.example.server.httpentities.DeviceStateResponse;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HouseControlServer {

	public static int PORT = 9000;
	private static String CONFIG_FILENAME = "basic_config_1.xml";
	private static String INITIAL_VALUES_FILENAME = "initial_values.json";

	private static HomeConfigEntity homeConfiguration;
	private HttpServer server;

	/**
	 * { device_ID, device_current_value }
	 */
	private static ConcurrentHashMap<String, DeviceStateResponse> devicesValues = new ConcurrentHashMap<>();

	public static List<DeviceStateResponse> deviceValuesToDevicesResponse(){
		List<DeviceStateResponse> list = new ArrayList<>();
		for (Map.Entry<String, DeviceStateResponse> entry : devicesValues.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

	public static ConcurrentHashMap<String, DeviceStateResponse> getDevicesValues(){
		return devicesValues;
	}

	public static HomeConfigEntity getHomeConfigurationEntity(){
		return homeConfiguration;
	}

	private HouseControlServer(){

		// get initial values from json file
		devicesValues = InitialValuesLoader.getDeviceInitialValues(INITIAL_VALUES_FILENAME);
	}

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

	public void startServer(int port) {
		try {
			server = HttpServer.create(new InetSocketAddress(port), 0);
			System.out.println("Server started at " + port);

			// Creating HTTP context
			server.createContext("/", new Handlers.RootHandler());
			server.createContext("/echoHeader", new Handlers.EchoHeaderHandler());
			server.createContext("/echoGet", new Handlers.EchoGetHandler());
			server.createContext("/echoPost", new Handlers.EchoPostHandler());
			server.createContext("/devices", new Handlers.DevicesHandler());
			server.createContext("/divisions", new Handlers.DivisionsHandler());
			server.createContext("/events", new Handlers.EventsHandler());
			server.createContext("/overview", new Handlers.OverviewHandler());
			server.setExecutor(null);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Stop() {
		server.stop(0);
		System.out.println("server stopped");
	}

	// Main

	public static void main(String[] args) {

		System.out.println("=> Creating Server");
		HouseControlServer houseControl = new HouseControlServer();

		// parsing configuration file
		System.out.println("=> Parsing configuration file ...");
		DomoBusConfigLoader configLoader = new DomoBusConfigLoader(CONFIG_FILENAME, true);
		HomeConfigEntity homeConfig = configLoader.getHomeConfig();

		if (homeConfig == null) {
			System.out.println("!!! Error parsing the house configuration file! :( !!!");
		} else {
			houseControl.setHomeConfiguration(configLoader.getHomeConfig());

			// startServer http server
			System.out.println("=> Starting HTTP Server ...");
//			SimpleHttpServer httpServer = new SimpleHttpServer();
			houseControl.startServer(PORT);

			// startServer command receiver
			System.out.println("=> Starting Command Receiver ...");
			ControlCommandReceiver commandReceiver = new ControlCommandReceiver();
			commandReceiver.start();
		}
	}
}
