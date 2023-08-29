package Waiter;

public class WaiterIdle extends WaiterState {

	public WaiterIdle(Waiter waiter) {
		super(waiter);
		this.currentChef = null;
		this.currentCustomer = null;
	}

	@Override
	public void doSomething() {
		
	}

	@Override
	public void change() {
		waiter.setState(new WaiterTakingOrder(waiter));
	}

	@Override
	public String displayState() {
		return String.format("%s, Idle", waiter.getName());
	}

}
