package Waiter;

import Customer.Customer;
import Human.Employee;
import Mediator.Mediator;

public class Waiter extends Employee {

	WaiterState state;
	public Waiter(String name, Mediator mediator) {
		super(name, mediator);
		state = new WaiterIdle(this);
	}
	public void receiveCustomer(Customer customer) {
		customer.getState().change();
		this.getState().change();
		customer.getState().setCurrentWaiter(this);
		this.getState().setCurrentCustomer(customer);
	}
	public WaiterState getState() {
		return state;
	}

	public void setState(WaiterState state) {
		this.state = state;
	}

	@Override
	public void doSomething() {
		state.doSomething();
	}
	
}
