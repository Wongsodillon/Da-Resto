package Customer;


import Human.Human;
import Mediator.Mediator;

public class Customer extends Human {
	
	private Integer tolerance = 12;
	private CustomerState state;
	
	public Customer(String name, Mediator mediator) {
		super(name, mediator);
		state = new CustomerOrder(this);
	}

	@Override
	public void doSomething() {
		state.doSomething();
	}
	protected void reduceTolerance() {
		tolerance -= 1;
		if (this.tolerance <= 0) {
			getMediator().sendMessage(this, "customerleave");
		}
	}
	public Integer getTolerance() {
		return tolerance;
	}

	public void setTolerance(Integer tolerance) {
		this.tolerance = tolerance;
	}

	public CustomerState getState() {
		return state;
	}

	public void setState(CustomerState state) {
		this.state = state;
	}
}
