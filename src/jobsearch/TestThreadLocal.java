package jobsearch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThreadLocal  {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Callable<String>> set = new HashSet<Callable<String>>();
		for(int i = 0; i <10; i++) {
			Callable<String> cp = new TestThread(new String("gc-collector-" + i));
			set.add(cp);
		}
		ExecutorService service = Executors.newSingleThreadExecutor();
		try {
			List<Future<String>> futures = service.invokeAll(set);
			for(Future<String> f : futures) {
				System.out.println(f.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
