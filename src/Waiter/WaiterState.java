package Waiter;

import Chef.Chef;
import Customer.Customer;

public abstract class WaiterState {
	protected Customer currentCustomer = null;
	protected Chef currentChef = null;
	protected Waiter waiter;
	public WaiterState(Waiter waiter) {
		this.waiter = waiter;
	}
	public abstract void doSomething();
	public abstract void change();
	public abstract String displayState();
	public void setServingFoodState(Customer customer, Chef chef) {
		waiter.setState(new WaiterServing(waiter, customer, chef));
	}
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	public Chef getCurrentChef() {
		return currentChef;
	}
	public void setCurrentChef(Chef currentChef) {
		this.currentChef = currentChef;
	}
	public Waiter getWaiter() {
		return waiter;
	}
	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
}
