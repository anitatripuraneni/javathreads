package com.thread;

public class RunnableRunner implements Runnable{

	@Override
	public void run() {
		for(int i =0;i<=10;i++){
			System.out.println("Hello "+i);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
