package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class FloydWarshall {

	public static void main(String[] args) {
		HashMap<String, HashMap<String, Integer>> graph = new HashMap<String, HashMap<String, Integer>>();

		// Vertices
		graph.put("A", new HashMap<String, Integer>());
		graph.put("B", new HashMap<String, Integer>());
		graph.put("C", new HashMap<String, Integer>());
		graph.put("D", new HashMap<String, Integer>());

		// edge
		graph.get("A").put("B", 5);
		graph.get("A").put("D", 10);
		graph.get("B").put("C", 3);
		graph.get("C").put("D", 1);

		// result------------------------------------------------------------------------------------------------

		HashMap<String, HashMap<String, FWPair>> result = new HashMap<String, HashMap<String, FWPair>>(); // source_to_destination+ke_against_pair.
		ArrayList<String> vnames = new ArrayList<String>(graph.keySet());
		for (String svname : vnames) {
			result.put(svname, new HashMap<String, FWPair>());
			for (String dvname : vnames) {
				FWPair pair = new FWPair();
				if (svname.equals(dvname)) {
					pair.psf = svname;
					pair.csf = 0;
				} else if (graph.get(svname).containsKey(dvname)) {
					pair.psf = svname + dvname;
					pair.csf = graph.get(svname).get(dvname);
				}
				pair.psf = null;
				pair.csf = Integer.MAX_VALUE;
				result.get(svname).put(dvname, pair);
			}
		}

		for (String ivname : vnames) {
			for (String svname : vnames) {
				for (String dvname : vnames) {
					if (svname.equals(dvname)) {
						continue;
					}
					FWPair s2d = result.get(svname).get(dvname);
					FWPair s2i = result.get(svname).get(ivname);
					FWPair i2d = result.get(ivname).get(dvname);
					if (s2i.psf == null && i2d.psf == null) {
						continue;
					} else if (s2i.csf + i2d.csf < s2d.csf) {
						s2d.csf = s2i.csf + i2d.csf;
						s2d.psf = s2i.psf + " => " + i2d.psf;
					}

				}
			}
		}
		
		System.out.println();

	}

	private static class FWPair {
		private String psf;
		private int csf;

		public String toString() {
			return "[" + this.psf + ":" + this.csf + "]";
		}
	}

}
