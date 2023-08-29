package Customer;

import Chef.Chef;
import Waiter.Waiter;

public abstract class CustomerState {
	protected Customer customer;
	private Chef currentChef;
	private Waiter currentWaiter;
	public Chef getCurrentChef() {
		return currentChef;
	}
	public void setCurrentChef(Chef currentChef) {
		this.currentChef = currentChef;
	}
	public Waiter getCurrentWaiter() {
		return currentWaiter;
	}
	public void setCurrentWaiter(Waiter currentWaiter) {
		this.currentWaiter = currentWaiter;
	}
	public CustomerState(Customer customer) {
		this.customer = customer;
	}
	public abstract void doSomething();
	public abstract void change();
	public abstract String displayState();
}
