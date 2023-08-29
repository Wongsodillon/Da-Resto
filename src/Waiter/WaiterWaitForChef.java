package Waiter;

public class WaiterWaitForChef extends WaiterState {

	public WaiterWaitForChef(Waiter waiter) {
		super(waiter);
	}

	@Override
	public void doSomething() {
		waiter.getMediator().sendMessage(waiter, "callchef");
	}

	@Override
	public void change() {
		waiter.setState(new WaiterBringOrder(waiter, this.currentChef));
	}

	@Override
	public String displayState() {
		return String.format("%s, Wait for chef<%s>", waiter.getName(), getCurrentCustomer().getName());
	}

}
