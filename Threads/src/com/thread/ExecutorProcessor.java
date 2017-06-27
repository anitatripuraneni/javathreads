package com.thread;

public class ExecutorProcessor implements Runnable {

	private int id;

	public ExecutorProcessor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("starting: " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed: " + id);
	}

}
