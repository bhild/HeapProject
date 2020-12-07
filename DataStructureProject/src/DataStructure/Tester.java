package DataStructure;

public class Tester {
	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.addNode(1);
		heap.addNode(2);
		heap.addNode(3);
		System.out.println(heap.output(false));
	}
}
