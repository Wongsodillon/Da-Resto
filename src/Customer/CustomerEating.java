package Customer;

import Chef.Chef;

public class CustomerEating extends CustomerState {

	public CustomerEating(Customer customer, Chef chef) {
		super(customer);
		this.setCurrentChef(chef);
	}

	@Override
	public void doSomething() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		customer.getMediator().sendMessage(customer, "finish");
	}

	@Override
	public String displayState() {
		return String.format("%s, eating<%s>", customer.getName(), getCurrentChef().getName());
	}
	@Override
	public void change() {
		
	}

}
