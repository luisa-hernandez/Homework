package hw4;

public class Customer {
	/*
	 * store customer arrival time & id
	 */

	private int id;
	private int arrivalTime;
	private int waitTime;
	private Customer nextCustomer;

	public Customer(int id, int arrivalTime) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		nextCustomer = null;
	}

	public void setNextCustomer(Customer nextCustomer) {
		this.nextCustomer = nextCustomer;
	}

	public Customer nextCustomer() {
		return nextCustomer;
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

	public int waitTime() {
		return waitTime;
	}

}
