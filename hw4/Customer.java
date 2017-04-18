package hw4;

public class Customer {
	/*
	 * store customer arrival time & id
	 */

	private int id;
	private int arrivalTime;
	private int waitTime;
//	private Customer next;

	public Customer(int id, int arrivalTime, Customer next) {
		this.id = id;
		this.arrivalTime = arrivalTime;
//		this.next = next;
	}

	public int id() {
		return id;
	}

	public int arrivalTime() {
		return arrivalTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	public int waitTime(){
		return waitTime;
	}
	
}
