package Mediator;

import Chef.Chef;
import Customer.Customer;
import Human.Human;
import Waiter.Waiter;

public interface MediatorInterface {
	public void sendMessage(Human sender, String message);
	public void addCustomer(Customer customer);
	public void addChef(Chef chef);
	public void addWaiter(Waiter waiter);
	public void removeCustomer(Customer customer);
	public void displayEntities();
}
