package Factory;

import Mediator.Mediator;
import Restaurant.Restaurant;

public abstract class Factory {

	Restaurant restaurant;
	Mediator mediator;
	public Factory() {
		restaurant = Restaurant.getInstance();
	}

}
