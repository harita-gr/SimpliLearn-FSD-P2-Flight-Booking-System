package com;

public class Flight {
	
	private String flightNo="";
	private String airline="";
	private String source="";
	private String destination="";
	private String departure="";
	private String arrival="";
	private String duration="";
	private int duration_in_min;
	private String airportName="";
	private int totalStops;	
	private int availableSeats;
	private float fare;
//	private boolean isEconomy;
//	private boolean isBusiness;
//	private float economyfare;
//	private float businessfare;
	
	//constructors
	

	
	
	public Flight(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}


	public Flight(String flightNo, String airline, String source, String destination, float fare) {
		super();
		this.flightNo = flightNo;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
	}


	public Flight(String flightNo, String airline, String source, String destination, String departure, String arrival,
		String duration, int duration_in_min, String airportName, int totalStops, int availableSeats, float fare) {
	super();
	this.flightNo = flightNo;
	this.airline = airline;
	this.source = source;
	this.destination = destination;
	this.departure = departure;
	this.arrival = arrival;
	this.duration = duration;
	this.duration_in_min = duration_in_min;
	this.airportName = airportName;
	this.totalStops = totalStops;
	this.availableSeats = availableSeats;
	this.fare = fare;
}


	//getters & setters
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public int getDuration_in_min() {
		return duration_in_min;
	}
	public void setDuration_in_min(int duration_in_min) {
		this.duration_in_min = duration_in_min;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public int getTotalStops() {
		return totalStops;
	}
	public void setTotalStops(int totalStops) {
		this.totalStops = totalStops;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}


	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", airline=" + airline + ", source=" + source + ", destination="
				+ destination + ", departure=" + departure + ", arrival=" + arrival + ", duration=" + duration
				+ ", duration_in_min=" + duration_in_min + ", airportName=" + airportName + ", totalStops=" + totalStops
				+ ", availableSeats=" + availableSeats + ", fare=" + fare + "]";
	}



	
	
	
	

}
