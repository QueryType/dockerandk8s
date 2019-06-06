package com.niranjan.rest.service;


import java.time.LocalDateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/sayHello")
public class HelloService {
	
	private static String SERVER_NAME = "SERVER_" + System.currentTimeMillis();

	@GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
	    return "Hello from test service " + SERVER_NAME + " - " + LocalDateTime.now();
	  }
}
