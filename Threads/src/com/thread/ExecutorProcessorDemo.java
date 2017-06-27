package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorProcessorDemo {

	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(2);
		for(int i =0;i<5;i++){
			executors.submit(new ExecutorProcessor(i));
		}
		
		executors.shutdown();
		System.out.println("All tasks started");
		try {
			executors.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All tasks completed.");

	}

}
