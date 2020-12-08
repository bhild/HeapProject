package DataStructure;

import java.util.ArrayList;

public class Heap {
	private class Node {
		private Node children[] = new Node[2];
		private Node parent;
		private int val;
		public Node(int val,Node parent) {
			this.val = val;
			this.parent = parent;
		}
		public void setChild(Node n,boolean side) {
			if(side) {
				children[0]=n;
			}else {
				children[1]=n;
			}
		}
		public Node getChild(boolean side) {
			if(side) {
				return children[0];
			}else {
				return children[1];
			}
		}
		public Node getParent() {
			return parent;
		}
		public void setVal(int val) {
			this.val = val;
		}
		/*
		public boolean[] hasChildren() {
			boolean[] returnArr = {children[0]!=null,children[1]!=null};
			return returnArr;
		} 
		*/
		public int getVal() {
			return val;
		}
	}
	private Node head;
	private ArrayList<Boolean> tracker;
	public Heap() {
		head = new Node(1,null);
		tracker = new ArrayList<Boolean>();
		tracker.add(true);
	}
	public void addNode(int n) {
		Node tempNode = head;
		//System.out.print(tracker.get(0)+" ");
		for(int i = 0; i < tracker.size()-1;i++) {
			if(tracker.size()!=1) {
				tempNode = tempNode.getChild(tracker.get(i));	
			}
			//System.out.print(tempNode.getVal()+" "+n+" "+tracker.get(i)+"\t");
		}
		Node valNode = new Node(n,tempNode);
		tempNode.setChild(valNode,tracker.get(tracker.size()-1));
		//System.out.println();
		sortMax(valNode);
		updateTracker(tracker.size()-1);
	}
	public void removeNode() {
		
	}
	public int output(boolean[] path) {
		Node out = head;
		try {
			for (boolean i : path) {
				out = out.getChild(i);
			}
		} catch (Exception e) {
			System.err.println("no such node//path");
		}
		return out.getVal();
	}
	private void updateTracker(int element) {
		if((element==tracker.size()-1||tracker.size()==1)&&!tracker.contains(true)) {
			for (int i = 0; i < tracker.size(); i++) {
				tracker.set(i, true);
			}
			tracker.add(true);
		}else {
			tracker.set(element, !tracker.get(element));	
			if (tracker.get(element)==true&&element-1>=0) {
				updateTracker(element-1);
			}
		}
	}
	private void sortMax(Node n) {
		Node p = n.getParent();
		boolean end = true;
		while (!p.equals(null)&&end) {
			if (n.getVal()>p.getVal()) {
				int pStore = p.getVal();
				p.setVal(n.getVal());
				n.setVal(pStore);
			}else {
				end = false;
			}
			n=p;
			p=p.getParent();
		}
	}
}
