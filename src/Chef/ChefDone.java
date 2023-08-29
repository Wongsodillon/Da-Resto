package Chef;

import Customer.Customer;

public class ChefDone extends ChefState {

	public ChefDone(Chef chef, Customer customer) {
		super(chef);
		this.currentCustomer = customer;
	}

	@Override
	public void doSomething() {
		chef.getMediator().sendMessage(chef, "foodready");
	}

	@Override
	public void change() {
		chef.setState(new ChefIdle(chef));
	}

	@Override
	public String displayState() {
		return String.format("%s, Done<%s>", chef.getName(), currentCustomer.getName());
	}

}
