package Trie;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {

	public class Node {

		Character data;
		HashMap<Character, Node> children = new HashMap<>();
		boolean eow;

		public String toString() {
			return eow ? data + "*" : data + "";
		}
	}

	Node root;
	int words;
	int nodes;

	public Trie() {

		root = new Node();

		root.data = '$';

	}

	public boolean searchword(String word) {

		return searchword(root, word);

	}

	public boolean searchword(Node node, String word) {

		if (word.length() == 0) {
			return node.eow;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);

		if (node.children.get(ch) == null) {
			return false;
		} else {
			return searchword(node.children.get(ch), ros);
		}
	}

	public void addWord(String word) {

		if (!searchword(word)) {

			addWord(root, word);
		}
	}

	private void addWord(Node node, String word) {

		if (word.length() == 0) {

			node.eow = true;
			words++;
			return;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);

		if (node.children.get(ch) == null) {

			Node temp = new Node();
			temp.data = ch;
			node.children.put(ch, temp);
			nodes++;

			addWord(temp, ros);
		} else {
			addWord(node.children.get(ch), ros);
		}

	}

	public void removeWord(String word) {

		if (searchword(word)) {
			removeWord(root, word);
		}

	}

	private void removeWord(Node node, String word) {

		if (word.length() == 0) {
			node.eow = false;
			/* node.children.remove(word); */
			words--;
			return;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = node.children.get(ch);

		removeWord(child, ros);

		if (child.eow != true && child.children.size() == 0) {

			node.children.remove(ch);
			words--;

		}

	}

	public void displayWords() {

		displayWords(root, new String());
	}

	private void displayWords(Node node, String word) {

		if (node.eow == true) {
			System.out.println(word + " ");
		}

		ArrayList<Character> list = new ArrayList<>(node.children.keySet());

		for (Character ch : list) {

			Node child = node.children.get(ch);

			displayWords(child, word + ch);

		}
	}

	public void displayTries() {

		displayTries(root, new String());
	}

	private void displayTries(Node node, String word) {

		System.out.println(node.data + "  { " + node.children + " }");

		for (Character ch : node.children.keySet()) {

			displayTries(node.children.get(ch), word + ch);

		}

	}
}
