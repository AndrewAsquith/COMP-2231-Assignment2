package com.andrewasquith.comp2231.assignment2.question3;

/**
 * 
 * Rather than implementing the whole interface per the java api the following
 * subset of the methods are used 
 * Insert - addFirst(e) offerFirst(e) addLast(e) offerLast(e)
 * Remove - removeFirst() pollFirst() removeLast() pollLast() Examine -
 * getFirst() peekFirst() getLast() peekLast() java.util.Deque throws
 * IllegalStateException so that is used here as well 
 * Front is considered the 0 index (or closest to it) 
 * while back is the highest index
 * 
 * @param <T>
 *            the type of element to be stored by the Deque
 */
public class ArrayDeque<T> {

	/**
	 * Default starting capacity of the queue
	 */
	private final static int DEFAULT_CAPACITY = 10;

	/**
	 * Default expandability of queue
	 */
	private final static boolean DEFAULT_EXPANDABILITY = false;

	/**
	 * Index of the front of the queue
	 */
	private int front;

	/**
	 * index of the back of the queue
	 */
	private int back;

	/**
	 * Array representing the queue
	 */
	private T[] queue;

	/**
	 * Boolean indicating if we can resize on full
	 */
	private boolean isExpandable;

	/**
	 * The number of elements currently in the queue
	 */
	private int count;

	/**
	 * Default constructor uses initial capacity and expandability
	 */
	public ArrayDeque() {
		this(DEFAULT_CAPACITY, DEFAULT_EXPANDABILITY);
	}

	/**
	 * Constructor uses default capacity and can specify if expandable
	 * 
	 * @param expandable
	 *            whether the queue will grow when it's full
	 */
	public ArrayDeque(boolean expandable) {
		this(DEFAULT_CAPACITY, expandable);
	}

	/**
	 * Constructor creating queue with specified capacity and default
	 * expandability
	 * 
	 * @param capacity
	 *            the capacity for the queue
	 */
	public ArrayDeque(int capacity) {
		this(capacity, DEFAULT_EXPANDABILITY);
	}

	/**
	 * Constructor accepting capacity and whether queue is expandable
	 * 
	 * @param capacity
	 *            the starting capacity for the queue
	 * @param expandable
	 *            whether the queue will resize when full
	 */
	@SuppressWarnings("unchecked")
	public ArrayDeque(int capacity, boolean expandable) {

		count = 0;
		front = -1;
		back = -1;
		isExpandable = expandable;
		queue = (T[]) (new Object[capacity]);

	}

	/**
	 * Get the current size of the queue
	 * 
	 * @return the current number of elements in the queue
	 */
	public int size() {
		return count;
	}

	/**
	 * Determine if the queue is currently empty
	 * 
	 * @return boolean indicating if queue is empty
	 */
	public boolean isEmpty() {
		return (count == 0);
	}

	/**
	 * Determine if the queue will expand when full
	 * 
	 * @return boolean indicating if queue will expand
	 */
	public boolean isExpandable() {
		return isExpandable;
	}

	/**
	 * Attempt to put an element at the front
	 * 
	 * @param element
	 *            the element to add
	 * @return boolean whether addition was successful
	 */
	public boolean offerFirst(T element) {

		// if the queue is full and we can't expand return false
		if (size() == queue.length && !isExpandable()) {
			return false;
		}

		// if the queue is full and we can expand do so
		if (size() == queue.length && isExpandable()) {
			expandCapacity();
		}

		// put the element at the front
		pushFirst(element);

		// return true indicating success
		return true;
	}

	/**
	 * Attempt to put an element at the front
	 * 
	 * @param element
	 *            the element to add
	 * @throws IllegalStateException
	 *             when queue is full
	 */
	public void addFirst(T element) throws IllegalStateException {

		// if the queue is full and can't expand throw
		if (size() == queue.length && !isExpandable()) {
			throw new IllegalStateException("queue is full");
		}

		// if the queue is full but we can expand do so
		if (size() == queue.length && isExpandable()) {
			expandCapacity();
		}

		// put the element at the front
		pushFirst(element);
	}

	/**
	 * Helper method to handle pushing an element onto the front
	 * 
	 * @param element
	 *            the element to add
	 */
	private void pushFirst(T element) {

		if (front == 0) {
			// if the front is currently 0, shift everything to make room
			shiftElementsRight();
		} else {
			// if the front isn't 0, decrement it
			front--;
		}
		// set the front to the new element
		queue[front] = element;

		// increase the counter
		count++;
	}

	public boolean offerLast(T element) {

		// if the queue is full and we can't expand return false
		if (size() == queue.length && !isExpandable()) {
			return false;
		}

		// if the queue is full and we can expand do so
		if (size() == queue.length && isExpandable()) {
			expandCapacity();
		}

		//put the element at the back of the queue
		pushLast(element);
		
		//return true on success
		return true;
	}

