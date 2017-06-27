package com.thread;



public class ThreadDemo1 {

	public static void main(String[] args) {
		ThreadRunner runner1 = new ThreadRunner();
		runner1.start();
		
		ThreadRunner runner2 = new ThreadRunner();
		runner2.start();

	}

}
