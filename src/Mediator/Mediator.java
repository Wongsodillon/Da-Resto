package Mediator;

import java.util.Scanner;
import java.util.Vector;

import Chef.Chef;
import Chef.ChefDone;
import Chef.ChefIdle;
import Customer.Customer;
import Human.Human;
import Restaurant.Restaurant;
import Waiter.Waiter;
import Waiter.WaiterIdle;
import Waiter.WaiterServing;

public class Mediator implements MediatorInterface {

	private volatile Vector<Customer> customers = new Vector<Customer>();
	private volatile Vector<Chef> chefs = new Vector<Chef>();
	private volatile Vector<Waiter> waiters = new Vector<Waiter>();
	private volatile Restaurant restaurant;
	private Scanner scan = new Scanner(System.in);
	public Mediator() {
		restaurant = Restaurant.getInstance();
	}
	
	@Override
	public synchronized void sendMessage(Human sender, String message) {
		if (message.equalsIgnoreCase("customerleave")) {
			removeCustomer((Customer) sender);
			if (((Customer) sender).getState().getCurrentChef() != null) {
				((Customer) sender).getState().getCurrentChef().setState(new ChefIdle(((Customer) sender).getState().getCurrentChef()));
			}
			if (((Customer) sender).getState().getCurrentWaiter() != null) {
				((Customer) sender).getState().getCurrentWaiter().setState(new WaiterIdle(((Customer) sender).getState().getCurrentWaiter()));
			}
			restaurant.addScore(-300);
		}
		if (message.equalsIgnoreCase("finish")) {
			// Sender -> CustomerEating
			int score = ((Customer) sender).getState().getCurrentChef().getSkill() * 30;
			restaurant.addScore(score);
			removeCustomer((Customer) sender);
		}
		if (message.equalsIgnoreCase("customerordering")) {
			// Sender -> CustomerOrder
			Waiter idlingWaiter = getIdleWaiter();
			if (idlingWaiter != null) {
				idlingWaiter.receiveCustomer((Customer) sender);
			}
		}
		if (message.equalsIgnoreCase("endorder")) {
			// Sender -> WaiterTakingOrder
			((Waiter) sender).receiveCustomer(((Waiter) sender).getState().getCurrentCustomer());
		}
		if (message.equalsIgnoreCase("callchef")) {
			// Sender -> WaiterWaitForChef
			Chef idlingChef = getIdleChef();
			if (idlingChef != null) {
				idlingChef.receiveCustomer(((Waiter) sender).getState().getCurrentCustomer(), (Waiter) sender);
				((Waiter) sender).getState().change();
			}
		}
		if (message.equalsIgnoreCase("foodready")) {
			// Sender -> ChefDone;
			Waiter idlingWaiter = getIdleWaiter();
			if (idlingWaiter != null) {
				idlingWaiter.getState().setServingFoodState(((Chef) sender).getState().getCurrentCustomer(), (Chef) sender);
				((Chef) sender).getState().getCurrentCustomer().getState().change();
				((Chef) sender).getState().change(); 
			}
		}
		if (message.equalsIgnoreCase("foodotw")) {
//			System.out.println("Food OTW " + sender.getName());
			// Sender -> WaiterServing
			(((Waiter) sender)).getState().getCurrentCustomer().getState().change();
			(((Waiter) sender)).getState().change();
		}
	}
	public Waiter getIdleWaiter() {
		synchronized (waiters) {
			for (Waiter w : waiters) {
				if (w.getState() instanceof WaiterIdle) {
					return w;
				}
			}
			return null;
		}
	}
	public Chef getIdleChef() {
		synchronized (chefs) {
			for (Chef c : chefs) {
				if (c.getState() instanceof ChefIdle) {
					return c;
				}
			}
			return null;
		}
	}
	@Override
	public void addCustomer(Customer customer) {
		customers.add(customer);
		new Thread(customer).start();
	}
	@Override
	public void addChef(Chef chef) {
		if (chefs.size() <= 7) {
			chefs.add(chef);
			new Thread(chef).start();
		}
		else {
			System.out.println("Max chefs only 7");
			scan.nextLine();
		}
	}

	@Override
	public void addWaiter(Waiter waiter) {
		if (waiters.size() < 7) {
			waiters.add(waiter);
			new Thread(waiter).start();
		}
		else {
			System.out.println("Max waiters only 7");
			scan.nextLine();
		}
	}

	@Override
	public void removeCustomer(Customer customer) {
		customers.remove(customer);
		customer.stop();
	}
	private int getMax() {
		int a = Math.max(customers.size(), waiters.size());
		int b = Math.max(a, chefs.size());
		return b;
	}
	@Override
	public void displayEntities() {
		System.out.println("=========================================================================================");
		System.out.println("| Customers                        | Waiter                      | Cook                 |");
		System.out.println("-----------------------------------------------------------------------------------------");
		for (int i = 0; i < getMax(); i++) {
			if (customers.size() > i) {
				synchronized (customers) {
					System.out.printf("| %-32s |", customers.get(i).getState().displayState());
				}
			}
			else System.out.printf("| %-32s |", " ");
			if (waiters.size() > i) {
				synchronized (waiters) {
					System.out.printf(" %-27s |", waiters.get(i).getState().displayState());
				}
			}
			else System.out.printf(" %-27s |", "");
			if (chefs.size() > i) {
				synchronized (chefs) {
					System.out.printf(" %-21s|", chefs.get(i).getState().displayState());
				}
			}
			else System.out.printf(" %-21s|", "");
			System.out.println();
		}
		System.out.println("=========================================================================================");
		System.out.println();
	}
	public Vector<Customer> getCustomers() {
		return customers;
	}
	public Vector<Chef> getChefs() {
		return chefs;
	}
	public Vector<Waiter> getWaiters() {
		return waiters;
	}

}
