package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked List of Elements
 * 
 * @author Sabina Shrestha
 *
 */
public class LinkedQueue <E> implements Iterable<E>{
	private Node head;
	private Node tail;
	private int size;
	
	private class Node {
		private E item;
		private Node next;
	}
	
	/**
	 * Returns the number of elements currently in the queue
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns true if the queue is empty
	 * @return
	 */
	public boolean empty() {
		return (size == 0);
	}
	
	/**
	 * Adds an element to the end of the queue.
	 * @param item
	 */
	public void enqueue(E item) {
		// Create new Node
		Node newNode = new Node();
		newNode.item = item;
		
		// Add new node at the end of the queue
		if(size != 0) {// queue has elements already
			
			tail.next = newNode;//points tail to new node
			
		} else {// queue is empty
			head = newNode;
		}
		tail = newNode;//moves tail to the new node
		size++;
		
	}
	
	/**
	 * Removes and returns the next element from the beginning of the queue.
	 * @return
	 */
	public E dequeue() {
		if (this.empty()) 
			throw new NoSuchElementException("Can't remove from an empty queue");
		
		E item = head.item;
		head = head.next;
		size--;
		if (this.empty()) 
			tail = null;
		
		return item;
	}
	
	/**
	 * Returns the element from the beginning of the queue without removing it.
	 * @return
	 */
	public E peek() {
		if (this.empty()) 
			throw new NoSuchElementException("Can't peek in an empty queue");
		
		return head.item;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new LinkedQueueIterator();
	}
	
	private class LinkedQueueIterator implements Iterator<E> {
		private Node current = head;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E temp = current.item;
			current = current.next;
			
			return temp;
		}
		
	}
	
	// = = = = = = Test Client = = = = = = //
	public static void main(String[] args) {
		LinkedQueue<Point> pointQueue = new LinkedQueue<>();
		LinkedQueue<Circle> circleQueue = new LinkedQueue<>();
		
		pointQueue.enqueue(new Point(1,1));
		pointQueue.enqueue(new Point(2,2));
		pointQueue.dequeue();
		pointQueue.enqueue(new Point(3,3));
		System.out.println("Peek: " + pointQueue.peek());
		System.out.println("Size: " + pointQueue.size);
		System.out.println();
		
		circleQueue.enqueue(new Circle(10));
		circleQueue.enqueue(new Circle(15));
		circleQueue.enqueue(new Circle(20));
		circleQueue.dequeue();
		System.out.println("Peek: " + circleQueue.peek());
		System.out.println("Size: " + circleQueue.size);
		System.out.println();
		
		for (Point p : pointQueue) {
			System.out.print(p + "..");
		}
		System.out.println();
		
		for (Circle c : circleQueue) {
			System.out.print(c + "..");
		}
	}
}
