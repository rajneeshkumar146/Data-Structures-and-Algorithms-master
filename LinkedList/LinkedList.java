package LinkedList;

import java.util.HashSet;
import java.util.PriorityQueue;

public class LinkedList {
	private class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public void addLast(int data) {

		if (size == 0) {
			handlewhensize0(data);
			return;
		}

		Node node = new Node();

		node.data = data;

		tail.next = node;

		tail = node;

		size++;

	}

	public void addFirst(int data) {

		if (size == 0) {
			handlewhensize0(data);
			return;
		}

		Node node = new Node();

		node.data = data;

		node.next = head;

		head = node;

		size++;

	}

	public void addat(int val, int idx) {

		if (size == 0) {
			System.out.println("List Empty");
		}

		if (idx < 0 || idx > size) {

			System.out.println("Index Out of bound");

		} else if (idx == 0) {
			addFirst(val);
			return;
		} else if (idx == size) {
			addLast(val);
			return;
		}

		Node node = new Node();

		node = head;

		for (int i = 0; i < idx - 1; i++) {

			node = node.next;

		}

		Node mynode = new Node();

		mynode.data = val;

		Node nodenext = node.next;

		node.next = mynode;

		mynode.next = nodenext;

		size++;
	}

	private void handlewhensize0(int data) {

		Node node = new Node();

		node.data = data;

		head = tail = node;

		size++;
	}

	public int getFirst() {

		if (size == 0) {
			System.out.println("EMPTY LIST");
		}

		return head.data;
	}

	public int getLast() {
		if (size == 0) {
			System.out.println("EMPTY LIST");
		}

		return tail.data;
	}

	public Node getNodeAt(int idx) {

		if (size == 0) {

			System.out.println("LIST EMPTY");
		}

		if (idx < 0 || idx > size) {

			System.out.println("OUT Of Bound");

		}

		Node node = new Node();

		node = head;

		for (int i = 0; i < idx; i++) {

			node = node.next;

		}

		return node;

	}

	public int removeFirst() {

		if (size == 0) {

			System.out.println("LIST IS EMPTY");

		}

		if (size == 1) {

			handleremovewhensizeis1();

		}

		int data = head.data;

		head = head.next;

		size--;

		return data;

	}

	private int handleremovewhensizeis1() {

		int data = head.data;

		head = tail = null;

		return data;

	}

	public int removelast() {

		if (size == 0) {
			System.out.println("LIST OS EMPTY");
		}

		if (size == 1) {
			handleremovewhensizeis1();
		}

		Node node = head;

		for (int i = 0; i < size - 2; i++) {
			node = node.next;

		}

		int data = node.next.data;

		node.next = null;

		tail = node;

		size--;

		return data;
	}

	public int remove(int idx) {

		if (size == 0) {
			System.out.println("LIST IS EMPTY");
		}

		if (size == 1) {
			handleremovewhensizeis1();
		}

		if (idx == size) {
			removelast();
		}

		Node jpre = head;

		for (int i = 1; i < idx - 1; i++) {

			jpre = jpre.next;
		}

		Node curr = jpre.next;

		Node jnext = curr.next;

		jpre.next = curr.next;

		size--;

		return curr.data;
	}

	public void display() {

		Node node = head;

		for (int i = 0; i < size; i++) {

			System.out.print(node.data + " - > ");
			node = node.next;
		}
	}

	public void reversePrint() {
		if (size == 0) {
			System.out.println("List is empty");
		}

		for (int i = size; i >= 0; i--) {
			Node node = getNodeAt(i);

			System.out.print(node.data + " - > ");

		}

	}

	public void reversePrint_RC() {

		reversePrint_RC(head);
	}

	private void reversePrint_RC(Node node) {

		if (node == null) {

			return;

		}
		reversePrint_RC(node.next);

		System.out.print(node.data + " - > ");

	}

	public void reverseData() {

		int left = 0;
		int right = size - 1;

		while (left < right) {
			Node leftnode = getNodeAt(left);

			Node rightnode = getNodeAt(right);

			int temp = leftnode.data;

			leftnode.data = rightnode.data;

			rightnode.data = temp;

			left++;
			right--;

		}

	}

