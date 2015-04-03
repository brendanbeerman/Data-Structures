public class demo {

	public static void main(String[] args) {
		stack<String> s_no_cap = new stack<String>();
		s_no_cap.push("Halifax");
		s_no_cap.push("Montreal");
		s_no_cap.push("Victoria");
		s_no_cap.push("Moncton");
		s_no_cap.push("Winnnipeg");	
		s_no_cap.push("Edmonton");
		s_no_cap.push("Antigonish");	
		
		System.out.print("\n" + s_no_cap.peek());
		
		s_no_cap.push("Banff"); // testing by pushing too many
		s_no_cap.push("Cole Habour");
		
		System.out.print("\nSize: " + s_no_cap.size()); // test size function
		
		System.out.print("\nPop: " + s_no_cap.pop()); // test pop
		
		System.out.print("\nIndex of Victoria: " + s_no_cap.indexOf("Victoria")); // test indexOf
		
		System.out.print("\nThe whole stack: ");
		s_no_cap.enumerate();
		System.out.print("\n");
		
		s_no_cap.clear();
		
		stack<Integer> s_cap = new stack<Integer>(3);
		s_cap.push(3); // testing push
		s_cap.push(2);
		
		System.out.print("\n" + s_cap.peek());
		
		s_cap.push(8); // testing by pushing too many
		s_cap.push(0);
		
		System.out.print("\n" + s_cap.size()); // test size function
		
		System.out.print("\n" + s_cap.pop()); // test pop
		
		s_cap.enumerate();
		
		s_cap.clear();
		
		System.out.print("\n" + s_cap.pop()); // test pop
	}

}
