package DataStructure;

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
	private class LastElementTracker{
		private Node n;
		public LastElementTracker() {
			n=new Node(true);
		}
		private class Node{
			private boolean data;
			private Node link = null;//instance of a self refrancing class
			public Node(boolean data) {
				this.setData(data);
			}
			public Node(boolean data,Node node) {
				this.setData(data);
				this.setNode(node);
			}
			public boolean getData() {
				return data;
			}
			public void setData(boolean data) {
				this.data = data;
			}
			public void setNode(Node node) {
				link = node;
			}
			public Node nextNode() {
				return link;
			}
		}
		public Node getNode() {
			return n;
		}
		public void setNodeData(int nodeDepth,boolean input) {
			Node n = this.n;
			try {
				for (int i = 0; i < nodeDepth; i++) {
					n = n.nextNode();
				}
				n.setData(input);
			} catch (Exception e) {
				System.err.println("no such node");
			}
		}
		public void addNode(boolean data) {
			Node temp = new Node(data,this.n);
			this.n = temp;
		}
		public int size() {
			Node n = this.n;
			boolean a = true;
			boolean b = false;
			int returnVal = 0;
			while(hasNext(n)) {
				returnVal++;
				n = n.nextNode();
				if (b) {
					a = false;
				}else {
					b = n.nextNode()==null;
				}
			}
			return returnVal;
		}
		public boolean hasNext(Node n) {
			return n.nextNode()!=null;
		}
	}
	private Node head;
	private LastElementTracker tracker;
	public Heap() {
		head = null;
		tracker = new LastElementTracker();
	}
	public void addNode(int n) {
		if(head == null) {
			head = new Node(n);
		}else {
			DataStructure.Heap.LastElementTracker.Node nTrack = tracker.getNode();
			Node tempNode = head;
			while(tracker.hasNext(nTrack)) {
				tempNode = tempNode.getChild(tracker.getNode().getData());
			}
			Node valNode = new Node(n);
			if (tracker.getNode().getData()) {
				tempNode.setChild(valNode);
			}
		}
	}
	public void removeNode() {
		
	}
	public int output() {
		return head.getChild(true).getVal();
	}
}
