package util;

public class DListNode {
	public int key;
	public int val;
	public DListNode pre;
	public DListNode next;
	// dummy
	public DListNode head;
	public DListNode tail;

	public DListNode(int k, int v) {
		this.key = k;
		this.val = v;
		this.pre = null;
		this.next = null;
		this.head = null;
		this.tail = null;
	}
	public String toString(){
		DListNode n = head;
		String s = "";
		while (n != null) {
			s += n.val + " ";
			n = n.next;
		}
		s += "/n";
		
		n = tail;
		while (n != null) {
			s += n.val + " ";
			n = n.pre;
		}
		return s;
	}

}
