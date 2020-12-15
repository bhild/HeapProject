package DataStructure;

import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		Heap heap = new Heap(1);
		//heap.addNode(1);
		heap.addNode(2);
		heap.addNode(3);
		heap.addNode(4);
		heap.addNode(5);
		heap.addNode(6);
		heap.addNode(7);
		heap.addNode(8);
		heap.addNode(9);
		heap.addNode(10);
		heap.addNode(11);
		heap.addNode(12);
		heap.addNode(13);
		heap.addNode(14);
		heap.addNode(15);

		System.out.println(heap.toString());
		heap.addNode(16);
		heap.addNode(17);
		heap.addNode(18);
		heap.addNode(19);
		heap.addNode(20);
		heap.addNode(21);
		heap.addNode(22);
		heap.addNode(23);
		heap.addNode(24);
		heap.addNode(25);
		heap.addNode(26);
		heap.addNode(27);
		heap.addNode(28);
		heap.addNode(29);
		heap.addNode(30);
		System.out.println(heap.toString());

	}
}
