package jobsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IncDec implements Runnable {

	private AtomicInteger number;
	private int state;
	private Object monitor;
	
	public IncDec(AtomicInteger n, Object o, Object monitor) {
		this.number = n;
		this.state = 1;
		this.monitor = monitor;
	}
	
	@Override
	public void run() {
		while(number.get() > 0 || number.get() < 10) {
			if(state == 1) {
				while(number.get() != 10) {
					System.out.println(number.getAndIncrement());
				}
				state = 0;
			} else {
				while(number.get() > 0) {
					System.out.println(number.getAndDecrement());
				}
				state = 1;
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		
		
		
		
		
		
		
		
	}

}
