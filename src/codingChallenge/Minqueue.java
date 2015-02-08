package codingChallenge;

import java.util.LinkedList;
import java.util.Queue;

public class Minqueue {
	Minstack s1 = new Minstack(1000);
	Minstack s2 = new Minstack(1000);
	public int getMin(){
		return Math.min(s2.min(), s1.min());
	}
	public void push(int val){	
		s1.push(val);
	
	}
	public int pop(){
 		if(s2.isEmpty())
 			while(!s1.isEmpty())
 				s2.push(s1.pop());
 		return s2.pop();
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minqueue mq = new Minqueue();
		mq.push(1);
		System.out.println(mq.getMin());
		
		mq.push(4);
		System.out.println(mq.getMin());
		
		mq.push(2);
		System.out.println(mq.getMin());
		
		mq.push(3);
		System.out.println(mq.getMin());
		
		
		System.out.println(mq.pop());
		System.out.println(mq.getMin());
		System.out.println(mq.pop());
		System.out.println(mq.getMin());
		System.out.println(mq.pop());
		System.out.println(mq.getMin());
	}

}
