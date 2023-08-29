package Waiter;

public class WaiterTakingOrder extends WaiterState {

	public WaiterTakingOrder(Waiter waiter) {
		super(waiter);
	}

	@Override
	public void doSomething() {
		try {
			Thread.sleep((6 - waiter.getSpeed()) * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waiter.getMediator().sendMessage(waiter, "endorder");
	}

	@Override
	public void change() {
		waiter.setState(new WaiterWaitForChef(waiter));
	}

	@Override
	public String displayState() {
		return String.format("%s, Take order<%s>", waiter.getName(), getCurrentCustomer().getName());
	}

}
