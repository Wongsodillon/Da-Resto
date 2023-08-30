package Customer;

import Factory.CustomerFactory;
import Main.GameThread;
import Mediator.Mediator;
import Restaurant.Restaurant;
import Util.Observer;
import Util.Utilities;

public class CustomerGenerator extends GameThread implements Observer {

	Restaurant restaurant;
	CustomerFactory customerFactory;
	Mediator mediator;
	public CustomerGenerator(Mediator mediator) {
		restaurant = Restaurant.getInstance();
		customerFactory = new CustomerFactory();
		this.mediator = mediator;
	}
 	@Override
	public void doSomething() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (Utilities.getRand().nextInt(4) == 0 && mediator.getCustomers().size() < restaurant.getSeats()) {
			mediator.addCustomer(customerFactory.createCustomer(mediator));
		}
	}
	@Override
	public void startRandomize() {
		doSomething();
	}

}
