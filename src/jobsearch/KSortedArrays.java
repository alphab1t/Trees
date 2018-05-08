package jobsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class KSortedArrays {
	
	class ArrayContainer implements Comparable<ArrayContainer> {
		int[] arr;
		int index;
		
		@Override
		public int compareTo(ArrayContainer o) {
			return this.arr[this.index]-o.arr[o.index];
		}
		
		ArrayContainer(int[] a, int id) {
			this.arr = a;
			this.index = id;
		}

	}
	
	public int[] MergeKSortedArrays(int[][] arrays) {
		PriorityQueue<ArrayContainer> pq = new PriorityQueue<ArrayContainer>();
		
		int total = 0; 
		for(int i = 0; i < arrays.length; i++) {
			pq.add(new ArrayContainer(arrays[i], 0));
			total+=arrays[i].length;
		}
		
		int[] result = new int[total];
		int m = 0;
		while(!pq.isEmpty()){
			ArrayContainer min = pq.poll();
			result[m++] = min.arr[min.index];
			if(min.index < min.arr.length-1) {
				pq.add(new ArrayContainer(min.arr, min.index+1));
			}
		}
	
		return result;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[][] input = {{1, 3, 5, 18, 21},
				{2, 4, 6, 19, 20}};
		KSortedArrays ksort = new KSortedArrays();
		System.out.println(Arrays.toString(ksort.MergeKSortedArrays(input)));
		
		int[][] M = {{1, 5, 9}
		,{10, 11, 13}
		,{12, 13, 15}};
		
		System.out.println(ksort.kthSmallest(M, 7));
		*/
		//populate();
		
		int[] p = {1, 2, 3};
		//System.out.println(coinChange(12, p, p.length));
		combinationSum(p, 5);
		System.out.println(result.toString());
		//System.out.println(total(12, p, 0));
	}
	
	
	public int kthSmallest(int[][] matrix, int k) {
	    int m=matrix.length;
	 
	    int lower = matrix[0][0];
	    int upper = matrix[m-1][m-1];
	 
	    while(lower<upper){
	        int mid = lower + ((upper-lower)>>1);
	        int count = count(matrix, mid);
	        if(count<k){
	            lower=mid+1;
	        }else{
	            upper=mid;
	        }
	    }
	 
	    return upper;
	}
	 
	private int count(int[][] matrix, int target){
	    int m=matrix.length;
	    int i=m-1;
	    int j=0;
	    int count = 0;
	 
	    while(i>=0&&j<m){
	        if(matrix[i][j]<=target){
	            count += i+1;
	            j++;
	        }else{
	            i--;
	        }
	    }
	 
	    return count;
	}
	
	static Map<AtomicInteger, AtomicInteger> map = new HashMap<AtomicInteger, AtomicInteger>();
	
	public static void populate() {
		AtomicInteger val = map.get(4);
		if(val == null) System.out.println("Value does not exist");
		
	}
	
	public static int coinChange(int target, int[] points, int p) {
		if(target == 0) return 1;
		if(target < 0) return 0;
		if(p <= 0 && target >= 1) return 0;
		return coinChange(target, points, p-1) + coinChange(target-points[p-1], points, p);
		
	}
	
	static List<List<Integer>> result;
	static int min = Integer.MAX_VALUE;
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		result = new ArrayList<List<Integer>>();
		List<Integer> currentResult = new ArrayList<Integer>();
		combinationSumUtil(candidates, 0, target, currentResult) ;
		System.out.println(min);
		return result;        
	}

	public static void combinationSumUtil(int[] candidates, int index, int target, List<Integer> currentResult)           {
		if(target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>(currentResult);
			min = Math.min(min, currentResult.size());
			result.add(temp);
			return;
		}

		for(int i = index; i < candidates.length; i++) {
			if(target < candidates[i]) return;
			currentResult.add(candidates[i]);
			combinationSumUtil(candidates, i, target-candidates[i], currentResult);
			currentResult.remove(currentResult.size()-1);
		}
	}
	
	public static int coinChange(int[] points, int start, int target) {
		int combo = 0;
		if(target == 0) return 1;
		if(target > 1 && start == points.length) return 0;
		
		for(int i = start; i < points.length; i++) {
			if(points[i]<target) {
				combo+=1+coinChange(points, i, target-points[i]);
			} else {
				combo+=coinChange(points, i, target);
			}
		}
		
		return combo;
	}
	
	public static int total(int n, int[] v, int i) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		// means coins over and n>0 so no solution
		if (i == v.length && n > 0) {
			return 0;
		}
		return total(n - v[i], v, i) + total(n, v, i + 1);
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int lenght = prices.length;
		
		int[] leftProfit = new int[lenght];
		int leftMaxProfit = 0;
		int leftMin = prices[0];
	    for (int i=0; i<lenght; i++) {
	    	if (prices[i] < leftMin) leftMin = prices[i];
	    	if (prices[i] - leftMin > leftMaxProfit) leftMaxProfit = prices[i]-leftMin;
	    	leftProfit[i] = leftMaxProfit;
	    }
	    
	    int maxProfit = 0;
	    int rightMaxProfit = 0;
		int rightMax = prices[lenght-1];
		for (int i=lenght-1; i>=0; i--) {
	    	if (prices[i] > rightMax) rightMax = prices[i];
	    	if (rightMax - prices[i] > rightMaxProfit) rightMaxProfit = rightMax - prices[i];
	    	int currentProfit = rightMaxProfit + (i>0 ? leftProfit[i-1] : 0);
	    	if (currentProfit > maxProfit) {
	    		maxProfit = currentProfit;
	    	}
	    }
		
	    return maxProfit;
	}
}
