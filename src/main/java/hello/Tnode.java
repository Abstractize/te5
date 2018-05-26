
public class Tnode<T> {
	private T value;
	private Tnode<T> rightSon;
	private Tnode<T> leftSon;
	
	public Tnode(T object){
		this.setValue(object);
		this.setLeftSon(null);
		this.setRightSon(null);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Tnode<T> getRightSon() {
		return rightSon;
	}

	public void setRightSon(Tnode<T> right) {
		this.rightSon = right;
	}

	public Tnode<T> getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(Tnode<T> left) {
		this.leftSon = left;
	}
}
