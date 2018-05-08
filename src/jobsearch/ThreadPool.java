package jobsearch;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool extends Thread{

	private BlockingQueue<Runnable> tasks;
	private AtomicBoolean isRunning;
	
	public ThreadPool(BlockingQueue<Runnable> q, AtomicBoolean isRunning) {
		this.tasks = q;
		this.isRunning = isRunning;
	}

	@Override
	public void run() {
		Runnable runtask;
		while(isRunning.get() || !tasks.isEmpty()) {
			while ((runtask = tasks.poll()) != null) {
				runtask.run();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
