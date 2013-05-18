package lists;

public interface ListInterface{
	int size();
	void add(FlightDataNode element);
	boolean contains(FlightDataNode element);
	boolean remove (FlightDataNode element);
	FlightDataNode get(FlightDataNode element);
	String toString();
	void reset();
	FlightDataNode getNext();
}
