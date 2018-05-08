package jobsearch;

import java.util.concurrent.atomic.AtomicInteger;

public class TestExecutor implements Runnable{

	AtomicInteger c;
	
	TestExecutor(AtomicInteger count) {
		this.c = count;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		c.getAndIncrement();
		System.out.println("c:" + c.get() + " tid:" +  Thread.currentThread().getId());
	}

}
