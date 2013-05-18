package lists;

public class FlightDataList extends ArrayUnsortedList 
implements ListInterface 
{
	public FlightDataList(){
		super();
	}
	public FlightDataList(FlightDataNode newNode){
		super(newNode);
	}
	public void add(FlightDataNode element){
		FlightDataNode listElement;
		int location =0;
		if (numElements==list.length)
			enlarge();
		// Find out which location we should insert the new element
		while (location < numElements){
			listElement = list[location];
			if (listElement.compareTo(element)<0)
				location++;
			else
				break;
		}
		// After finding the location, we move everything back by one and then insert the new element
		for (int index=numElements; index > location ; index--)
			list[index]=list[index-1];
		list[location] = element;
		numElements++;
	}
	
	public boolean remove(FlightDataNode element){
		find(element);
		// Find out which location the element is, move everything back by one and then remove the last element in the array
		if (found){
			for (int i=location; i<=numElements-2;i++)
				list[i]=list[i+1];
			list[numElements=1]=null;
			numElements--;
		}
		return found;
	}
	
//	public static void main (String args []){
//		FlightDataNode test[] = {new FlightDataNode(2343,1235,3456,4564),new FlightDataNode(123,1237565,34345356,625),new FlightDataNode(697,123445,3456,8),new FlightDataNode(224,2345,667,4568874),new FlightDataNode(989,4564,3456,1231)};
//		FlightDataList testlist=new FlightDataList();
//		for (int i =0; i<5;i++){
//			testlist.add(test[i]);
//				System.out.println("-----------------------");
//		}
//		String output = testlist.toString();
//		System.out.println(output);
//	}
}
