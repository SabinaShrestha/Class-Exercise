package queue;

import java.util.Iterator;

/**
 * Linked list of Points
 * @author sabinashrestha
 *
 */
public class LinkedQueue implements Iterator<E> {
	private Node head;
	private Node tail;
	private int size;
	
	private class Node {
		private E item;
		private Node next;
	}
	
	public void enqueue(E item) {
		/*
		 * make a new node with parameter value
		 * add new node at tail
		 */
		
		//create new node
		Node newNode = new Node();
		newNode.item = item;
		
		if(size != 0) { //queue has elements already
			tail.next = newNode;     
		}
		else { //queue is empty
			head = newNode;
		}
		tail = newNode;
		size++;
	}
	
	@Override
	public Iterator<E> iterator(){
		return new PointQueueIterator();
	}
	
	private class PointQueueIterator <E> implements Iterator<E>{
		
	}
	//= = = = = = = = Test Client = = = = = = = = = 
	
	public static void main(String[] args) {
		LinkedQueue list = new LinkedQueue();
		list.enqueue(new E(1,1));
		list.enqueue(new E(2,2));
	}
}
