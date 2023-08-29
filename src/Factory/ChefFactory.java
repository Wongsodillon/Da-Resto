package Factory;

import Chef.Chef;
import Mediator.Mediator;

public class ChefFactory extends Factory {

	public ChefFactory() {
		super();
	}
	public Chef createChef(Mediator mediator) {
		this.mediator = mediator;
		Boolean exist = false;
		String name;
		do {
			name = restaurant.util.generateInitial();
			exist = restaurant.isExist(name);
		}
		while (exist == true);
		return new Chef(name, mediator);
	}
}
