package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

	public static void main(String[] args) throws InterruptedException {
		/*Semaphore sem= new Semaphore(1);
		sem.acquire();
		sem.release();
		System.out.println("Avaliable permits: "+sem.availablePermits());*/
		
		Connection.getInstance().connect();
		ExecutorService executors = Executors.newCachedThreadPool();
		for(int i=0;i<200;i++){
			executors.submit(new Runnable() {
				
				@Override
				public void run() {
					try {
						Connection.getInstance().connect();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
		}
		executors.shutdown();
		executors.awaitTermination(1, TimeUnit.DAYS);
		

	}

}
