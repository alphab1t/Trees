package jobsearch;

import java.util.HashMap;
import java.util.Map;

public class DictionaryEntries {

	  /*Input : dict(“a”: “apple”, 
	   * 			 “b”: dict(“b”: “blueberry”, “c”: “cranberry”))
	   *Expected output String : “{a:apple,b:{b:blueberry,c:cranberry}}” */

	public interface Entry {
		public boolean isDict();
	}
	
	public class DictEntry implements Entry {
		Map<String, Entry> map;
		
		DictEntry(Map<String, Entry> m) {
			this.map = m;
		}

		@Override
		public boolean isDict() {
			// TODO Auto-generated method stub
			return true;
		}
	}
	
	public class SimpEntry implements Entry{

		String value;
		
		public SimpEntry(String string) {
			// TODO Auto-generated constructor stub
			this.value = string;
		}

		@Override
		public boolean isDict() {
			// TODO Auto-generated method stub
			return false;
		}	
	}
	
	public String serialize(Entry entry) {
		if(entry == null) return new String();
		StringBuilder sb = new StringBuilder();
		if(entry.isDict()) {
			DictEntry dictEntry = (DictEntry) entry;
			sb.append("{");
			if(!dictEntry.map.isEmpty()) {
				for(String s : dictEntry.map.keySet()) {
					sb.append(s);
					sb.append(":");
					sb.append(serialize(dictEntry.map.get(s)));
				}
			}
			sb.append("}");
		} else {
			sb.append(entry.toString());
		}
		return sb.toString();
	}
	
	public int maxSum(int[] A, int n) {

		int currentSum = A[0];
		int maxSum = 0;
		int subSum = 0;
		for(int i = 1; i < n; i++) {
			subSum += maxSum (A, i);
			if(A[i] > A[i-1] && subSum > currentSum) {
				currentSum = subSum;
			}
			maxSum = Math.max(currentSum, maxSum);
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Entry> m1 = new HashMap<String, Entry>();
		m1.put("b", new DictionaryEntries().new SimpEntry("blueberry"));
		m1.put("c", new DictionaryEntries().new SimpEntry("cranberry"));
		DictEntry b = new DictionaryEntries(). new DictEntry(m1);

		Map<String, Entry> m2 = new HashMap<String, Entry>();
		m2.put("a", new DictionaryEntries().new SimpEntry("apple"));
		m2.put("b", b);
		
		DictEntry d = new DictionaryEntries().new DictEntry(m2);
	}

}
