package LinkedList;

public class LinkedList_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList ll = new LinkedList();

		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		ll.addLast(60);
		ll.addLast(70);
		ll.addLast(80);

		ll.display();

		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addFirst(5);
		ll.addFirst(6);

		System.out.println();

		ll.display();

//		ll.KreverseList(3);

		ll.display();

		ll.addat(100, 5);

		System.out.println();

		ll.display();

		System.out.println();

		System.out.println(ll.getFirst());

		System.out.println(ll.getLast());

		System.out.println(ll.getNodeAt(5));

		System.out.println(ll.removeFirst());

		ll.display();

		System.out.println();

		System.out.println(ll.removelast());

		ll.display();

		System.out.println();

		System.out.println(ll.remove(5));

		ll.display();

		System.out.println();

		// ll.reversePrint(); NULLPOINTER

		// ll.reversePrint_RC();

		System.out.println();

		ll.reverseData_RC();

		System.out.println();

		ll.display();

		System.out.println();

		System.out.print(ll.isPalindrome());

		System.out.println();

		ll.removelast();
		ll.removelast();
		ll.removelast();
		ll.removelast();
		ll.removelast();

		ll.removelast();
		ll.removelast();
		ll.removelast();
		ll.removelast();
		ll.removelast();

		ll.removelast();

		ll.addFirst(60);
		ll.addFirst(50);
		ll.addFirst(40);
		ll.addFirst(30);
		ll.addFirst(20);
		ll.addFirst(10);

		ll.display();

		System.out.println();

		ll.addLast(80);

		ll.display();

		System.out.println();

		System.out.println(ll.mid());

		System.out.println(ll.kthfromlast(5));

		LinkedList l1 = new LinkedList();

		l1.addLast(10);
		l1.addLast(20);
		l1.addLast(30);
		l1.addLast(40);
		l1.addLast(50);
		l1.addLast(60);
		l1.addLast(70);

		LinkedList l2 = new LinkedList();

		l2.addLast(11);
		l2.addLast(15);
		l2.addLast(19);
		l2.addLast(31);
		l2.addLast(41);
		l2.addLast(61);
		l2.addLast(81);

		LinkedList l3 = LinkedList.MergeList(l1, l2);

		l3.display();

		LinkedList l4 = new LinkedList();

		l4.addLast(55);
		l4.addLast(5);
		l4.addLast(15);
		l4.addLast(56);
		l4.addLast(4);
		l4.addLast(65);
		l4.addLast(85);
		l4.addLast(75);
		l4.addLast(11);
		l4.addLast(23);
		l4.addLast(79);
		l4.addLast(78);

		LinkedList l5 = LinkedList.MergeSort(l4);

		System.out.println();
		System.out.println();

		l4.display();

		System.out.println();
		System.out.println();

		l5.display();

		System.out.println();

		System.out.println();

		ll.display();

		System.out.println();

		// ll.zigzag();

		System.out.println();

		ll.display();

		System.out.println();

		System.out.println();

		ll.target(50);

		System.out.println();
	}
}
