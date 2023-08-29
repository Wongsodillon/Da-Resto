package Waiter;

import Chef.Chef;
import Customer.Customer;

public class WaiterServing extends WaiterState {

	public WaiterServing(Waiter waiter, Customer customer, Chef chef) {
		super(waiter);
		this.currentCustomer = customer;
		if (this.currentCustomer == null) {
			throw new IllegalStateException("Null Customer");
		}
		this.currentChef = chef;
	}

	@Override
	public void doSomething() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waiter.getMediator().sendMessage(waiter, "foodotw");
	}

	@Override
	public void change() {
		waiter.setState(new WaiterIdle(waiter));
//		System.out.println("ChangingChangingChangingChangingChanging");
//		System.out.println(waiter == null);
//		System.out.println(waiter.getState());
	}

	@Override
	public String displayState() {
		return String.format("%s, Serving food<%s>", waiter.getName(), getCurrentCustomer().getName());
	}

}
