package com.thread;

public class DeadLockRunnerDemo {

	public static void main(String[] args) throws InterruptedException {
		final DeadLockRunner runner = new DeadLockRunner();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		runner.finished();
	}

}
