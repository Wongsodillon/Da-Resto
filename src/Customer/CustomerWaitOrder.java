package Customer;

public class CustomerWaitOrder extends CustomerState {

	public CustomerWaitOrder(Customer customer) {
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
		return String.format("%s <%d>, Order processed<%s>", customer.getName(), customer.getTolerance(), getCurrentWaiter().getName());
	}
	@Override
	public void change() {
		customer.setState(new CustomerWaitCook(customer));
	}

}
