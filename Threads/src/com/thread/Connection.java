package com.thread;

import java.util.concurrent.Semaphore;

public class Connection {
	private static Connection instance= new Connection();
	Semaphore sem= new Semaphore(10,true);
	private int connections =0;
	
	private Connection(){
		
	}
	public static Connection getInstance(){
		return instance;
	}

	public void connect() throws InterruptedException{
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			doconnect();
		}finally{
			sem.release();
		}
	}
	public void doconnect() throws InterruptedException{
		sem.acquire();
		
		synchronized (this) {
			connections++;
			System.out.println("Current connections: "+connections);
		}
		Thread.sleep(2000);
		synchronized (this) {
			connections--;
		}
	}


}
