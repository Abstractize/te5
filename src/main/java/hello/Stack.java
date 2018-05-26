
public class Stack<T> {
	private Node<T> top;
	public void pop() {
		this.top = top.getNext();
	}
	public void print() {
		Node<T> aux = top;
		String string = "[";
		while(aux != null) {
			if (aux.getNext() == null) {
				string += String.valueOf(aux.getValue());
				aux = aux.getNext();
			}else {
				string += String.valueOf(aux.getValue())+ ",";
				aux = aux.getNext();
			}	
		}
		System.out.println("Stack:"+string + "]");
	}
	public void push(T value) {
		Node<T> newNode = new Node<T>(value);
		newNode.setNext(top);
		this.top = newNode;
	}
	public T peek() {
		if (top != null) {
			return this.top.getValue();
		}else {
			return null;
		}
		
	}
	public Node<T> getTop() {
		return top;
	}

	public void setTop(Node<T> top) {
		this.top = top;
	}

}
