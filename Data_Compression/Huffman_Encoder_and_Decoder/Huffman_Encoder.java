package String.DataCompression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffManEncoderDecoder {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		HuffManEncoderDecoder();
		String encodedStr = compress("abababbb");
		String decodedStr = Depress(encodedStr);

		System.out.println(decodedStr);

	}

	// HuffManEncoderDecoder.======================================================================================

	private static HashMap<Character, String> Encoder = new HashMap<>();

	private static HashMap<String, Character> Decoder = new HashMap<>();

	private static void HuffManEncoderDecoder() {
		Encoder("aaaaaaabbbbbbbbbbbbbbbbbbbbbbbbddddddddddddddhjjjjjjjjjjjjjjdsbcjsldjdsjbcksjdbcjscjsvcjsvcsjvcsv");
	}

	private static class Node implements Comparable<Node> {
		private char ch;
		private int Freq;
		private Node left;
		private Node right;

		private Node(int freq, Node left, Node right) {
			this.Freq = freq;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node o) {
			return this.Freq - o.Freq;
		}
	}

	private static void Encoder(String str) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		HashMap<Character, Integer> freqMap = FreqMapOfString(str);

		ArrayList<Character> keys = new ArrayList<>(freqMap.keySet());
		for (Character key : keys) {

			Node node = new Node(freqMap.get(key), null, null);
			node.ch = key;
			pq.add(node);
		}

		while (pq.size() > 1) {
			Node one = pq.remove();
			Node two = pq.remove();

			int nfreq = one.Freq + two.Freq;

			Node nnode = new Node(nfreq, one, two);
			pq.add(nnode);
		}

		Node root = pq.remove();
		Traverse(root, "");
	}

	private static void Traverse(Node node, String psf) {
		if (node.left == null && node.right == null) {
			Encoder.put(node.ch, psf);
			Decoder.put(psf, node.ch);
			return;
		}

		Traverse(node.left, psf + "0");
		Traverse(node.right, psf + "1");

	}

	private static String compress(String str) {
		StringBuilder code = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (Encoder.get(str.charAt(i)) != null) {
				code.append(Encoder.get(str.charAt(i)));
			}
		}

		return code.toString();
	}

	private static String Depress(String str) {
		StringBuilder ans = new StringBuilder();
		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			prefix.append(str.charAt(i));
			if (Decoder.containsKey(prefix.toString())) {
				ans.append(Decoder.get(prefix.toString()));
				prefix = new StringBuilder();
			}
		}

		return ans.toString();

	}

	private static HashMap<Character, Integer> FreqMapOfString(String str) {
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			fmap.put(str.charAt(i), fmap.containsKey(str.charAt(i)) ? fmap.get(str.charAt(i)) + 1 : 1);
		}

		return fmap;
	}

}
