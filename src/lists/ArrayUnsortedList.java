package lists;

public class ArrayUnsortedList<T> implements ListInterface<T> {
	protected final int DEFCAP=50; // default capacity, though for the purposes of this exercise, it will rarely exceed 50
	protected T[] list;
	protected int numElements=0;
	protected int currentPos;

	protected boolean found;
	protected int location;

	public ArrayUnsortedList(){
		list = (T[]) new Object[DEFCAP];
	}
	// We do not have a constructor that takes in arguments, initializing the default should be big enough

	protected void enlarge(){
		T[] larger = (T[]) new Object[list.length+DEFCAP];
		for (int i=0; i<numElements; i++){
			larger[i]=list[i];
		}
		list=larger;
	}

	protected void find (T target){
		// We might have to implement a binary search to improve efficiency, but each list will not be that long anyway
		location =0 ; 
		found = false;

		while(location<numElements){
			if (list[location].equals(target)){
				found = true;
				return;
			}
			else
				location ++;
		}
	}

	public int size() {
		return numElements;
	}

	@Override
	public void add(T element) {
		if (numElements == list.length)
			enlarge();
		list[numElements]=element;
		numElements++;
	}

	@Override
	public boolean contains(T element) {
		find (element);
		return found;
	}

	@Override
	public boolean remove(T element) {
		find(element);
		if (found){
			// Simply take the last element and replace with the location we want to remove
			list[location]=list[numElements-1];
			list[numElements - 1] =null;
			numElements--;
		}
		return found;
	}

	@Override
	public T get(T element) {
		find(element);
		if (found)
			return list[location];
		else
			return null;
	}
	  public String toString()
	  {
	    String listString = "List:\n";
	    for (int i = 0; i < numElements; i++)
	      listString = listString + "  " + list[i] + "\n";
	    return listString;
	  }

	  public void reset()
	  {
	    currentPos  = 0;
	  }

	  public T getNext()
	  {
	    T next = list[currentPos];
	    if (currentPos == (numElements - 1))
	      currentPos = 0;
	    else
	      currentPos++;
	    return next;
	  }
}
