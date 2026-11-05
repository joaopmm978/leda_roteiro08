package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (element != null && !isFull()) {
			top.insert(element);
		} else {
			throw new StackOverflowException();
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		T result = null;
		if (!isEmpty()) {
			result = top();
			top.removeLast();
			return result;
		} else {
			throw new StackUnderflowException();
		}
	}

	@Override
	public T top() {
		T result = null;
		if (!isEmpty()) {
			result = ((DoubleLinkedListImpl<T>) top).getLast().getData();
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}
