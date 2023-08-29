package Chef;

import Customer.Customer;
import Waiter.Waiter;

public abstract class ChefState {
	protected Customer currentCustomer = null;
	protected Chef chef;
	protected Waiter currentWaiter = null;
	public ChefState(Chef chef) {
		this.chef = chef;
	}
	public abstract void doSomething();
	public abstract void change();
	public abstract String displayState();
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public Waiter getCurrentWaiter() {
		return currentWaiter;
	}
	public void setCurrentWaiter(Waiter currentWaiter) {
		this.currentWaiter = currentWaiter;
	}

}
