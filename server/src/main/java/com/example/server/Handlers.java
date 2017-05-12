package com.example.server;

import com.example.utils.ServerConstants;
import com.example.utils.Utils;
import com.example.utils.domain.Device;
import com.example.server.httpentities.DeviceStateResponse;
import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.URLDecoder;
import java.util.*;

/**
 * Inspired by Source code from Andy Feng
 * https://www.codeproject.com/Tips/1040097/Create-a-Simple-Web-Server-in-Java-HTTP-Server
 */
public class Handlers {

	public static class RootHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange he) throws IOException {
			String response = "<h1>Server startServer success if you see this message</h1>" + "<h1>Port: " + HouseControlServer.PORT + "</h1>";
			he.sendResponseHeaders(200, response.length());
			OutputStream os = he.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}

	public static class DevicesHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange he) throws IOException {

			String requestMethod = he.getRequestMethod();
			URI requestedUri = he.getRequestURI();
			String path = requestedUri.getPath();
			String jsonString = "";
			Gson gson = new Gson();

			// ["devices", ... ]
			String[] pathParameters = Utils.stripStringIntoV(path.substring(1), ServerConstants.Handlers.BAR);

			switch(requestMethod){

				case ServerConstants.CRUD.GET:

					if(pathParameters.length == 1) { // /devices -> show all devices

						jsonString = gson.toJson(HouseControlServer.deviceValuesToDevicesResponse());
					} else {
						String deviceId = pathParameters[1];
						DeviceStateResponse deviceState = HouseControlServer.getDevicesValues().get(deviceId);
						jsonString = gson.toJson(deviceState);
					}

					break;
				case ServerConstants.CRUD.PUT:

					break;
			}

			// See Response
			printRequest(requestMethod, path, jsonString);

			// Send response
			String response = jsonString;
			he.sendResponseHeaders(200, response.length());
			OutputStream os = he.getResponseBody();
			os.write(response.toString().getBytes());
			os.close();
		}
	}

	public static class DivisionsHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange he) throws IOException {
			String requestMethod = he.getRequestMethod();
			URI requestedUri = he.getRequestURI();
			String path = requestedUri.getPath();
			String jsonString = "";
			Gson gson = new Gson();

			// ["devices", ... ]
			String[] pathParameters = Utils.stripStringIntoV(path.substring(1), ServerConstants.Handlers.BAR);

			switch(requestMethod){

				case ServerConstants.CRUD.GET:

					if(pathParameters.length == 1) { // /divisions -> show all devices

					} else { // /divisions/{id}/devices
						String divisionId = pathParameters[1];
						String option = pathParameters[2];

						if (ServerConstants.Handlers.DEVICES.equals(option)) {

							List<Device> devices = HouseControlServer.getHomeConfigurationEntity().getDevicesByDivisionID(divisionId);
							List<DeviceStateResponse> myDevicesState = new ArrayList<>();

							for (Device d : devices) {
								myDevicesState.add(HouseControlServer.getDevicesValues().get(d.getId()));
							}

							jsonString = gson.toJson(myDevicesState);
						}
					}

					break;
			}

			// See Response
			printRequest(requestMethod, path, jsonString);

			// Send response
			String response = jsonString;
			he.sendResponseHeaders(200, response.length());
			OutputStream os = he.getResponseBody();
			os.write(response.toString().getBytes());
			os.close();
		}
	}
	public static class EventsHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange he) throws IOException {

		}
	}
	public static class OverviewHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange he) throws IOException {

		}
	}

	/**
	 * For test purposes
	 */

	public static class EchoGetJSONHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange he) throws IOException {
			// parse request
			Map<String, Object> parameters = new HashMap<String, Object>();
			URI requestedUri = he.getRequestURI();
			String query = requestedUri.getRawQuery();
			parseQuery(query, parameters);

			String jsonString = new JSONObject()
					.put("JSON1", "Hello World!")
					.put("QUERY", query)
					.put("JSON3", "Hello my World!")
					.put("JSON4", new JSONObject()
							.put("key1", "value1")).toString();

			System.out.println(jsonString);
			System.out.println(requestedUri.getPath());
			System.out.println(he.getRequestMethod());

			// send response
			String response = jsonString;
			he.sendResponseHeaders(200, response.length());
			OutputStream os = he.getResponseBody();
			os.write(response.toString().getBytes());
			os.close();
		}
	}

	public static class EchoHeaderHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange he) throws IOException {
			Headers headers = he.getRequestHeaders();
			Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
			String response = "";
			for (Map.Entry<String, List<String>> entry : entries)
				response += entry.toString() + "\n";
			he.sendResponseHeaders(200, response.length());
			OutputStream os = he.getResponseBody();
			os.write(response.toString().getBytes());
			os.close();
		}
	}

	public static class EchoGetHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange he) throws IOException {
			// parse request
			Map<String, Object> parameters = new HashMap<String, Object>();
			URI requestedUri = he.getRequestURI();
			String query = requestedUri.getRawQuery();
			parseQuery(query, parameters);
			// send response
			String response = "";
			for (String key : parameters.keySet())
				response += key + " = " + parameters.get(key) + "\n";
			he.sendResponseHeaders(200, response.length());
			OutputStream os = he.getResponseBody();
			os.write(response.toString().getBytes());
			os.close();
		}

	}

	public static class EchoPostHandler implements HttpHandler {

		@Override
		public void handle(HttpExchange he) throws IOException {
			System.out.println("Served by /echoPost handler...");
			// parse request
			Map<String, Object> parameters = new HashMap<String, Object>();
			InputStreamReader isr = new InputStreamReader(he.getRequestBody(), "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String query = br.readLine();
			parseQuery(query, parameters);
			// send response
			String response = "";
			for (String key : parameters.keySet())
				response += key + " = " + parameters.get(key) + "\n";
			he.sendResponseHeaders(200, response.length());
			OutputStream os = he.getResponseBody();
			os.write(response.toString().getBytes());
			os.close();

		}
	}

	@SuppressWarnings("unchecked")
	public static void parseQuery(String query, Map<String, Object> parameters) throws UnsupportedEncodingException {

		if (query != null) {
			String pairs[] = query.split("[&]");

			for (String pair : pairs) {
				String param[] = pair.split("[=]");

				String key = null;
				String value = null;
				if (param.length > 0) {
					key = URLDecoder.decode(param[0], System.getProperty("file.encoding"));
				}

				if (param.length > 1) {
					value = URLDecoder.decode(param[1], System.getProperty("file.encoding"));
				}

				if (parameters.containsKey(key)) {
					Object obj = parameters.get(key);
					if (obj instanceof List<?>) {
						List<String> values = (List<String>) obj;
						values.add(value);
					} else if (obj instanceof String) {
						List<String> values = new ArrayList<String>();
						values.add((String) obj);
						values.add(value);
						parameters.put(key, values);
					}
				} else {
					parameters.put(key, value);
				}
			}
		}
	}

	public static void printRequest(String reqMethod, String path, String json){
		System.out.println("Request: " + reqMethod + " " + path);
		System.out.println("Response: " + json);
	}
}
