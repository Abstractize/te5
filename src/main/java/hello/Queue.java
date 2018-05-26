
public class Queue<Type> {
	private Node<Type> head;
	private int length;
	public void empty() {
		head=null;
	}
	public void print() {
		Node<Type> aux = head;
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
		System.out.println("Queue:"+string + "]");
	}
	public void enqueue(Type object) {
		Node<Type> aux = new Node<Type>(object);
		if (head == null) {
			head=aux;
		}else {
			Node<Type> current=head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(aux);
		}
		length++;
	}
	public void dequeue() {
		if (head != null){
			head=head.getNext();
		}
		length--;
	}
	public Type peek() {
		return head.getValue();
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
