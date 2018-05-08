package jobsearch;

import java.util.Comparator;

public class Sorter {
	
	class StringComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return Integer.compare(o1.length(), o2.length());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}



}
