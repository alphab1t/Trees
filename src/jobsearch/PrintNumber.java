package jobsearch;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintNumber implements Runnable {

	private AtomicInteger number;
	private int threadNumber;
	private Object monitor;
	private int numThreads;
	
	public PrintNumber(int num, int tn, AtomicInteger ai, Object monitor) {
		this.threadNumber = num;
		this.number = ai ;
		this.monitor = monitor;
		this.numThreads = tn;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(number.get() <= 10) {
			synchronized(monitor) {
				if(number.get()% this.numThreads == this.threadNumber){
					System.out.println(number.get() + " printed by thread:" + this.threadNumber);
					number.getAndIncrement();
				} else {
					
					try {
						monitor.notify();
						monitor.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
