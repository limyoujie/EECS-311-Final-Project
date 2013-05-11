package data;
import java.util.*;
public class FlightDataNode implements Comparable<FlightDataNode>{
	private int model;
	private int capacity;
	private int booked;
	private double price;
	
	public FlightDataNode(){
		model=0;
		capacity=0;
		booked=0;
		price=0;
	}
	public FlightDataNode(int model, int capacity, int booked, double price){
		this.model=model;
		this.capacity=capacity;
		this.booked=booked;
		this.price=price;
	}
	public int compareTo(FlightDataNode n){
		if (this.price<n.price) return -1;
		else if (this.price==price) return 0;
		else return 1;
	}
	public void print(){
		System.out.println(model+" "+capacity+" "+booked+" Price: "+price);
	}
//	public static void main (String args []){
//		FlightDataNode test[] = {new FlightDataNode(2343,1235,3456,4564),new FlightDataNode(123,1237565,34345356,625),new FlightDataNode(697,123445,3456,8),new FlightDataNode(224,2345,667,4568874),new FlightDataNode(989,4564,3456,1231)};
//		List<FlightDataNode> testlist = Arrays.asList(test);
//		for (int i =0; i<5;i++){
//			testlist.get(i).print();

//		}
//		System.out.println("-----------------------");
//		Collections.sort(testlist);
//		for (int i =0; i<5;i++){
//			testlist.get(i).print();

//		}
//	}
}
