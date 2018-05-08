import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class EshaanFirstAddition {

	public static boolean wordPatternMatch(String pattern, String str) {
		if(pattern.length()==0 && str.length()==0)
			return true;
		if(pattern.length()==0)
			return false;

		HashMap<Character, String> map = new HashMap<Character, String>();

		return helper(pattern, str, 0, 0, map);
	}

	public static boolean helper(String pattern, String str, int i, int j, HashMap<Character, String> map){
		if(i==pattern.length() && j==str.length()){
			return true;
		}

		if(i>=pattern.length() || j>=str.length())
			return false;

		char c = pattern.charAt(i);
		for(int k=j+1; k<=str.length(); k++){
			String sub = str.substring(j, k);
			if(!map.containsKey(c) && !map.containsValue(sub)){
				map.put(c, sub);
				if(helper(pattern, str, i+1, k, map))
					return true;
				map.remove(c);
			}else if(map.containsKey(c) && map.get(c).equals(sub)){
				if(helper(pattern, str, i+1, k, map))
					return true;
			}
		}

		return false;
	}

	public static int KthLargest(int k, int nums[]) {

		if (k < 1 || nums == null) {
			return 0;
		}

		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}

	public static int getKth(int k, int[] nums, int start, int end) {

		int pivot = nums[end];

		int left = start;
		int right = end;

		while (true) {

			while (nums[left] < pivot && left < right) {
				left++;
			}

			while (nums[right] >= pivot && right > left) {
				right--;
			}

			if (left == right) {
				break;
			}

			swap(nums, left, right);
			System.out.println("pivot:" + pivot + " left:" + left + ":" + nums[left] + " right:" + right + " :" + nums[right]);
		}
		System.out.println(Arrays.toString(nums));
		swap(nums, left, end);

		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}

	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}


	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> ret = new ArrayList<>(); 
		if (words == null || words.length < 2) return ret;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i=0; i<words.length; i++) map.put(words[i], i);
		for (int i=0; i<words.length; i++) {
			// System.out.println(words[i]);
			for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);
				if (isPalindrome(str1)) {
					String str2rvs = new StringBuilder(str2).reverse().toString();
					if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(map.get(str2rvs));
						list.add(i);
						ret.add(list);
						// System.out.printf("isPal(str1): %s\n", list.toString());
					}
				}
				if (isPalindrome(str2)) {
					String str1rvs = new StringBuilder(str1).reverse().toString();
					// check "str.length() != 0" to avoid duplicates
					if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
						List<Integer> list = new ArrayList<Integer>();
						list.add(i);
						list.add(map.get(str1rvs));
						ret.add(list);
						// System.out.printf("isPal(str2): %s\n", list.toString());
					}
				}
			}
		}
		return ret;
	}

	private static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left <= right) {
			if (str.charAt(left++) !=  str.charAt(right--)) return false;
		}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(wordPatternMatch("abab", "redblueredblue"));	

		//KthLargest(2, new int[] {3, 4,2,6,8, 12, 19, 54, 7, 11});
		//palindromePairs(new String[] {"bat", "tab", "cat"});
		//longestConsecutive(new int[] {0, 1, 3, 5 , 4, 2});
		rearrangeString("aabbcc", 3);
	}

	public static int longestConsecutive(int[] nums) {
		Set<Integer> num_set = new HashSet<Integer>();
		for (int num : nums) {
			num_set.add(num);
		}

		int longestStreak = 0;

		for (int num : num_set) {
			if (!num_set.contains(num-1)) {
				int currentNum = num;
				int currentStreak = 1;

				while (num_set.contains(currentNum+1)) {
					currentNum += 1;
					currentStreak += 1;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}

		return longestStreak;
	}
	
	public static String rearrangeString(String str, int k) {
	    if(k==0)
	        return str;
	 
	    //initialize the counter for each character
	    final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i=0; i<str.length(); i++){
	        char c = str.charAt(i);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c, 1);
	        }
	    }
	 
	    //sort the chars by frequency
	    PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>(){
	        public int compare(Character c1, Character c2){
	            if(map.get(c2).intValue()!=map.get(c1).intValue()){
	                return map.get(c2)-map.get(c1);
	            }else{
	                return c1.compareTo(c2);
	            }
	        }
	    });
	 
	 
	    for(char c: map.keySet())
	        queue.offer(c);
	 
	    StringBuilder sb = new StringBuilder();
	 
	    int len = str.length();
	 
	    while(!queue.isEmpty()){
	 
	        int cnt = Math.min(k, len);
	        ArrayList<Character> temp = new ArrayList<Character>();
	 
	        for(int i=0; i<cnt; i++){
	            if(queue.isEmpty())//\\
	                return "";
	 
	            char c = queue.poll();
	            sb.append(String.valueOf(c));
	 
	            map.put(c, map.get(c)-1);
	 
	            if(map.get(c)>0){
	                temp.add(c);
	            }
	 
	            len--;
	        }
	 
	        for(char c: temp)
	            queue.offer(c);//\\
	    }
	 
	    return sb.toString();
	}

}
