package graph;
import data.*;

public class Graph {
	private static final int MAX_AIRPORTS = 1000;
	private int numAirports;
	private AirportData[] airports;
	private EdgeData[][] edges;
	private boolean[] marks;
	
	public Graph(){
		numAirports=0;
		airports = new AirportData[MAX_AIRPORTS];
		marks = new boolean [MAX_AIRPORTS];
		edges = new EdgeData[MAX_AIRPORTS][MAX_AIRPORTS];
	}
	
	// We are exploiting the fact that the raw data lists the airports as nodes from 0 onwards, so we will just read in the airports one by one and store them in an array with the index
	// corresponding to the name
	public void addAirport(AirportData data){
		airports[numAirports]=data;
		for (int i=0; i<numAirports; i++){
			// Note that the constructor initializes the distance to 0. If a distance pair is 0 we should treat that as a null edge
			edges[numAirports][i]=new EdgeData();
			edges[i][numAirports]=new EdgeData();
		}
		numAirports++;
	}
	
	public void addEdge(int from, int to, EdgeData data){
		// Again we use integer from and to references to refer to the airports which were stored and name in this way already
		edges[from][to]=data;
	}
	
	public EdgeData getEdge(int from, int to){
		return edges[from][to];
	}

	// We will need to implement a getToVertices function to return a queue of the vertices that are adjacent from the vertex so as to implement shortest distance
}
