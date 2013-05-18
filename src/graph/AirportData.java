package graph;

public class AirportData {
	private String name;
	private String city;
	private String state;
	
	public AirportData(){
		name=null;
		city=null;
		state=null;
	}
	
	public AirportData(String name, String city, String state){
		this.name=name;
		this.city=city;
		this.state=state;
	}
	public void print(){
		System.out.println(name +" "+city+" "+state);
	}
	public void setName(String name){
		this.name=name;
	}
	public void setCity(String city){
		this.city=city;
	}
	public void setState(String state){
		this.state=state;
	}
	public String getName(String name){
		return name;
	}
	public String getCity(String city){
		return city;
	}
	public String getState(String state){
		return state;
	}
	
//	public static void main (String arg[]){
//		AirportData test = new AirportData("ORD", "Chicago", "IL");
//		AirportData test2 = new AirportData();
//		test2.setName("JFK");
//		test2.setCity("NYC");
//		test2.setState("NY");
//		test.print();
//		test2.print();
//	}
}

