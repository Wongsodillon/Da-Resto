package Waiter;

import Chef.Chef;

public class WaiterBringOrder extends WaiterState {

	public WaiterBringOrder(Waiter waiter, Chef chef) {
		super(waiter);
		this.currentChef = chef;
	}

	@Override
	public void doSomething() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		change();
	}

	@Override
	public void change() {
		waiter.setState(new WaiterIdle(waiter));
	}

	@Override
	public String displayState() {
		return String.format("%s, bringing order <%s>", waiter.getName(), getCurrentChef().getName());
	}

}
