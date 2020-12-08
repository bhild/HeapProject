package DataStructure;

import java.util.ArrayList;

public class Heap {
	private class Node {
		private Node children[] = new Node[2];
		private int val;
		public Node(int val) {
			this.val = val;
		}
		public void setChild(Node n) {
			if(children[0]==null) {
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
		public boolean[] hasChildren() {
			boolean[] returnArr = {children[0]!=null,children[1]!=null};
			return returnArr;
		} 
		public int getVal() {
			return val;
		}
	}
	private Node head;
	private ArrayList<Boolean> tracker;
	public Heap() {
		head = null;
		tracker = new ArrayList<Boolean>();
		tracker.add(true);
	}
	public void addNode(int n) {
		if(head == null) {
			head = new Node(n);
		}else {
			Node tempNode = head;
			for(int i = 1; i < tracker.size();i++) {
				tempNode = tempNode.getChild(tracker.get(i));
			}
			Node valNode = new Node(n);
			updateTracker(tracker.size()-1);
			tempNode.setChild(valNode);
		}
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
		if((element!=tracker.size()-1||tracker.size()==1)&&!tracker.contains(true)) {
			for (int i = 0; i < tracker.size(); i++) {
				tracker.set(i, true);
			}
			tracker.add(true);
		}else {
			tracker.set(element, !tracker.get(element));	
			if (tracker.get(element)==true&&element-1>=0) {
				System.out.println(true);
				updateTracker(element-1);
			}
		}
	}
}
