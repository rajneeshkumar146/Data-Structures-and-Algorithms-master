package LinkedList.SinglyLinkedList;

public class LinkedList_client {

	public static void main(String[] args) throws Exception {
		LinkedList ll = new LinkedList();
		ll.AddFirst(30);
		ll.AddFirst(20);
		ll.AddFirst(10);
		ll.Addat(3, 40);
		ll.Addat(4, 50);
		ll.AddLast(60);
		ll.AddLast(70);
		ll.AddLast(80);
		ll.Addat(8, 90);
		ll.AddLast(100);
		// System.out.println(ll.removeFirst());
		// System.out.println(ll.removeFirst());
		// System.out.println(ll.removeLast());
		// System.out.println(ll.removeLast());
		// System.out.println(ll.removeAt(2));
		ll.display();
		System.out.println(ll.lengthItr());
		System.out.println(ll.lengthRec());
		System.out.println(ll.SearchIre(50));
		System.out.println(ll.SearchRec(1000));
		ll.reverseDataRec();
		ll.reverseDataIrr();
		ll.display();
		ll.reversePointerIrr();
		ll.display();
		ll.reversePointerIrrBtr();
		ll.display();
		System.out.println(ll.midElement());
		


	}


}