	/**
	 * Helper method to put an element at the back of the queu
	 * and update the appropriate internal variables
	 * @param element the element to be added
	 */
	private void pushLast(T element) {
		
		if(back == queue.length -1) {
			shiftElementsLeft();
		} else {
			//move the back pointer to new position
			back++;
		}
		
		// put the new element at the back
		queue[back] = element;
		
		//increase the counter;
		count++;
	}

	public void addLast(T element) throws IllegalStateException {

		// if the queue is full and can't expand throw
		if (size() == queue.length && !isExpandable()) {
			throw new IllegalStateException("queue is full");
		}

		// if the queue is full and we can expand do so
		if (size() == queue.length && isExpandable()) {
			expandCapacity();
		}
		
		//put the element at the back
		pushLast(element);
	}

	/**
	 * Helper method to shift the elements "right" when adding to 0 index
	 * Since call paths are private we can ensure a valid state before getting here
	 * which simplifies the implementation ( no index out of bounds should be possible)
	 */
	private void shiftElementsRight()  {
		
		for (int i = back; i>=front; i-- ) {
			queue[i+1] = queue[i]; 
			queue[i] = null;
		}

	}

	/**
	 * Helper method to shift the elements "left" when adding to back at last index
	 * Since call paths are private we can ensure a valid state before getting here
	 * which simplifies the implementation ( no index out of bounds should be possible)
	 */
	private void shiftElementsLeft()  {
		
		for (int i = front; i <= back; i++) {
			queue[i - 1] = queue[i];
			queue[i] = null;
		}

	}
	
	private void expandCapacity() {
		// TODO Auto-generated method stub
		
		//we're going to renumber the queue as we copy over if necessary
		
		//set front to 0
		
		//set back to new back

	}

	/**
	 * Returns and removes the element at the front of the queue returns null if
	 * the queue is empty
	 * 
	 * @return the element at the front of the queue
	 */
	public T pollFirst() {
		
		if (size() == 0) {
			return null;
		}

		return popFirstElement();
	}

	/**
	 * Returns and removes the element at the front of the queue
	 * 
	 * @return the element at the front of the queue
	 * @throws IllegalStateException
	 *             if queue is empty
	 */
	public T removeFirst() throws IllegalStateException {
		if (size() == 0) {
			throw new IllegalStateException("queue is empty");
		}

		return popFirstElement();
	}

	/**
	 * Removes the element at the back of the queue If the queue is empty null
	 * is returned
	 * 
	 * @return element at the back of the queue
	 */
	public T pollLast() {
		// if the queue is empty, return null
		if (size() == 0) {
			return null;
		}

		return popLastElement();
	}

	/**
	 * Removes the element from the back of the queue and returns it
	 * 
	 * @return the element from the back of the queue
	 * @throws IllegalStateException
	 *             if the queue is empty
	 */
	public T removeLast() throws IllegalStateException {

		// if the queue is empty, throw
		if (size() == 0) {
			throw new IllegalStateException("queue is empty");
		}

		return popLastElement();

	}

	/**
	 * Helper method to get the back element off the queue and update the
	 * appropriate internal variables This method assumes the error checking is
	 * handled in the caller
	 * 
	 * @return element at the back of the queue
	 */
	private T popLastElement() {

		// get the element at the back of the queue
		T temp = queue[back];

		// set the original back index to null
		queue[back] = null;

		// decrement the counter
		count--;

		if (size() == 0) {
			// queue is now empty, reset front and back
			front = -1;
			back = -1;
		} else {
			// move the back pointer
			back--;
		}

		// return the element
		return temp;
	}

	private T popFirstElement() {

		// get the element at the current front of the queue
		T temp = queue[front];

		// set the existing front to null
		// instead of shifting everything just be careful with the pointer
		queue[front] = null;

		count--;

		if (size() == 0) {
			// queue is now empty, reset front and back
			front = -1;
			back = -1;
		} else {
			// move front pointer to new front
			front++;
		}
		return temp;
	}

	/**
	 * Returns the element at the front of the queue without removing it Returns
	 * null if the queue is empty
	 * 
	 * @return reference to the element at the front of the queue
	 */
	public T peekFirst() {
		
		if (size() == 0) {
			return null;
		}

		return queue[front];
	}

	/**
	 * Returns the element at the front of the queue without removing it
	 * 
	 * @return reference to the element at the front of the queue
	 * @throws IllegalStateException
	 *             if the queue is empty
	 */
	public T getFirst() throws IllegalStateException {
		if (size() == 0) {
			throw new IllegalStateException("queue is empty");
		}

		return queue[front];
	}

	/**
	 * Returns the element at the back of the queue Returns null if the queue is
	 * empty
	 * 
	 * @return reference to the element at the back of the queue
	 */
	public T peekLast() {
		
		if (size() == 0) {
			return null;
		}

		return queue[back];
	}

	/**
	 * Returns the element at the back of the queue without removing it
	 * 
	 * @return reference to the element at the back of the queue
	 * @throws IllegalStateException
	 *             if the queue is empty
	 */
	public T getLast() throws IllegalStateException {
		if (size() == 0) {
			throw new IllegalStateException("queue is empty");
		}

		return queue[back];
	}

	public String toString() {
		return "";
	}
}