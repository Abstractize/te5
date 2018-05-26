
public class Tree {
	private Tnode<Character> root;
	
	
	public Tree(String expression) {
		Queue<Character> values = new Queue<Character>();
		Stack<Character> operations= new Stack<Character>();
		//Arranges in the queue
		System.out.println(expression.length());
		for (int i=0 ; i<expression.length();i++) {
			System.out.println("Iteracion "+i);
			if (Character.isLetterOrDigit(expression.charAt(i))) {
				values.enqueue(expression.charAt(i));
				System.out.println(expression.charAt(i)+"enqueued");
				values.print();
				operations.print();
			}else {
				if (expression.charAt(i) == ')') {
					while (operations.peek() != '(') {
						values.enqueue(operations.peek());
						operations.pop();
					}
					operations.pop();
				}else {
					operations.push(expression.charAt(i));
				}
				values.print();
				operations.print();
				System.out.println(expression.charAt(i)+"stacked");
			}
		}
		while (operations.peek() != null) {
			values.enqueue(operations.peek());
			operations.pop();
			values.print();
			operations.print();
		}
		System.out.println("finished");
		//Creates the tree

		
		
	}
	public Tnode<Character> subTree(String miniexp){
		Tnode<Character> right = new Tnode<Character>(miniexp.charAt(0));
		Tnode<Character> left = new Tnode<Character>(miniexp.charAt(2));
		Tnode<Character> root = new Tnode<Character>(miniexp.charAt(1));
		root.setRightSon(right);
		root.setLeftSon(left);
		return root;
	}
	public Tnode<Character> subTree(Tnode<Character> right,String miniexp){
		Tnode<Character> left = new Tnode<Character>(miniexp.charAt(0));
		Tnode<Character> root = new Tnode<Character>(miniexp.charAt(1));
		root.setRightSon(right);
		root.setLeftSon(left);
		return root;
	}
	//Getters and Setters
	public Tnode<Character> getRoot() {
		return root;
	}


	public void setRoot(Tnode<Character> root) {
		this.root = root;
	}
}
