package com.example.smarthomeserver.server;



public class HouseControlServer {
	public static int PORT = 9000;

	public static void main(String[] args) {


		DomoBusConfigLoader configLoader = new DomoBusConfigLoader("DomoBusSystemConfig-1.xml");


		// start http server
		SimpleHttpServer httpServer = new SimpleHttpServer();
		httpServer.Start(PORT);
	}
}
