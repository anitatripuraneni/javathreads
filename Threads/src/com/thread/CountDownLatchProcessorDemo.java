package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchProcessorDemo {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executors = Executors.newFixedThreadPool(3);
		for(int i =0;i<3;i++){
			executors.submit(new CountDownLatchProcessor(latch));
		}
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
System.out.println("completed.");
	}

}
