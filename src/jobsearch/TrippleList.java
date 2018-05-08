package jobsearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TrippleList {

	private List<List<List<Integer>>> trippleList;
	Stack<Iterator<Integer>> S = new Stack<Iterator<Integer>>();
	
	TrippleList() {
		
	}
	
	TrippleList(List<List<List<Integer>>> tripple) {
		Iterator outer = tripple.iterator();
		while(outer.hasNext()) {
			ArrayList<Integer> midList = (ArrayList<Integer>) outer.next();
			Iterator mid = midList.iterator();
			while(mid.hasNext()) {
				ArrayList<Integer> innerList = (ArrayList<Integer>) mid.next();
				Iterator<Integer> inner = innerList.iterator();
				while(inner.hasNext()) {
					System.out.print(inner.next());
					System.out.print(",");
				}
			}
			
		}
	}
	
	/*public boolean hasNext() {
		
	}
	
	public int next() {
		
	}

	*/
	
	
	 
	
	    /* A utility function that returns minimum of 3 integers */
	    private int min(int x, int y, int z)
	    {
	        return Math.min(x, Math.min(y, z));
	    }
	 
	    private int minCost(int cost[][], int m, int n)
	    {
	        int i, j;
	        int tc[][]=new int[m+1][n+1];
	 
	        tc[0][0] = cost[0][0];
	 
	        /* Initialize first column of total cost(tc) array */
	        for (i = 1; i <= m; i++)
	            tc[i][0] = tc[i-1][0] + cost[i][0];
	 
	        /* Initialize first row of tc array */
	        for (j = 1; j <= n; j++)
	            tc[0][j] = tc[0][j-1] + cost[0][j];
	 
	        /* Construct rest of the tc array */
	        for (i = 1; i <= m; i++)
	            for (j = 1; j <= n; j++)
	                tc[i][j] = min(tc[i-1][j-1], 
	                               tc[i-1][j],
	                               tc[i][j-1]) + cost[i][j];
	 
	        return tc[m][n];
	    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TrippleList t = new TrippleList();
		
		int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
		System.out.println("minimum cost to reach (2,2) = " +
                                  t.minCost(cost,2,2));
 
 /*
		List<Integer> n1 = new ArrayList<Integer>();
		n1.add(1);
		n1.add(2);
		n1.add(3);
		
		List<Integer> n2 = new ArrayList<Integer>();
		n2.add(5);
		n2.add(8);
		n2.add(11);
		
		List<List<Integer>> l1 = new ArrayList<List<Integer>>();
		l1.add(n1);
		l1.add(n2);
		
	
		
		List<Integer> n12 = new ArrayList<Integer>();
		n12.add(11);
		n12.add(22);
		n12.add(33);
		
		List<Integer> n21 = new ArrayList<Integer>();
		n21.add(51);
		n21.add(82);
		n21.add(114);
		
		
     	List<List<Integer>> l2 = new ArrayList<List<Integer>>();
		l2.add(n12);
		l2.add(n21);
		
		List<List<List<Integer>>> tripple = new ArrayList<List<List<Integer>>>();
		
		tripple.add(l1);
		tripple.add(l2);
		
		
		TrippleList t = new TrippleList(tripple);
		tripple.toString();
		*/
	}

}
