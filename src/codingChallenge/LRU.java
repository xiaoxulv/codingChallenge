package codingChallenge;

import java.util.HashMap;
import java.util.Map;

import util.DListNode;

public class LRU {
	Map<Integer, DListNode> map;
	DListNode head;
	DListNode tail;
	int cap;

	public LRU(int capacity) {
		this.map = new HashMap<Integer, DListNode>();
		this.cap = capacity;
		head = new DListNode(0, 0);
		tail = new DListNode(-1, -1);
		head.next = tail;
		tail.pre = head;
	}

	public void remove(DListNode cur) {
		cur.pre.next = cur.next;
		cur.next.pre = cur.pre;
	}

	// move a node to tail of the list
	public void toTail(DListNode cur) {
		cur.pre = tail.pre;
		tail.pre = cur;
		cur.pre.next = cur;
		cur.next = tail;
	}

	public int get(int key) {
		//not in map
		if (!map.containsKey(key))
			return -1;
		DListNode cur = map.get(key);
		//newly used to tail
		remove(cur);
		toTail(cur);
		return map.get(key).val;
	}

	public void set(int key, int value) {
		//in map, directly set the value
		if (get(key) != -1){
			map.get(key).val = value;
			return;
		}
		//not in map, first check capacity
		//exceed capacity, delete head(LRU) 
		if(map.size() == cap){
			map.remove(head.next.key);
			head.next = head.next.next;
			head.next.pre = head;
		}
		//insert new one, both in map and list
		DListNode node = new DListNode(key, value);
		map.put(key, node);
		toTail(node);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRU a = new LRU(3);
		a.set(1,1);
		System.out.println(a.get(1));
		a.set(2,2);
		System.out.println(a.get(2));
		a.set(3,3);
		System.out.println(a.get(3));
		a.set(4,4);
		System.out.println(a.get(1));
	}

}
