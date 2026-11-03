package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> atual = head;
		while (!atual.isNIL()) {
			size++;
			atual = atual.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> atual = head;
		while (!atual.isNIL() && atual.getData() != element) {
			atual = atual.getNext();
		}
		return atual.getData();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> atual = head;
			while (!atual.isNIL()) {
				atual = atual.getNext();
			}
			atual.setData(element);
			atual.next = new SingleLinkedListNode<>();
		}

	}

	@Override
	public void remove(T element) {
		if (element != null) {
			SingleLinkedListNode<T> atual = head;
			while (!atual.isNIL() && atual.data != element) {
				atual = atual.getNext();
			}
			if (!atual.isNIL()) {
				atual.data = atual.next.getData();
				atual.next = atual.next.next;
			}
		}

	}

	@Override
	public T[] toArray() {
		T[] out = (T[]) new Object[size()];
		SingleLinkedListNode<T> atual = head;
		int idx = 0;
		while (!atual.isNIL()) {
			out[idx++] = atual.data;
			atual = atual.getNext();
		}

		return out;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
