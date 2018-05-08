package jobsearch;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RunExecutor {
	
	AtomicInteger count;
	
	RunExecutor() {
		count = new AtomicInteger(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean [][] i = new boolean[4][5];
		Arrays.fill(i, true);
		System.out.println(i);
	}

}
