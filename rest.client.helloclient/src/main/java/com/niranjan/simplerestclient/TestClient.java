package com.niranjan.simplerestclient;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestClient {
	
	private static String queryURL = "http://localhost:8080/rest.server.helloserver/rest/sayHello";

	public static void main(String[] args) {

		int numberOfThreads = Runtime.getRuntime().availableProcessors() * 80 / 100;
		System.out.println("Starting client with " + numberOfThreads + " threads");
		if (args.length > 0) {
			queryURL = "http://" + args[0] + "/rest.server.helloserver/rest/sayHello";
			System.out.println("queryURL: " + queryURL);
		}
		for(int i=0; i<numberOfThreads; i++) {
			Executor executor = Executors.newFixedThreadPool(numberOfThreads);
			executor.execute(() -> callServer());
		}

	}

	private static void callServer( ) {
		for(;;) {
			try {
				Client client = Client.create();

				WebResource webResource = client
						.resource(queryURL);

				ClientResponse response = webResource.accept("text/plain")
						.get(ClientResponse.class);

				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ response.getStatus() + " Status:  " + response.getStatusInfo());
				}

				String output = response.getEntity(String.class);

				System.out.println("Thread: " + Thread.currentThread().getName() + " - " + output);
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
