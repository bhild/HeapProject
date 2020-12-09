package DataStructure;

import java.util.ArrayList;


public class Heap {
	private class Node {
		private Node children[] = new Node[2];
		private Node parent;
		private int val;
		public Node() {}
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
	public Heap(int firstElement) {
		head = new Node(firstElement,null);
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
	public void removeNode(boolean[] path) {
		Node out = head;
		try {
			for (boolean i : path) {
				out = out.getChild(i);
			}
		} catch (Exception e) {
			System.err.println("no such node//path");
		}
		updateTrackerBackWards(tracker.size()-1);
		Node deep = head;
		for (boolean i : tracker) {
			deep=deep.getChild(i);
		}
		out.setVal(deep.getVal());
		deep.getParent().setChild(null, tracker.get(tracker.size()-1));
		sortMax(out);
		backSortMax(out);
	}
	public void setNode(boolean[] path, int val) {
		Node out = head;
		try {
			for (boolean i : path) {
				out = out.getChild(i);
			}
		} catch (Exception e) {
			System.err.println("no such node//path");
		}
		sortMax(out);
		backSortMax(out);
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
	private void updateTrackerBackWards(int element) {
		if((element==tracker.size()-1||tracker.size()==1)&&!tracker.contains(false)) {
			for (int i = 0; i < tracker.size(); i++) {
				tracker.set(i, false);
			}
			tracker.remove(0);
		}else {
			tracker.set(element, !tracker.get(element));	
			if (tracker.get(element)==true&&element-1>=0) {
				updateTracker(element-1);
			}
		}
	}
	private void sortMax(Node n) {
		Node p = null;
		try {
			p = n.getParent();
		} catch (Exception e) {
			System.err.println("err");
		}
		boolean end = true;
		while (p!=null&&end) {
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
	private void backSortMax(Node n) {
		Node[] children = new Node[2];
		boolean side = true;
		children[0] = n.getChild(true);
		children[1] = n.getChild(false);
		if(children[0]==null) {
			return;
		}
		int temp = n.getVal();
		if (children[1]!=null) {
			if(children[0].getVal()>temp) {
				n.setVal(children[0].getVal());
				children[0].setVal(temp);	
			}else if(children[1].getVal()>temp) {
				side=false;
				n.setVal(children[1].getVal());
				children[1].setVal(temp);
				
			}else {
				return;
			}
		}else {
			if (children[0].getVal()>temp) {
				n.setVal(children[0].getVal());
				children[0].setVal(temp);
			}else {
				return;
			}
		} 
		backSortMax(n.getChild(side));
	}
}