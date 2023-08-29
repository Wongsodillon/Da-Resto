package Customer;

import Chef.Chef;

public class CustomerWaitFood extends CustomerState {

	public CustomerWaitFood(Customer customer, Chef chef) {
		super(customer);
		this.setCurrentChef(chef);
	}

	@Override
	public void doSomething() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		customer.reduceTolerance();
	}

	@Override
	public String displayState() {
		return String.format("%s <%d>, Wait food to serve<%s>", customer.getName(), customer.getTolerance(), getCurrentChef().getName());
	}

	@Override
	public void change() {
		customer.setState(new CustomerEating(customer, getCurrentChef()));
	}

}
