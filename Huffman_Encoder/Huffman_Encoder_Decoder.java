package Huffman_Encoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman_Encoder_Decoder {

	private HashMap<Character, String> Encoder = new HashMap<>();
	private HashMap<String, Character> Decoder = new HashMap<>();

	class Node implements Comparable<Node> {
		char data;
		int freq;
		Node right;
		Node left;

		PriorityQueue<Node> pq = new PriorityQueue<>();

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.freq - o.freq;
		}
	}

	public Huffman_Encoder_Decoder(String feeder) {
		// step 1 -> feeder to fmap
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			char ch = feeder.charAt(i);
			fmap.put(ch, fmap.containsKey(ch) == false ? 1 : fmap.get(ch) + 1);
		}

		// step 2 -> fmap to pq
		PriorityQueue<Node> pq = new PriorityQueue<>();
		ArrayList<Character> keys = new ArrayList<>(fmap.keySet());
		for (Character key : keys) {
			Node node = new Node();
			node.data = key;
			node.freq = fmap.get(key);
			pq.add(node);
		}

		// while pq.size is 1, remove two, merge and put back
		while (pq.size() > 1) {
			Node one = pq.remove();
			Node two = pq.remove();

			Node merged = new Node();
			merged.freq = one.freq + two.freq;
			merged.left = one;
			merged.right = two;

			pq.add(merged);
		}

		// retrieve last node, travel it and fill encoder and decoder
		Node root = pq.remove();
		traverse(root, "");
		System.out.println(Encoder);
	}

	private void traverse(Node node, String psf) {
		if (node.left == null && node.right == null) {
			Encoder.put(node.data, psf);
			Decoder.put(psf, node.data);
			return;
		}

		traverse(node.left, psf + "0");
		traverse(node.right, psf + "1");
	}

	public String encoder(String str) {
		String code = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			code += Encoder.get(ch);
		}

		return code;
	}

	public String decode(String str) {
		String pre = "";
		String decode = "";
		for (int i = 0; i < str.length(); i++) {
			pre += str.charAt(i);
			if (Decoder.containsKey(pre)) {
				decode += Decoder.get(pre);
				pre = "";
			}
		}

		return decode;
	}

}
