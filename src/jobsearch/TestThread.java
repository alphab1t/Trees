package jobsearch;

import java.util.concurrent.Callable;

public class TestThread implements Callable<String> {

	private String codeName = "";
	
	TestThread(String name) {
		this.codeName = name;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(codeName);
		return codeName;
	}
}
