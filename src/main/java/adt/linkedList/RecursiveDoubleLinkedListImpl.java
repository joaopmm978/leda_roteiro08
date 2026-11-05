package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveDoubleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.data = element;
				this.next = new RecursiveDoubleLinkedListImpl<T>();
				if (this.previous == null) {
					this.previous = new RecursiveDoubleLinkedListImpl<T>();
				}
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;
				this.next.insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.data = element;
				this.next = new RecursiveDoubleLinkedListImpl<T>();
				this.previous = new RecursiveDoubleLinkedListImpl<T>();
			} else {
				RecursiveDoubleLinkedListImpl<T> novo = new RecursiveDoubleLinkedListImpl<T>(this.data,
						(RecursiveDoubleLinkedListImpl<T>) this.next,
						this);

				((RecursiveDoubleLinkedListImpl<T>) this.next).previous = novo;

				this.data = element;
				this.next = novo;
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {
			if (this.data.equals(element)) {
				if (this.previous.isEmpty() && this.next.isEmpty()) {
					this.data = null;
					this.next = null;
					this.previous = null;
				} else {
					this.data = this.next.data;
					this.next = this.next.next;
					if (this.next != null) {
						((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;
					}
				}
			} else {
				this.next.remove(element);
			}
		}

	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			if (this.next.isEmpty()) {
				this.data = null;
				this.next = null;
				this.previous = null;
			} else {
				this.data = this.next.data;
				this.next = this.next.next;
				if (this.next != null) {
					((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;
				}
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			if(this.next == null | this.next.isEmpty()){
				this.data = null;
				this.next = null;
			}
			else{
				((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
