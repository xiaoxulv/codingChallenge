package codingChallenge;

import java.util.ArrayList;
import java.util.List;

public class lca {
	// Tarjan's offline lowest common ancestor
	// using union-find 
	public class node{
		int val;
		int rank;
		node parent;
		List<node> children;
		
		public node(int value){
			this.val = value;
			this.rank = 0;
			this.parent = this;
			this.children = new ArrayList<node>();
		}
	}
	public node find(node x){
		if(x.parent == x)
			return x;
		// path compression here
		x.parent = find(x.parent);
		return x.parent;
	}
	public void union(node x, node y){
		node px = find(x);
		node py = find(y);
		 //union by rank here
		if(px == py)
			return;
		else if(px.rank > py.rank)  
            py.parent = px;  
        else if(px.rank < py.rank)  
            px.parent = py;  
        else{  
            py.parent = px;  
            px.rank++;  
        }  
	}
	boolean[] visit = new boolean[10000];
	node[] anc = new node[10000];
	public void lca(node u){
		for(node v : u.children){
			lca(v);
			union(u, v);
			anc[find(u).val] = u;
		}
		visit[u.val] = true;
		for(node v : u.children){//for each node 
			if(visit[v.val])
				System.out.println(u.val + " " + v.val 
						+ "  :" +anc[find(u).val].val);
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lca l = new lca();
		node a = l.new node(1);
		node b = l.new node(2);
		node c = l.new node(3);
		node d = l.new node(4);
		node e = l.new node(5);
		b.parent = a;
		c.parent = a;
		a.children.add(b);
		a.children.add(c);
		d.parent = b;
		e.parent = b;
		b.children.add(d);
		b.children.add(e);
		l.lca(a);
	}

}
