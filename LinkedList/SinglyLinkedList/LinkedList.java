package LinkedList.SinglyLinkedList;

public class LinkedList {

	private class Node {
		private Node next;
		private int data;
	}

	private Node head;
	private Node tail;
	private int size = 0;

	// Q09_GetNodeAt(n)-----------------------------------------------------------------------------------------------
	public Node GetNodeAt(int pos) {

		Node cnode = this.head;
		int count = 0;
		while (count < pos) {
			cnode = cnode.next;
			count++;
		}
		return cnode;
	}

	// General_Functions.---------------------------------------------------------------------------------------------
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}

	public void display() {
		Node node = this.head;
		for (int i = 0; i < this.size; i++) {
			System.out.print(node.data + ",");
			node = node.next;
		}
		System.out.println();
	}

	//delete a Linked List

	public void Clear() throws Exception {
		if (this.size == 0) {
			throw new Exception("LIst is Already empty");
		}
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// clone_list

	public void clone(LinkedList oth) {
		this.head = oth.head;
		this.tail = oth.tail;
		this.size = oth.size;
	}

	// AddFunctions--------------------------------------------------------------------------------------------------

	public void AddFirst(int data) {
		Node node = new Node();
		node.data = data;
		if (this.size == 0) {
			this.head = node;
			node.next = null;
			this.tail = node;
		} else {
			node.next = this.head;
			this.head = node;
		}
		this.size++;
	}

	public void AddLast(int data) {
		Node node = new Node();
		node.data = data;
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		node.next = null;
		this.size++;
	}

	public void Addat(int index, int data) throws Exception {
		if (index < 0 || index > this.size) {
			throw new Exception("Index out of bound");
		}
		if (index == 0) {
			AddFirst(data);
		} else if (index == this.size) {
			AddLast(data);
		} else {
			Node node = new Node();
			node.data = data;
			Node getnode = GetNodeAt(index - 1);
			Node temp = getnode.next;
			getnode.next = node;
			node.next = temp;
			this.size++;
		}
	}

	// RemoveFunctions------------------------------------------------------------------------------------------------

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Null Point Exception");
		}

		int rv = this.head.data;
		this.head = this.head.next;
		if (this.size == 1) {
			this.tail = null;
		}

		this.size--;
		return rv;
	}

	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Null Point Exception");
		}
		int rv = this.tail.data;
		Node remove = GetNodeAt(this.size - 2);
		this.tail = remove;
		remove.next = null;
		this.size--;
		return rv;
	}

	public int removeAt(int index) throws Exception {
		if (index < 0 && index > this.size) {
			throw new Exception("index out of bound");
		} else if (this.size == 0) {
			throw new Exception("Null Point Exception");
		}
		if (index == 0) {
			return removeFirst();
		} else if (index == this.size) {
			return removeLast();
		} else {
			Node remove = GetNodeAt(index - 1);
			int rv = remove.next.data;
			remove.next = remove.next.next;
			this.size--;
			return rv;
		}
	}

	// GetFunctions----------------------------------------------------------------------------------------------------

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Null Point Exception");
		}

		return this.head.data;
	}

	public int GetLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Null Point Exception");
		}

		return this.tail.data;
	}

	public int GetAt(int index) throws Exception {
		if (index < 0 && index > this.size) {
			throw new Exception("index out of bound");
		} else if (this.size == 0) {
			throw new Exception("Null Point Exception");
		}

		if (index == 0) {
			return getFirst();
		} else if (index == this.size) {
			return GetLast();
		} else {
			Node temp = GetNodeAt(index);
			return temp.data;
		}

	}

	//Find_Length_of_a_LinkedList_(Iterative_and_Recursive)

	public int lengthItr() {

		Node ncount = this.head;
		int count = 0;
		while (ncount != null) {
			count++;
			ncount = ncount.next;
		}

		return count;
	}

	public int lengthRec() {
		return lengthRec(this.head);
	}

	private int lengthRec(Node ncount) {
		if (ncount == null) {
			return 0;
		}

		return 1 + lengthRec(ncount.next);
	}

	//Search_an_element_in_a_LinkedList_(Iterative_and_Recursive)

	public boolean SearchIre(int data) {
		Node ncount = this.head;
		for (int i = 0; i < this.size; i++) {
			if (ncount.data == data) {
				return true;
			}
			ncount = ncount.next;
		}
		return false;
	}

	public boolean SearchRec(int data) {
		return SearchRec(data, this.head);
	}

	private boolean SearchRec(int data, Node ncount) {
		if (ncount == null) {
			return false;
		}

		if (ncount.data == data) {
			return true;
		}
		return SearchRec(data, ncount.next);

	}

	// Reverse_of_and_Display------------------------------------------------------------------------------------------

	private class HeapMover {
		private Node node;
	}

	private void swap(Node data2, Node data1) {
		int temp = data2.data;
		data2.data = data1.data;
		data1.data = temp;
	}

	public void reverseDataRec() {
		HeapMover hp = new HeapMover();
		hp.node = this.head;
		reverseDataRec(hp, this.head, 1);
	}

	private void reverseDataRec(HeapMover hp, Node right, int floor) {
		if (right == null) {
			return;
		}
		reverseDataRec(hp, right.next, floor + 1);
		if (floor > (this.size) / 2) {
			swap(hp.node, right);
			hp.node = hp.node.next;
		}
	}

	public void reverseDataIrr() throws Exception {

		int left = 0;
		int right = this.size - 1;
		while (left <= right) {
			Node ln = GetNodeAt(left);
			Node rn = GetNodeAt(right);
			swap(ln, rn);
			left++;
			right--;
		}

	}

	public void diplayReverse() {
		displayReverse(this.head);
	}

	private void displayReverse(Node left) {
		if (left == null) {
			return;
		}

		displayReverse(left.next);
		System.out.print(left.data + ",");

	}

	// ReversePointer_and_Display--------------------------------------------------------------------------------------------

	//Reverse_a_list.
	public void reversePointerIrr() {
		Node prev = this.head;
		Node curr = prev.next;
		while (curr != null) {
			Node forw = curr.next;
			curr.next = prev;
			prev = curr;
			curr = forw;
		}
		this.head.next = null;
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

	}

	public void reversePointerIrrBtr() throws Exception {
		LinkedList tl = new LinkedList(); // TemperoryList
		while (this.size != 0) {
			tl.AddFirst(this.removeFirst());
		}

		this.head = tl.head;
		this.tail = tl.tail;
		this.size = tl.size;
		tl.Clear();

	}

	public void reversePointerRec() {
		reversePointerRec(this.head, this.head.next);
		this.head.next = null;
		Node n = this.tail;
		this.tail = this.head;
		this.head = n;
	}

	private void reversePointerRec(Node prev, Node curr) {
		if (curr == null) {
			return;
		}

		reversePointerRec(curr, curr.next);
		curr.next = prev;

	}

	// palindrome_and_Fold_OfLinkedList--------------------------------------------------------------------------------------

	public void palindrome() {
		HeapMover hp = new HeapMover();
		hp.node = this.head;
		palindrome(hp, this.head, 1);

	}

	private boolean palindrome(HeapMover hp, Node right, int floor) {
		if (right == null) {
			return true;
		}

		boolean result = palindrome(hp, right.next, floor + 1);
		if (floor >= this.size / 2) {
			if (result == true) {
				if (hp.node.data != right.data) {
					return false;
				}
			}
		}
		return result;

	}

	public void fold() {
		HeapMover hp = new HeapMover();
		hp.node = this.head;
		fold(hp, this.head, 0);
	}

	private void fold(HeapMover hp, Node right, int floor) {
		if (right == null) {
			return;
		}

		fold(hp, right.next, floor + 1);
		if (floor > this.size / 2) {
			Node temp = hp.node.next;
			hp.node.next = right;
			right.next = temp;
			hp.node = temp;
		} else if (floor == this.size) {
			this.tail = right;
			right.next = null;
		}

	}

	// Kth_Node,element,ReverseInKthMultiple_and_midNode_and_element---------------------------------------------------------

	public int midElement() {
		return midNode().data;
	}

	private Node midNode() {
		Node curr = this.head;
		Node prev = this.head;
		while (curr.next != null && curr.next.next != null) {
			curr = curr.next.next;
			prev = prev.next;
		}

		return prev;

	}

	public int KthElement(int k) {
		return KthNode(k).data;
	}

	private Node KthNode(int k) {
		int count = 0;
		Node slow = this.head;
		Node fast = this.head;
		while (count < k) {
			fast = fast.next;
			count++;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;

	}

	public void reverseInKthMultiple(int k) throws Exception {
		LinkedList curr = null, prev = null;
		if (k == 0) {
			return;
		}

		while (this.size != 0) {
			curr = new LinkedList();
			int count = 0;
			while (count < k) {
				curr.AddFirst(this.removeFirst());
				count++;
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}
		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
		prev.Clear();
	}

	// All_type_of_Sorting-------------------------------------------------------------------------------------------------------

	public LinkedList MergeTwoList(LinkedList other) throws Exception {
		LinkedList nl = new LinkedList();
		int count = 0;
		Node point1 = this.head;
		Node point2 = other.head;
		while (point1 != null && point2 != null) {
			if (point1.data > point2.data) {
				nl.AddFirst(this.removeFirst());
				point1 = point1.next;
			} else {
				nl.AddFirst(other.removeFirst());
				point2 = point2.next;
			}
		}

		while (point1 != null) {
			nl.AddFirst(this.removeFirst());
			point1 = point1.next;
		}

		while (point2 != null) {
			nl.AddFirst(other.removeFirst());
			point2 = point2.next;
		}

		return nl;
	}

	private LinkedList MergeSortInner() throws Exception {
		if (this.size == 1) {
			return this; // LinkedList_at_that_point_is_represented_by_this.
		}

		Node midnode = midNode();
		Node nnam = midnode.next; // Next_Node_after_mid.

		LinkedList fhalf = new LinkedList();
		fhalf.head = this.head;
		fhalf.tail = midnode;
		midnode.next = null;
		fhalf.size = (this.size + 1) / 2;

		LinkedList shalf = new LinkedList();
		shalf.head = nnam;
		shalf.tail = this.tail;
		shalf.size = this.size / 2;

		LinkedList fhalfsort = fhalf.MergeSortInner();
		LinkedList shalfsort = shalf.MergeSortInner();

		return fhalfsort.MergeTwoList(shalfsort);
	}

	public void BinarySortIrr() {
		Node lnfbs = null;
		Node prev = this.head;
		Node curr = prev.next;
		while (lnfbs != this.head) {
			while (curr != lnfbs) {// lnfbs=Last_node_for_binary_sort.
				if (prev.data > curr.data) {
					swap(prev, curr);
				}
				prev = curr;
				curr = curr.next;
			}
			lnfbs = prev; // always_put_lastNode_in_lnfbs.
		}
	}

	public void BinarySortBtrIrr() {
		Node lnfbs = null;
		Node prev = this.head;
		Node curr = prev.next;
		while (lnfbs != this.head) {
			boolean flag = false;
			while (curr != lnfbs) {// lnfbs=Last_node_for_binary_sort.
				if (prev.data > curr.data) {
					swap(prev, curr);
					flag = true;
				}
				prev = curr;
				curr = curr.next;
			}
			lnfbs = prev; // always_put_lastNode_in_lnfbs.
			if (flag == false) {
				return;
			}
		}
	}

	public void BinarySortRec() {
		BinarySortRec(this.head, null);
	}

	private void BinarySortRec(Node prev, Node lnfbs) {
		if (lnfbs == this.head) {
			return;
		}

		if (prev.next == lnfbs) {
			BinarySortRec(this.head, prev);
			return;
		}

		if (prev.data > prev.next.data) {
			swap(prev, prev.next);
		}

		BinarySortRec(prev.next, lnfbs);

	}

	public void selectionSortIrr() throws Exception {

		Node curr = this.head;
		while (curr.next != null) {
			Node mover = curr.next;

			while (mover != null) {
				if (curr.data > mover.data) {
					this.swap(curr, mover);
				}
				mover = mover.next;
			}
			curr = curr.next;
		}
	}

	public void selectionSortRecu() {
		selectionSortRecu(this.head, this.head.next);
	}

	private void selectionSortRecu(Node prev, Node curr) {
		if (prev.next == null) {
			return;
		}

		if (curr == null) {
			selectionSortRecu(prev.next, prev.next.next);
			return;
		}

		if (prev.data > curr.data) {
			this.swap(prev, curr);
		}

		selectionSortRecu(prev, curr.next);

	}

	// removeDuplicates_and_OddEvenArrange_in_linkList-------------------------------------------------------------------------

	public void removedupli() throws Exception {
		LinkedList wdupli = new LinkedList();
		wdupli.AddLast(this.removeFirst());
		while (this.size != 0) {
			if (wdupli.tail.data != this.head.data) {
				wdupli.AddLast(this.removeFirst());
			} else {
				this.removeFirst();
			}
		}
		clone(wdupli);
	}

	public void OddEven() throws Exception {
		LinkedList odd = new LinkedList();
		LinkedList even = new LinkedList();
		while (this.size != 0) {
			if (this.head.data % 2 != 0) {
				odd.AddLast(this.removeFirst());
			} else {
				even.AddLast(this.removeFirst());
			}
		}

		if (odd.head != null && even.head != null) {
			this.head = odd.head;
			odd.tail.next = even.head;
			this.tail = even.tail;
			this.size = odd.size + even.size;
		} else if (odd.head != null) {
			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		} else {
			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;
		}

	}

}
