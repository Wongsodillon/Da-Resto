package Customer;

public class CustomerOrdering extends CustomerState {

	public CustomerOrdering(Customer customer) {
		super(customer);
	}
	@Override
	public void change() {
		customer.setState(new CustomerWaitOrder(customer));
	}
	@Override
	public void doSomething() {
		
	}
	@Override
	public String displayState() {
		return String.format("%s <%d>, Order<%s>", customer.getName(), customer.getTolerance(), getCurrentWaiter().getName());
	}

}
