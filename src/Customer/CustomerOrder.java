package Customer;

public class CustomerOrder extends CustomerState {


	public CustomerOrder(Customer customer) {
		super(customer);
	}

	@Override
	public void doSomething() {
		customer.getMediator().sendMessage(customer, "customerordering");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (customer.getState() instanceof CustomerOrder) {
			customer.reduceTolerance();
		}
	}
	@Override
	public void change() {
		customer.setState(new CustomerOrdering(customer));
	}

	@Override
	public String displayState() {
		return String.format("%s <%d>, Wait order", customer.getName(), customer.getTolerance());
	}

}
