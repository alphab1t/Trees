package jobsearch;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintThreads {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicInteger input = new AtomicInteger();
		input.set(1);
		Object monitor = new Object();
		Thread t1 = new Thread(new PrintNumber(1,2, input, monitor));
		Thread t2 = new Thread(new PrintNumber(2,2, input, monitor));
		Thread t3 = new Thread(new PrintNumber(3,2, input, monitor));

		t1.start();
		t2.start();
		t3.start();
	}

}
