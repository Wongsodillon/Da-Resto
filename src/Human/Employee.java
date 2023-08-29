package Human;

import Customer.Customer;
import Mediator.Mediator;

public abstract class Employee extends Human {
	private int speed;

	public Employee(String name, Mediator mediator) {
		super(name, mediator);
		this.speed = 1;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
