package hello;
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
		for (int i = 0; i<values.getLength();i++){
			this.add(values.peek());
			values.dequeue();
			inorderTraversal();
		}
	}

		public void add(Character value){
			if (root == null){
				root = new Tnode<Character>(value);
			}
			else{
				this.add(value, root);
			}
		}
		private void add(Character value, Tnode<Character> node){
			System.out.println(node.getValue());
			if (Character.isLetterOrDigit(value)){
				if (node.getLeftSon() == null){
					Tnode<Character> aux = new Tnode<Character>(value);
					node.setLeftSon(aux);
					System.out.println("Agregado: "+ value +", ruta finalizada");
				}else{
					add(value, node.getLeftSon());
				}
			}else{
				if (node.getRightSon() == null){
					System.out.println("Agregado: "+ value +", ruta finalizada");
					Tnode<Character> aux = new Tnode<Character>(value);
					node.setRightSon(aux);
				}else{
					add(value, node.getRightSon());
				}
			}
		}

		//Inorder
		public void inorderTraversal() {
			if(this.root == null) {
				System.out.println("The tree is empty");
			} else {
				if(this.root.getLeftSon() != null && this.root.getRightSon() != null) {
					System.out.println(this.printSubtree(root.getLeftSon()) +  ", " + Integer.toString(this.root.getValue()) + ", " + this.printSubtree(root.getRightSon()));
				} else if(this.root.getLeftSon() == null && this.root.getRightSon() != null) {
					System.out.println(Integer.toString(this.root.getValue()) + ", " + this.printSubtree(root.getRightSon()));
				} else if(this.root.getLeftSon() != null && this.root.getRightSon() == null) {
					System.out.println(this.printSubtree(root.getLeftSon()) + ", " + Integer.toString(this.root.getValue()));
				} else if(this.root.getLeftSon() != null && this.root.getRightSon() != null) {
					System.out.println(Integer.toString(this.root.getValue()));
				}
			}
		}
		//Print para un subárbol, dada la raíz
		private String printSubtree(Tnode<Character> current) {
			String data = current.getValue().toString();
			if(current.getLeftSon() != null && current.getRightSon() != null) {
				data += ", " + this.printSubtree(current.getLeftSon()) + ", " + this.printSubtree(current.getRightSon());
			} else if(current.getLeftSon() == null && current.getRightSon() != null) {
				data += ", " + this.printSubtree(current.getRightSon());
			} else if(current.getLeftSon() != null && current.getRightSon() == null) {
				data += ", " + this.printSubtree(current.getLeftSon());
			} else if(current.getLeftSon() == null && current.getRightSon() == null) {}
			return data;
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
