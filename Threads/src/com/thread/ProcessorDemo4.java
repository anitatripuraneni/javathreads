package com.thread;

import java.util.Scanner;

public class ProcessorDemo4 {

	public static void main(String[] args) {
		Processor proc1 = new Processor();
		proc1.start();
		System.out.println("press return to stop.....");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		proc1.shutDown();

	}

}

