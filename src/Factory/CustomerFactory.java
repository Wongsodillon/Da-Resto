package Factory;

import Customer.Customer;
import Mediator.Mediator;

public class CustomerFactory extends Factory {

	public CustomerFactory() {
		super();
	}
	public Customer createCustomer(Mediator mediator) {
			this.mediator = mediator;
			Boolean exist = false;
			String name;
			do {
				name = restaurant.util.generateInitial();
				exist = restaurant.isExist(name);
			}
			while (exist == true);
			return new Customer(name, mediator);
	}
}
