package m1;

import java.util.Iterator;

/**
 * Queue that is implemented as a linked structure.
 * 
 * = = =   D O   N O T   C H A N G E   T H I S   C L A S S   = = = 
 *
 * @param <E> the type of the elements stored in the queue.
 */
public class LinkedQueue<E> implements Iterable<E> {
	private Node head;
	private Node tail;
	private int size;
	
	/**
	 * Node that includes an item of the specified type and a
	 * reference to the next node in the queue.
	 */
	private class Node {
		private E item;
		private Node next;
	}
	
	/**
	 * Number of elements in the queue.
	 * @return size
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Determines whether the queue is empty.
	 * @return true if the queue is empty and false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0; 
	}
	
	/**
	 * Adds an element to the queue.
	 * @param item
	 */
	public void enqueue(E item) {
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = null;
		
		Node oldTail = tail;	
		tail = newNode;

		if (isEmpty())
			head = tail;
		else
			oldTail.next = tail;
		
		size++;
	}
	
	/**
	 * Returns a string that includes the elements of the queue.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("LinkedQueue [");
		Node current = head;
		
		while(current != null) {
			sb.append(current.item).append(" ");
			current = current.next;
		}
		
		return sb.append("]").toString();
	}

	/**
	 * Iterator that iterates over the queue elements in FIFO order.
	 */
	@Override
	public Iterator<E> iterator() {
		return new LinkedQueueIterator();
	}
	
	private class LinkedQueueIterator implements Iterator<E> {
		private Node currentNode = head;

		@Override
		public boolean hasNext() {
			return (currentNode != null);
		}

		@Override
		public E next() {
			E temp = currentNode.item;
			currentNode = currentNode.next;
			return temp;
		}
		
	}

}
