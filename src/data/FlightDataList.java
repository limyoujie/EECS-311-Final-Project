package data;
import java.util.*;
// This class maintains a sorted list of FlightDataNode

public class FlightDataList {
	List<FlightDataNode> sortedList;
	public FlightDataList(){
		sortedList=new ArrayList<FlightDataNode>();
	}
	public void add(FlightDataNode newNode){
		sortedList.add(newNode);
		Collections.sort(sortedList);
	}
	public void print(){
		for (int i=0; i<sortedList.size(); i++){
			sortedList.get(i).print();
		}
	}
	public static void main (String args []){
		FlightDataNode test[] = {new FlightDataNode(2343,1235,3456,4564),new FlightDataNode(123,1237565,34345356,625),new FlightDataNode(697,123445,3456,8),new FlightDataNode(224,2345,667,4568874),new FlightDataNode(989,4564,3456,1231)};
		FlightDataList testlist=new FlightDataList();
		for (int i =0; i<5;i++){
			testlist.add(test[i]);
			testlist.print();
			System.out.println("-----------------------");
		}
	}
}
