package Special_DS_O1;

public class Special_DS_client {

	public static void main(String[] args) {

		Special_DS ds = new Special_DS();

		ds.insert(10);
		ds.insert(20);
		ds.insert(30);
		ds.insert(40);
		System.out.println(ds.search(30));
		ds.delete(20);
		ds.insert(50);
		System.out.println(ds.search(50));
		System.out.println(ds.getRandom());
	}

}
