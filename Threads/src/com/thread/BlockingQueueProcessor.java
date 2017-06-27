package com.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProcessor {

	private static BlockingQueue<Integer> queues = new ArrayBlockingQueue<>(10);

	private static void producer() throws InterruptedException {
		Random random = new Random();
		while (true) {
			queues.put(random.nextInt(100));
		}
	}

	private static void consumer() throws InterruptedException {
		Random random = new Random();
		while (true) {
			Thread.sleep(100);
			if (random.nextInt(10) == 0) {
				Integer value = queues.take();
				System.out.println("Taken value: " + value + "; Queue size is: " + queues.size());
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
