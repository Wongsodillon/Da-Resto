package Chef;

import Customer.Customer;
import Human.Employee;
import Mediator.Mediator;
import Waiter.Waiter;

public class Chef extends Employee {

	public int skill;
	private ChefState state;
	public Chef(String name, Mediator mediator) {
		super(name, mediator);
		this.skill = 1;
		state = new ChefIdle(this);
	}
	public ChefState getState() {
		return state;
	}
	public void setState(ChefState state) {
		this.state = state;
	}
	public int getSkill() {
		return skill;
	}
	public void setSkill(int skill) {
		this.skill = skill;
	}
	@Override
	public void doSomething() {
		state.doSomething();
	}
	public void receiveCustomer(Customer customer, Waiter waiter) {
		customer.getState().change();
		this.getState().change();
		this.getState().setCurrentCustomer(customer);
		customer.getState().setCurrentChef(this);
		this.getState().setCurrentWaiter(waiter);
		waiter.getState().setCurrentChef(this);
	}

}
