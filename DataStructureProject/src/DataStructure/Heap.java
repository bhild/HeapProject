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
	public void addNode() {
		
	}
	public void removeNode() {
		
	}
}
