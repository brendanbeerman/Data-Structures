package stackArrays;

public class demo {

	public static void main(String[] args) {
		stack s = new stack(11);
		
		s.push("Football");
		s.push("Hockey");
		s.push("Rugby");
		
		System.out.print("\n" + s.peek());
		
		System.out.print("\nIndex of Hockey: " + s.indexOf("Hockey"));
		
		System.out.print("\nSize: " + s.size());
		
		s.enumerate();
		
		System.out.print("\nPop top item: " + s.pop());
		
		s.clear();
		
		System.out.print("\nSize: " + s.size());

	}

}
