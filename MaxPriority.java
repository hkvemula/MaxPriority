import java.util.Scanner;

/**
 * 03/28/2020
 * 
 * @author Harika K Vemula
 *
 */
public class MaxPriority {
	public int[] arr;
	public int size, maxsize;

	public static void main(String[] arg) {
		MaxPriority obj = new MaxPriority(10);
		System.out.print("Enter 10 values :");
		Scanner sn = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			int a = sn.nextInt();
			obj.insertion(a);
		}
		sn.close();
		obj.print();
		System.out.println("The element removed after first deletion:" + obj.GetHigh());
		System.out.println("The element removed after second deletion: " + obj.GetHigh());

	}

	/**
	 * This method is used for performing the max-priority queue process.
	 * @param maxsize
	 */
	public MaxPriority(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		int n = maxsize;
		arr = new int[n + 1];
		arr[0] = 9999999;
	}

	/**
	 * This method is used for inserting the value by comparing it with the parent node.
	 * @param e
	 */
	public void insertion(int e) {
		arr[++size] = e;
		int in = size;
		while (arr[in] > arr[parent(in)]) {
			int tmp = arr[in];
			arr[in] = arr[parent(in)];
			arr[parent(in)] = tmp;
			in = parent(in);
		}
	}

	/**
	 * Here it performs deletion of elements from the queue.
	 * @return
	 */
	public int GetHigh() {
		int pop = arr[1];
		arr[1] = arr[size--];
		maxHeapify(1);
		return pop;
	}

	/**
	 * In this method parent node, intermediate nodes and child nodes are inserted in a max heap data structure based on the size calculations of the elements.
	 * @param in
	 */
	public void maxHeapify(int in) {
		if (leaf(in)) {
			return;
		}
		if (arr[in] < arr[getleft(in)] || arr[in] < arr[getright(in)]) {
			if (arr[getleft(in)] > arr[getright(in)]) {
				int tmp = arr[in];
				arr[in] = arr[getleft(in)];
				arr[getleft(in)] = tmp;
				maxHeapify(getleft(in));
			} else {
				int tmp = arr[in];
				arr[in] = arr[getright(in)];
				arr[getright(in)] = tmp;
				maxHeapify(getright(in));
			}
		}
	}

	/**
	 * In this it calculates the size of the element and which be inserted as a parent node.
	 * @param in
	 * @return
	 */
	public int parent(int in) {
		return in / 2;
	}

	/**
	 * In this it calculates the size of the elements and which should be inserted at the right of the parent node.
	 * @param in
	 * @return
	 */
	public int getright(int in) {
		return (2 * in) + 1;
	}

	/**
	 * In this it calculates the size of the elements and which should be inserted at the left of the parent node.
	 * @param in
	 * @return
	 */
	public int getleft(int in) {
		return (2 * in);
	}

	/**
	 * Here it performs a condition statement which helps to insert nodes in a max heap data structure.
	 * @param
	 * @return
	 */
	public boolean leaf(int in) {
		if (in >= size / 2 && in <= size)
			return true;
		else
			return false;
	}

	/**
	 * Printing method
	 */
	public void print() {
		System.out.print("The elements of the max-priority queue: ");
		for (int i = 1; i <= size; i++) {
			System.out.print(arr[i] + " ");

		}
		System.out.println();
	}

}