	public void reverseData_RC() {

		HeapMover left = new HeapMover();
		left.node = head;
		reverseData_RC(head, left, 0);
	}

	class HeapMover {
		Node node;
	}

	public void reverseData_RC(Node right, HeapMover left, int floor) {

		if (right == null) {
			return;
		}

		reverseData_RC(right.next, left, floor + 1);

		if (floor > size / 2) {

			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;

			left.node = left.node.next;
		}

	}

	Node temp;

	public void reverseData_RC_Global_Node() {

		temp = head;
		reverseData_RC_Global_Node(head, temp, 0);
	}

	public void reverseData_RC_Global_Node(Node right, Node temp, int floor) {

		if (right == null) {
			return;
		}

		reverseData_RC_Global_Node(right.next, temp, floor + 1);

		if (floor > size / 2) {

			int left = temp.data;
			temp.data = right.data;
			right.data = left;

			temp = temp.next;
		}

	}

	public void reversePointer() {

		Node prev = head;

		Node curr = head.next;

		while (curr != null) {

			Node next = curr.next;
			curr.next = prev;
			prev = curr;

			curr = next;

		}

		Node temp = head;

		head = tail;
		tail = temp;

		tail.next = null;

	}

	public void reversePointer_RC() {
		Node prev = head;
		Node curr = head.next;

		reversePointer_RC(prev, curr);

		Node temp = head;

		head = tail;
		tail = temp;

		tail.next = null;
	}

	public void reversePointer_RC(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		Node next = curr.next;

		curr.next = prev;

		prev = curr;

		curr = next;

		reversePointer_RC(prev, curr);

	}

	public void reversePointer_RC_BETTER() {

		reversePointer_RC_BETTER(head);

		Node temp = head;
		head = tail;
		tail = temp;

		tail.next = null;
	}

	public void reversePointer_RC_BETTER(Node node) {

		if (node == tail) {
			return;
		}

		reversePointer_RC_BETTER(node.next);

		node.next.next = node;

	}

	public boolean isPalindrome(Node head) {
		Node slow = head;

		Node fast = slow.next;

		while (fast != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node head1 = head;

		Node head2 = slow.next;

		slow.next = null;

		head2 = reverseList(head2);

		while (head1 != null && head2 != null) {
			if (head1.data != head2.data) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}

		return true;
	}

	private Node reverseList(Node node) {

		Node prev = null;
		Node curr = node;
		Node next = null;

		while (curr != null) {

			next = curr.next;

			curr.next = prev;
			prev = curr;
			curr = next;

		}

		System.out.println();

		node = prev;
		return node;

	}

	public boolean isPalindrome() {

		HeapMover left = new HeapMover();

		left.node = head;

		return isPalindrome(left, head, 0);

	}

	private boolean isPalindrome(HeapMover left, Node right, int ctr) {

		if (right == null) {
			return true;
		}

		boolean ans = isPalindrome(left, right.next, ctr + 1);

		if (ctr >= size / 2) {

			if (left.node.data != right.data) {
				return false;
			}
			left.node = left.node.next;

		}

		return ans;

	}

	static Node left = null;

	public boolean isPalindrome_Global() {

		left = head;

		return isPalindrome_Global(head, left, 0);
	}

	private boolean isPalindrome_Global(Node right, Node left, int ctr) {

		if (right == null) {
			return true;
		}

		boolean ans = isPalindrome_Global(right.next, left, ctr + 1);

		if (ctr >= size / 2) {

			if (left.data != right.data) {
				return false;
			}

			left = left.next;

		}
		return ans;
	}

	public void foldList() {

		HeapMover left = new HeapMover();

		left.node = head;

		foldList(head, left, 0);

		tail = left.node.next;
		tail.next = null;

	}

	public Node FoldList_itrative(Node head) {

		Node slow = head;

		Node fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node head1 = head;

		Node head2 = slow.next;

		slow.next = null;

		head2 = reverseList(head2);

		Node res = new Node();

		Node ans = res;

		while (head1 != null || head2 != null) {

			if (head1 != null) {
				ans.next = head1;
				ans = ans.next;
				head1 = head1.next;
			}

			if (head2 != null) {
				ans.next = head2;
				ans = ans.next;
				head2 = head2.next;
			}

		}

		return res.next;
	}

	private void foldList(Node right, HeapMover left, int ctr) {
		if (right == null) {

			return;

		}
		foldList(right.next, left, ctr + 1);

		if (ctr >= size / 2) {

			Node temp = left.node.next;

			left.node.next = right;

			right.next = temp;

			left.node = temp;

		}

	}

	public void unfoldList() {

		unfoldList(head, head.next);

	}

	private void unfoldList(Node curr, Node Next) {

		if (curr.next == null) {

			head = curr;
			tail = curr;

			return;

		}

		unfoldList(curr.next.next, Next.next.next);

		curr.next = head;

		tail.next = Next;

		head = curr;

		tail = Next;

	}

	public int mid() {
		Node slow = head;

		Node fast = head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;

			fast = fast.next.next;

		}

		return slow.data;

	}

