package lists;


public class ArrayUnsortedList implements ListInterface {
	protected final int DEFCAP=50; // default capacity, though for the purposes of this exercise, it will rarely exceed 50
	protected FlightDataNode[] list;
	protected int numElements=0;
	protected int currentPos;

	protected boolean found;
	protected int location;

	public ArrayUnsortedList(){
		list = new FlightDataNode[DEFCAP];
	}
	public ArrayUnsortedList(FlightDataNode element){
		list = new FlightDataNode[DEFCAP];
		list[0]=element;
		numElements++;
	}
	
	protected void enlarge(){
		FlightDataNode[] larger = (FlightDataNode[]) new Object[list.length+DEFCAP];
		for (int i=0; i<numElements; i++){
			larger[i]=list[i];
		}
		list=larger;
	}

	protected void find (FlightDataNode target){
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
	public void add(FlightDataNode element) {
		if (numElements == list.length)
			enlarge();
		list[numElements]=element;
		numElements++;
	}

	@Override
	public boolean contains(FlightDataNode element) {
		find (element);
		return found;
	}

	@Override
	public boolean remove(FlightDataNode element) {
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
	public FlightDataNode get(FlightDataNode element) {
		find(element);
		if (found)
			return list[location];
		else
			return null;
	}
	public String toString()
	{
		// Might need to add in variables to note which airline it is
		String listString = "List of flights for this airline:\n";
		for (int i = 0; i < numElements; i++){
			listString = listString +(i+1)+") "+list[i].toString() + "\n";
		}	
		return listString;
	}

	public void reset()
	{
		currentPos  = 0;
	}

	public FlightDataNode getNext()
	{
		FlightDataNode next = list[currentPos];
		if (currentPos == (numElements - 1))
			currentPos = 0;
		else
			currentPos++;
		return next;
	}
}
