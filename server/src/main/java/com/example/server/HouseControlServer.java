package com.example.server;


import com.example.utils.DomoBusConfigLoader;
import com.example.utils.domain.HomeConfigEntity;
import com.example.utils.httpentities.DeviceStateResponse;
import com.example.utils.httpentities.DevicesResponse;
import com.example.utils.httpentities.PropertyValueResponse;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HouseControlServer {

	public static int PORT = 9000;
	public static String configFileName = "basic_config_1.xml";

	private static HomeConfigEntity homeConfiguration;
	private HttpServer server;

	/**
	 * { device_ID, device_current_value }
	 */
	private static ConcurrentHashMap<String, DeviceStateResponse> devicesValues = new ConcurrentHashMap<>();

	public static DevicesResponse deviceValuesToDevicesResponse(){
		List<DeviceStateResponse> list = new ArrayList<>();
		for (Map.Entry<String, DeviceStateResponse> entry : devicesValues.entrySet()) {
			list.add(entry.getValue());
		}
		return new DevicesResponse(list);
	}

	public static ConcurrentHashMap<String, DeviceStateResponse> getDevicesValues(){
		return devicesValues;
	}

	public static HomeConfigEntity getHomeConfigurationEntity(){
		return homeConfiguration;
	}

	public HouseControlServer(){

		DeviceStateResponse d = new DeviceStateResponse();
		d.setDeviceId("1");
		List<PropertyValueResponse> pvr = new ArrayList<>();
		pvr.add(new PropertyValueResponse("1", "300"));
		pvr.add(new PropertyValueResponse("2", "ON"));
		d.setValues(pvr);

		DeviceStateResponse d2 = new DeviceStateResponse();
		d2.setDeviceId("2");
		List<PropertyValueResponse> pvr2 = new ArrayList<>();
		pvr2.add(new PropertyValueResponse("1", "23"));
		d2.setValues(pvr2);

		devicesValues.put("1", d);
		devicesValues.put("2", d2);
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
		DomoBusConfigLoader configLoader = new DomoBusConfigLoader(configFileName, true);
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
