package jobsearch;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadWithQueue implements Runnable {

	BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
	ThreadWithQueue next = null;
	AtomicInteger number;
	
	public void setNext(ThreadWithQueue q) {
		this.next = q;
	}
	
	public void accept(int i ) {
		q.add(i);
	}
	
	public ThreadWithQueue(AtomicInteger number) {
		this.number = number;
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		AtomicInteger num = new AtomicInteger();
		ThreadWithQueue w1 = new ThreadWithQueue(num);
		ThreadWithQueue w2 = new ThreadWithQueue(num);
		ThreadWithQueue w3 = new ThreadWithQueue(num);
	        
	        // chain them in a round robin fashion
	        w1.setNext(w2);
	        w2.setNext(w3);
	        w3.setNext(w1);
	        
	        // Create named threads for the workers
	        Thread t1 = new Thread(w1, "Thread-1 - ");
	        Thread t2 = new Thread(w2, "Thread-2 - ");
	        Thread t3 = new Thread(w3, "Thread-3 - ");
	        
	        // start the threads
	        t1.start();
	        t2.start();
	        t3.start();
	        
	        // Seed the first worker
	        w1.accept(1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				//int i = q.take();
				
				System.out.println(Thread.currentThread().getName() + " _ " + number.get());
				Thread.sleep(1000);
				if(next != null) {
					number.getAndIncrement();
				}
			} catch(InterruptedException e) {
				
			}
		}
	}

}
