package Customer;

public class CustomerWaitCook extends CustomerState {

	public CustomerWaitCook(Customer customer) {
		super(customer);
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
		return String.format("%s <%d>, Wait food to cook<%s>", customer.getName(), customer.getTolerance(), getCurrentChef().getName());
	}

	@Override
	public void change() {
		customer.setState(new CustomerWaitFood(customer, getCurrentChef()));
	}

}
