package jobsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class FlatIterator<T> implements Iterator<T> {
	List<List<T>> listOfLists;
	
	List<Iterator<T>> itList;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
		List<Integer> i = new ArrayList<Integer>();
		Collections.addAll(i, 1,2,3,4);
		List<Integer> j = new ArrayList<Integer>();
		Collections.addAll(j, 6,7,8,9);
		listOfLists.add(i);
		listOfLists.add(j);
		
		FlatIterator<Integer> f = new FlatIterator<Integer>(listOfLists);
		while(f.hasNext()) {
			System.out.println(f.next());
		}*/
		//System.out.println(isSumString(new int[] {1, 2 ,3, 5, 9}));
		//System.out.println(findMountain(new int[] {1,2,3,4,5,9,6,2,2,1}));
		//fillUnique(new char[]{'a','a', 'b', 'b', 'c', 'c'});
		
		lengthOfLongestSubstringKDistinct("abcadcacacaca", 3);
	}

	public FlatIterator(List<List<Integer>> listOfLists2) {
		itList = new ArrayList<Iterator<T>>();
		Iterator<List<Integer>> outer = listOfLists2.iterator();
		while(outer.hasNext()) {
			List<T> inner = (List<T>) outer.next();
			Iterator<T> intT = inner.iterator();
			itList.add(intT);
		}
		
	}
	
	@Override
	public boolean hasNext() {
		return (!itList.isEmpty());
	}

	@Override
	public T next() {
		T t = null ;
		Iterator<Iterator<T>> listItr = itList.iterator();
		while(listItr.hasNext()) {
			Iterator<T> inListItr = listItr.next();
			while(inListItr.hasNext()) {
				t = inListItr.next();
				if(!inListItr.hasNext()) {
					listItr.remove();
				}
				return t;
			}
		}
		return t;
	}
	
	static class Data {
		int value;
		int index;
		
		Data(int v, int i) {
			this.value = v;
			this.index = i;
		}
	}
	
	public static int findMountain(int[] input) {
		Stack<Data> stack = new Stack<Data>();
		int res = 0;
		
		for(int i = 0; i < input.length; i++) {
			if(stack.isEmpty() || stack.peek().value <= input[i]) {
				stack.push(new Data(input[i], i));
			} else {
				while(input[i] < stack.peek().value) {
					stack.pop();
				}
				res = Math.max(res, i - stack.peek().value);
				stack.push(new Data(input[i], i));
			}
		}
		
		return res;
		
	}
	
	public static void fillUnique(char[] s) {
	    int n = s.length;
	    int[] count = new int[26];
	    int u = 0;
		for (int i=0; i<n; i++)
	    {
	        if (count[s[i]-'a']==0)
	            u++;
	        count[s[i]-'a']++;
	    }
		Set<Character> si = new HashSet<Character>();
		for(int i = 0; i < n; i++) {
			si.add(s[i]);
		}
		System.out.println("u:" + u + " sz:" + si.size());
	}
	
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
	    if(k==0 || s==null || s.length()==0)
	        return 0;
	 
	    if(s.length()<k)
	        return s.length();
	 
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
	    int maxLen=k;
	    int left=0;
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c, 1);
	        }
	 
	        if(map.size()>k){
	            maxLen=Math.max(maxLen, i-left);
	 
	            while(map.size()>k){
	 
	                char fc = s.charAt(left);
	                if(map.get(fc)==1){
	                    map.remove(fc);
	                }else{
	                    map.put(fc, map.get(fc)-1);
	                }
	 
	                left++;
	            }
	        }
	 
	    }
	 
	    maxLen = Math.max(maxLen, s.length()-left);
	 
	    return maxLen;
	}
	
	public static boolean isSumString(int[] input) {
		int i = 0;
		int len = input.length;
		for(int j = i+1; j + 1 < len ; j++, i++) {
			if(input[i] + input [j] != input [j+1]) return false;
		}
		return true;
	}
	

}