	public int kthfromlast(int k) {

		Node slow = head;

		Node fast = head;

		for (int i = 0; i < k; i++) {

			fast = fast.next;

		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}

	public static LinkedList MergeList(LinkedList l1, LinkedList l2) {
		LinkedList list = new LinkedList();

		Node temp1 = l1.head;
		Node temp2 = l2.head;

		while (temp1 != null && temp2 != null) {
			if (temp1.data < temp2.data) {
				list.addLast(temp1.data);
				temp1 = temp1.next;
			} else {
				list.addLast(temp2.data);
				temp2 = temp2.next;
			}
		}

		while (temp1 != null) {
			list.addLast(temp1.data);
			temp1 = temp1.next;
		}

		while (temp2 != null) {
			list.addLast(temp2.data);
			temp2 = temp2.next;
		}

		return list;
	}

	public Node midNode() {
		Node slow = head;

		Node fast = head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;

			fast = fast.next.next;

		}

		return slow;

	}

	public static LinkedList MergeSort(LinkedList list) {

		if (list.size == 1) {
			return list;
		}

		Node middle = list.midNode();

		LinkedList l1 = new LinkedList();

		l1.head = list.head;

		l1.tail = list.midNode();

		l1.size = (list.size + 1) / 2;

		LinkedList l2 = new LinkedList();

		l2.head = list.midNode().next;

		l2.tail = list.tail;

		l2.size = list.size - l1.size;

		l1.tail.next = null;

		l1 = MergeSort(l1);

		l2 = MergeSort(l2);

		LinkedList l3 = MergeList(l1, l2);

		l1.tail.next = middle;

		return l3;

	}

	class NodeK implements Comparable<NodeK> {
		int data;
		NodeK next;

		public int compareTo(NodeK o) {
			return o.data - this.data;
		}
	}

	public LinkedList MergeKSorted(NodeK[] list) {
		PriorityQueue<NodeK> pq = new PriorityQueue<>();

		for (int i = 0; i < list.length; i++) {
			pq.add(list[i]);
		}

		LinkedList ans = new LinkedList();

		while (!pq.isEmpty()) {

			NodeK temp = pq.poll();

			if (temp.next != null) {
				pq.add(temp.next);
			}
			ans.addLast(temp.data);
		}

		return ans;
	}

	public void KreverseList(int k) {
		this.head = reverseList(head, k);
	}

