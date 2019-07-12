package Stack;

public class Dynamic_Stack_Client {

	public static void main(String[] args) {

		Stack_Using_Queue_POP_TOP_EFFICENT s = new Stack_Using_Queue_POP_TOP_EFFICENT(5);

		s.push(10);

		s.display();

		s.push(20);

		s.display();

		s.push(30);

		s.display();

		s.push(40);

		s.display();

		s.push(50);

		s.display();

		s.push(60);

		s.display();

		s.pop();
		s.pop();
		s.pop();
		s.pop();

		s.pop();
		s.pop();

	}

}
