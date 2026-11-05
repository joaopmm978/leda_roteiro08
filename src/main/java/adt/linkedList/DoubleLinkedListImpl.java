package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) this.head;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> novo = new DoubleLinkedListNode<T>(
					element, new DoubleLinkedListNode<T>(), last);
			if (isEmpty()) {
				this.head = novo;
			} else {
				last.setNext(novo);
			}
			this.last = novo;
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> novo = new DoubleLinkedListNode<T>(element,
					(DoubleLinkedListNode<T>) this.head, new DoubleLinkedListNode<T>());

			((DoubleLinkedListNode<T>) this.head).setPrevious(novo);

			if (this.head.isNIL()) {
				this.last = novo;
			}

			this.head = novo;
		}

	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {
			if (this.head.getData().equals(element)) {
				removeFirst();
			} 
			else{
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
				while (!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}

				if (!aux.isNIL()) {
					DoubleLinkedListNode<T> anterior = aux.getPrevious();
					DoubleLinkedListNode<T> proximo = (DoubleLinkedListNode<T>) aux.getNext();

					anterior.setNext(proximo);
					proximo.setPrevious(anterior);

					if (aux == this.last) {
						this.last = anterior;
					}
				}
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			this.head = this.head.getNext();
			if (head.isNIL()) {
				last = (DoubleLinkedListNode<T>) this.head;
			} else {
				((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<T>());
			}
		}

	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			this.last = this.last.getPrevious();
			if (this.last.isNIL()) {
				this.head = this.last;
			} else {
				this.last.next = new DoubleLinkedListNode<T>();
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