	public Node reverseList(Node node, int k) {

		Node current = node;
		Node previous = null;
		Node next = null;

		int count = k;
		while (count-- > 0 && current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		if (current != null) {
			node.next = reverseList(current, k);
		}

		return previous;
	}

	public Node reverseBetween(Node head, int m, int n) {
		if (head == null) {
			return null;
		}

		Node cur = head;
		Node prev = null;

		while (m > 1) {
			prev = cur;
			cur = cur.next;
			m--;
			n--;
		}

		Node con = prev;
		Node join = cur;
		Node temp;

		while (n > 0) {
			temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
			n--;
		}

		if (con != null) {
			con.next = prev;
		} else {
			head = prev;
		}
		join.next = cur;

		return head;
	}

	private Node removeFirstNode() {
		if (size == 0) {
			System.out.println("List is empty");
			return null;
		}

		if (size == 1) {
			return handleremovalofnodewhensize1();
		}

		Node rv = head;

		head = head.next;

		rv.next = null;
		size--;

		return rv;

	}

	private Node handleremovalofnodewhensize1() {

		Node rv = head;
		head = tail = null;

		size = 0;
		return rv;

	}

	public void addfirstnode(Node node) {

		if (size == 0) {
			handleaddnodewhensize0(node);
			return;
		}

		node.next = head;
		head = node;

		size++;
	}

	private void handleaddnodewhensize0(Node node) {
		head = tail = node;

		size++;

	}

	public void addnodeLast(Node node) {

		if (size == 0) {
			handleaddnodewhensize0(node);
			return;
		}

		tail.next = node;

		tail = node;

		size++;

	}

	public void oddeven() {

		LinkedList odd = new LinkedList();

		LinkedList even = new LinkedList();

		while (size != 0) {
			if (this.head.data % 2 == 0) {
				even.addfirstnode(this.removeFirstNode());

			} else {
				odd.addfirstnode(this.removeFirstNode());
			}

		}

		if (even.size == 0) {

			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
			this.tail.next = null;

		} else if (odd.size == 0) {

			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;
			this.tail.next = null;

		} else {
			this.head = odd.head;
			odd.tail.next = even.head;
			this.tail = even.tail;
			this.tail.next = null;
			this.size = odd.size + even.size;

		}

	}

	public void zigzag() {
		if (head == null) {
			return;
		}
		Node curr = head;
		Boolean turner = true;
		while (curr.next != null) {
			if (turner) {
				// check if curr < curr.next
				if (curr.data > curr.next.data) {
					swap(curr, curr.next);
				}
			} else {
				// check if curr > curr.next
				if (curr.data < curr.next.data) {
					swap(curr, curr.next);
				}
			}
			turner = !turner;
			curr = curr.next;
		}
	}

	private void swap(Node a, Node b) {
		int t = a.data;
		a.data = b.data;
		b.data = t;
	}

	public void target(int tar) {
		Node left = head;

		target(head, left, tar);
	}

	static boolean right_flag = false;

	private void target(Node right, Node left, int tar) {

		if (right == null || left == null) {
			return;
		}

		if ((right.data + left.data) == tar) {

			System.out.println(right.data + " + " + left.data);

		}

		if (right_flag == false) {

			target(right.next, left, tar);

		}

		right_flag = true;
		target(right, left.next, tar);
	}

	public boolean targetBetter(int target) {
		return targetBetter(head, target);
	}

	private boolean targetBetter(Node node, int target) {

		Node temp = node;

		HashSet<Integer> set = new HashSet<Integer>();

		while (temp != null) {
			int val = temp.data;

			if (set.contains(target - val)) {
				return true;
			}

			set.add(val);

			temp = temp.next;
		}
		return false;
	}

	public void removeDuplicateSorted() {

		Node curr = head;

		while (curr != null) {
			Node temp = curr;

			while (temp != null && temp.data == curr.data) {
				temp = temp.next;
			}

			curr.next = temp;
			curr = curr.next;
		}
	}

	public int maxPalindrome() {
		return maxPalindrome(head);
	}

	private int maxPalindrome(Node node) {

		int res = 0;

		Node prev = null;

		Node curr = head;

		while (curr != null) {
			Node next = curr.next;

			curr.next = prev;

			res = Math.max(res, 2 * FindCommon(prev, next) + 1);

			res = Math.max(res, 2 * FindCommon(curr, next));

			prev = curr;
			curr = next;
		}

		return res;

	}

	private int FindCommon(Node a, Node b) {

		int count = 0;

		while (a != null && b != null) {

			if (a.data == b.data) {
				count++;
			} else {
				break;
			}

			a = a.next;
			b = b.next;
		}
		return count;
	}

	public void RemoveDuplicateSorted() {

		removeDuplicateSorted(head);

	}

	private void removeDuplicateSorted(Node node) {

		Node curr = head;
		Node temp = null;

		while (curr != null) {
			temp = curr;

			while (temp.next != null && curr.data == temp.data) {

				temp = temp.next;

			}

			curr.next = temp;
			curr = curr.next;
		}

	}

	public void RemoveDuplicateUnsorted() {
		RemoveDuplicateUnsorted(head);
	}

	private void RemoveDuplicateUnsorted(Node node) {

		Node curr = head;

		Node nxt = null;

		Node temp = null;

		while (curr != null && curr.next != null) {

			nxt = curr;

			while (nxt.next != null) {
				if (nxt.data == nxt.next.data) {
					// temp = nxt.next;
					nxt.next = nxt.next.next;
				} else {
					nxt = nxt.next;
				}
			}
			curr = curr.next;

		}

	}

	public void RemoveDuplicate() {
		RemoveDuplicate(head);
	}

	private void RemoveDuplicate(Node head) {

		HashSet<Integer> set = new HashSet<>();

		Node current = head;
		Node prev = null;
		while (current != null) {
			int curval = current.data;

			if (set.contains(curval)) {
				prev.next = current.next;
			} else {
				set.add(curval);
				prev = current;
			}
			current = current.next;
		}

	}

	public LinkedList addLinkedLists(Node one, Node two) {
		LinkedList list = new LinkedList();
		list.head = addList(one, two);
		return list;
	}

	private Node addList(Node n1, Node n2) {
		n1 = reverseList(n1);
		n2 = reverseList(n2);

		Node head = null;
		Node prev = null;
		int sum = 0;
		int carry = 0;

		while (n1 != null || n2 != null) {

			int ld, rd = 0;

			if (n1 != null) {
				ld = n1.data;
			} else {
				ld = 0;
			}

			if (n2 != null) {
				rd = n2.data;
			} else {
				rd = 0;
			}

			sum = ld + rd + carry;
			carry = sum / 10;
			sum = sum % 10;

			if (head == null) {
				head = new Node();
				head.data = sum;
				prev = head;
			} else {
				Node n = new Node();
				n.data = sum;
				prev.next = n;
				prev = prev.next;

			}
			if (n1 != null) {
				n1 = n1.next;
			}
			if (n2 != null) {
				n2 = n2.next;
			}
		}
		if (carry != 0) {
			Node n3 = new Node();
			n3.data = carry;
			prev.next = n3;
		}

		head = reverseList(head);
		return head;
	}

	public void removeTheLoop(Node head) {

		if (head.next == head) {
			head.next = null;
		}
		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast.next == null || fast.next.next == null) {
				return;
			}
			if (slow == fast) {
				break;
			}

		}
		slow = head;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}

		fast.next = null;
	}

	public long multiplyTwoLists(Node one, Node two) {

		long first = 0;
		long mod = 1000000007;
		long sec = 0;

		while (one != null) {
			first = (first * 10 + one.data) % mod;
			one = one.next;
		}

		while (two != null) {
			sec = (sec * 10 + two.data) % mod;
			two = two.next;
		}

		return (first * sec) % mod;

	}

	private Node plusOne() {
		return plusOne(head);
	}

	public Node plusOne(Node n) {

		n = reverseList(n);

		Node temp = n;

		int carry = 1;
		Integer sum = 0;

		while (temp != null) {
			sum = temp.data + carry;
			carry = sum >= 10 ? 1 : 0;
			temp.data = sum % 10;

			temp = temp.next;
		}

		n = reverseList(n);

		if (carry != 0) {
			Node newcarryhead = new Node();
			newcarryhead.data = carry;
			newcarryhead.next = n;
			n = newcarryhead;
		}

		return n;

	}

	public Node mergeKList(Node[] arr, int k) {

		int i = 1;
		Node head = arr[0];

		while (i < arr.length) {
			head = mergeList(head, arr[i]);
			i++;
		}

		return head;
	}

	public Node mergeList(Node a, Node b) {
		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		Node small;
		if (a.data < b.data) {
			small = a;
			small.next = mergeList(a.next, b);
		} else {
			small = b;
			small.next = mergeList(a, b.next);
		}
		return small;
	}

	public Node mergeTwoLists(Node l1, Node l2) {

		Node header = new Node();
		Node tail = header;
		Node temp;

		while (l1 != null && l2 != null) {
			if (l2.data > l1.data) {
				temp = l1;
				l1 = l1.next;
			} else {
				temp = l2;
				l2 = l2.next;
			}

			tail.next = temp;
			tail = temp;
		}
		tail.next = l1 != null ? l1 : l2;

		return header.next;
	}
}
