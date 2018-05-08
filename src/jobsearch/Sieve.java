package jobsearch;

import java.util.List;

public class Sieve {

	void sieve(int n) {
		boolean[] prime = new boolean[n+1];
		
		for(int i = 0; i < n; i++) {
			prime[i] = true;
		}
		
		for(int p = 2; p*p <=n; p++) {
			if(prime[p] == true) {
				for(int i = p*2; i<=n; i+=p) {
					prime[i] = false;
				}
			}
		}
		
		for(int i = 2; i <=n; i++) {
			if(prime[i] == true) 
			{
				System.out.println(i);
			}
		}
	}
	
	int findMissing(int[] input) {
		int l = 0;
		int r = input.length-1;
		
		while ( l <= r) {
			int m = (l+r)>>2;
			if(input[m] != m) {
				if(m == 0 || input[m-1] == m-1) {
					return m;
				}
				r = m-1;
			} else {
				l = m+1;
			}
			
		}
		return -1;
	}
	
	int countBits(int num) {
		int count = 0;
		while(num != 0 ) {
			num &= (num-1);
			count++;
		}
		return count;
	}
	
	int subList(List<Integer> l1, List<Integer> l2){
		int res = -1;
		if(l2.isEmpty()) return res;
		for(Integer i : l1){
			if(i.equals(l2.get(0))){
				res = i;
				while(l2.get(i++) == l1.get(i++));
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sieve s = new Sieve();
		//s.sieve(31);
		System.out.println(s.countBits(8));
	}
	
	

}
