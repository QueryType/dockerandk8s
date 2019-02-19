package com.niranjan.docker;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class HelloJava {
	
	private static final int MILLISECONS_IN_SECONDS = 1000;

	public static void main(String[] args) throws InterruptedException {
		for (;;) {
			System.out.println("Hello Java - version 1.0 - with uuid: " + UUID.randomUUID());
			Thread.sleep(5 * MILLISECONS_IN_SECONDS);
		}
	}

}