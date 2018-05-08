package jobsearch;

import java.util.ArrayList;

public class RBHashTable<V, K> {
	
	private ArrayList<RBHashNode<K, V>> table;
	private int size;
	private int maxSz;
	private int lf;
	
	RBHashTable(int sz, int maxSz, int lf) {
		table = new ArrayList<RBHashNode<K, V>>();
		this.size = sz;
		this.maxSz = maxSz;
		for(int i = 0; i < this.size; i++) {
			table.add(null);
		}
	}
	
	class RBHashNode<K,V> {
		K key;
		V value;
		
		RBHashNode<K, V> next;	
		
		RBHashNode(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	
	
	
	private int getIndex(K key) {
		return (key.hashCode()%this.size);
	}
	
	private boolean contains(K key) throws IllegalArgumentException {
		if(key == null) throw new IllegalArgumentException();
		return table.get(getIndex(key)) != null;
	}
	
	private void add(K key, V value) {
		int index = getIndex(key);
		RBHashNode<K, V> head = table.get(index);
		while(head != null) {
			if(key.equals(head.key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		size++;
		head = table.get(index);
		RBHashNode<K,V> newNode = new RBHashNode<K, V>(key,value);
		newNode.next = head;
		head = newNode;
		table.set(index, newNode);
		
		if(size/maxSz >= lf) {
			ArrayList<RBHashNode<K, V>> temp = table;
			table = new ArrayList<>();
			this.maxSz *=2;
			for(int i = 0; i < maxSz; ++i ){
				table.add(null);
			}
			for(RBHashNode<K, V> node : temp) {
				while(node != null) {
					add(node.key, node.value);
					node = node.next;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
