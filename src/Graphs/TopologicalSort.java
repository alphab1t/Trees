package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

	class GraphNode {
		int value;
		List<GraphNode> children;
		
		GraphNode(int val) {
			this.value = val;
			this.children = new ArrayList<GraphNode>();
		}
	}
	
	class Graph {
		int vertices;
		GraphNode[] graph;
	}
	
	public void TopologicalSort(Graph g) {
		Set<GraphNode> visited = new HashSet<GraphNode>();
		Stack<GraphNode> sort = new Stack<GraphNode>();
		
		for(GraphNode n : g.graph) {
			if(!visited.contains(n)) {
				topologicalSortUtil(n, visited, sort);
			}
		} 
		
	}
	
	public void topologicalSortUtil(GraphNode node, Set<GraphNode> visited, Stack<GraphNode> sort) {
		visited.add(node);
		for(GraphNode c : node.children) {
			if(!visited.contains(c)) {
				topologicalSortUtil(c, visited, sort);
			}
		}
		sort.push(node);
	}
	   
	public static int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0, max = 0;
		Set<Character> set = new HashSet<>();

		while (right < s.length()) {
			if (!set.contains(s.charAt(right))) {
				set.add(s.charAt(right++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(left++));
			}
		}

		return max;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLongestSubstring("abcadef");
	}

}
