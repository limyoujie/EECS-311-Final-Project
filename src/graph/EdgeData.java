package graph;
import java.io.*;
import lists.*;
import java.util.HashMap;
import java.util.Map;

import lists.FlightDataNode;

public class EdgeData {
	private int distance;
	private HashMap<String, FlightDataList> flights;
//	private int isEmpty;
	public EdgeData(){
//		isEmpty=0;
		distance=0;
		flights = new HashMap<String, FlightDataList>();
	}
	public void addFlight(int distanceInput, String airlineName, int modelInput, int capacityInput, int bookedInput, int priceInput){
		distance=distanceInput;
		FlightDataNode toAdd = new FlightDataNode(modelInput, capacityInput, bookedInput, priceInput);
		// Now we need to check if the airline exists in the flight list. Two cases: If airline exists, then we just need to add the FlightDataNode, else we add in a Key-Pair of Airline name-FlightDataList
		if (flights.get(airlineName)!=null){
			// remember that the addNode allows us to maintain a sorted list of flights according to price
			flights.get(airlineName).add(toAdd);
		}else{
			FlightDataList newList = new FlightDataList(toAdd);
			flights.put(airlineName, newList);
		}
	}
	
	public void printEdge(){
		System.out.println("The distance between is: "+distance);
		// Loops through every item in the hash map (list of airlines) 
		for (Map.Entry<String, FlightDataList> entry : this.flights.entrySet()){
			String key = entry.getKey();
			FlightDataList value = entry.getValue();
			System.out.println("The airline name is: " + key);
			System.out.println("The flights and prices for this airline are: ");
			System.out.println(value.toString());
		}
	}
	
	
	public static void main(String[] args){
		String line = null;
		EdgeData test = new EdgeData();
		try{
			FileReader fileReader= new FileReader("fakedata.csv");
			BufferedReader bufferedReader= new BufferedReader(fileReader);
			while((line=bufferedReader.readLine())!=null){
				String[] data = line.split(",");
//				System.out.println(Arrays.toString(data));
				test.addFlight(1000, data[0], Integer.valueOf(data[1]), Integer.valueOf(data[2]), Integer.valueOf(data[3]), Integer.valueOf(data[4]));
			}
		}
		catch(FileNotFoundException ex){
			System.out.println(
					"Unable to open file");	
		}
		catch(IOException ex){
			System.out.println("Error reading file");
		}
		
		test.printEdge();
		
	}
}
