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
		System.out.println(heap.output(new boolean[] {false,false,false}));
	}
}
