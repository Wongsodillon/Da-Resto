package Factory;

import Mediator.Mediator;
import Waiter.Waiter;

public class WaiterFactory extends Factory {

	public WaiterFactory() {
		
	}
	public Waiter createWaiter(Mediator mediator) {
		this.mediator = mediator;
		Boolean exist = false;
		String name;
		do {
			name = restaurant.util.generateInitial();
			exist = restaurant.isExist(name);
		}
		while (exist == true);
		return new Waiter(name, mediator);
	}
}
