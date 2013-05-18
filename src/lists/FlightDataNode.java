package lists;
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
		System.out.println("Model: "+model+" Capacity: "+capacity+" Seats Booked: "+booked+" Price: "+price);
	}

	public String toString(){
		String combined  =  ("Model: "+model+" Capacity: "+capacity+" Seats Booked: "+booked+" Price: "+price);
		return combined;
	}

	public boolean equals(FlightDataNode n){
		return (this.price==n.price);
	}

}
