package Customer;

import Factory.CustomerFactory;
import Main.GameThread;
import Mediator.Mediator;
import Restaurant.Restaurant;
import Util.Utilities;

public class CustomerGenerator extends GameThread {

	Restaurant restaurant;
	CustomerFactory customerFactory;
	Mediator mediator;
	private static CustomerGenerator instance = null;
	private CustomerGenerator(Mediator mediator) {
		restaurant = Restaurant.getInstance();
		customerFactory = new CustomerFactory();
		this.mediator = mediator;
	}
	public static CustomerGenerator getInstance(Mediator mediator) {
		if (instance == null) {
			instance = new CustomerGenerator(mediator);
		}
		return instance;
	}
 	@Override
	public void doSomething() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (Utilities.getRand().nextInt(4) == 0 && mediator.getCustomers().size() < restaurant.getSeats()) {
			mediator.addCustomer(customerFactory.createCustomer(mediator));
		}
	}

}
