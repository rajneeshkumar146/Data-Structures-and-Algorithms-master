package LRU_Cache;

import java.util.HashMap;

public class LRUCache {

	class Node {
		int data;
		int key;
		Node prev;
		Node next;
	}

	static HashMap<Integer, Node> map = new HashMap<>();

	static Node head;
	static Node tail;

	private int total;
	private int maxCap;

	public LRUCache(int cap) {

		total = 0;

		this.maxCap = cap;

		head = new Node();
		head.prev = null;

		tail = new Node();
		tail.next = null;

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {

		Node node = map.get(key);

		Boolean isNull = (node == null);

		if (isNull) {

			return -1;
		}

		moveToHead(node);

		return node.data;

	}

	public void put(int key, int value) {

		Node temp = map.get(key);

		Boolean isNull = (temp == null);

		if (isNull) {

			Node node = new Node();
			node.key = key;
			node.data = value;

			map.put(key, node);

			addNode(node);

			total++;

			if (total > maxCap) {
				removeLRUEntryFromStructure();
			}
		} else {

			temp.data = value;
			moveTohead(temp);

		}
	}

	private void moveTohead(Node node) {
		removeNode(node);
		addNode(node);
	}

	private void removeLRUEntryFromStructure() {
		Node tail = popTail();

		map.remove(tail.key);

		total--;
	}

	private Node popTail() {
		Node itemBeingRemoved = tail.prev;
		removeNode(itemBeingRemoved);
		return itemBeingRemoved;
	}

	private void moveToHead(Node node) {
		removeNode(node);
		addNode(node);
	}

	private void removeNode(Node node) {

		Node myprev = node.prev;
		Node mynext = node.next;

		myprev.next = mynext;
		mynext.prev = myprev;

	}

	private void addNode(Node node) {

		node.prev = head;
		node.next = head.next;

		head.next.prev = node;

		head.next = node;

	}

}
