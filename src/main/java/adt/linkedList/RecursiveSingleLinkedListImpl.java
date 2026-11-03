package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public int size() {
		int result = 0;
		if(!isEmpty()){
			result += 1 + next.size();
		}
		return result;
	}

	@Override
	public T search(T element) {
		T result = null;
		if(!isEmpty()){
			if(data.equals(element)){
				result = element;
			}
			else{
				result = next.search(element);
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()){
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<>();
		}
		else{
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()){
			if(data.equals(element)){
				this.data = this.next.data;
				this.next = this.next.next;
			}
			else{
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		java.util.LinkedList<T> result = new java.util.LinkedList<T>();
		nodeToArray(result, this);
		return (T[]) result.toArray();
	}

	public void nodeToArray(java.util.LinkedList<T> list, RecursiveSingleLinkedListImpl<T> node){
		if(!node.isEmpty()){
			list.add(node.data);
			node.nodeToArray(list, node.next);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
