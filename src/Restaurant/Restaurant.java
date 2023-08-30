package Restaurant;

import java.util.Scanner;

import Chef.Chef;
import Customer.Customer;
import Customer.CustomerGenerator;
import Factory.ChefFactory;
import Factory.WaiterFactory;
import Highscore.Highscore;
import Main.GameThread;
import Mediator.Mediator;
import Util.Utilities;
import Waiter.Waiter;

public class Restaurant extends GameThread {

	Scanner scan = new Scanner(System.in);
	public static volatile Restaurant instance = null;
	public Utilities util = Utilities.getInstance();
	private String name;
	private int money;
	private int seats;
	private int score;
	Mediator mediator;
	ChefFactory chefFactory;
	WaiterFactory waiterFactory;
	CustomerGenerator generator;
	private Restaurant() {
		
	}
	public void init() {
		money = 1300;
		score = 0;
		seats = 4;
		mediator = new Mediator();
		waiterFactory = new WaiterFactory();
		chefFactory = new ChefFactory();
		generator = CustomerGenerator.getInstance(mediator);
		new Thread(generator).start();
		initStaff();
	}
	@Override
	public void doSomething() {
		util.cls();
		System.out.printf("%s is on business\n", name);
		System.out.println("Money: " + money);
		System.out.println("Score: " + score);
		System.out.println("Size: " + seats);
		mediator.displayEntities();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static Restaurant getInstance() {
		if (instance == null) {
			instance = new Restaurant();
		}
		return instance;
	}
	public boolean isExist(String name) {
		for (Chef c : mediator.getChefs()) {
			if (c.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		for (Customer c : mediator.getCustomers()) {
			if (c.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		for (Waiter w : mediator.getWaiters()) {
			if (w.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	private void initStaff() {
		mediator.addChef(chefFactory.createChef(mediator));
		mediator.addChef(chefFactory.createChef(mediator));
		mediator.addWaiter(waiterFactory.createWaiter(mediator));
		mediator.addWaiter(waiterFactory.createWaiter(mediator));
	}
	public void hireWaiter() {
		if (money >= 300) {
			mediator.addWaiter(waiterFactory.createWaiter(mediator));
			money -= 300;
			System.out.printf("Added new waiter %s\n", mediator.getWaiters().get(mediator.getWaiters().size() - 1).getName());
		}
		else {
			System.out.println("Not enough money");
		}
		scan.nextLine();
	}
	public void hireChef() {
		if (money >= 400) {
			money -= 400;
			mediator.addChef(chefFactory.createChef(mediator));
			System.out.printf("Added new chef %s\n", mediator.getChefs().get(mediator.getChefs().size() - 1).getName());
		}
		else {
			System.out.println("Not enough money");
		}
		scan.nextLine();
	}
	public void pauseMenu() {
		util.cls();
		System.out.println("---------PAUSE MENU--------");
		System.out.println("           Status          ");
		System.out.printf("        Money : Rp. %d\n", this.money);
		System.out.printf("        Score : %d Points\n", this.score);
		System.out.printf("        Size  : %d Seats\n\n", this.seats);
	}
	public void pauseRestaurant() {
		generator.pause();
		this.pause();
		for(Chef c : mediator.getChefs()) {
			c.pause();
		}
		for(Customer c : mediator.getCustomers()) {
			c.pause();
		}
		for(Waiter c : mediator.getWaiters()) {
			c.pause();
		}
	}
	public void resumeRestaurant() {
		generator.resume();
		this.resume();
		for(Chef c : mediator.getChefs()) {
			c.resume();
		}
		for(Customer c : mediator.getCustomers()) {
			c.resume();
		}
		for(Waiter c : mediator.getWaiters()) {
			c.resume();
		}
	}
	public void stopBusiness() {
		generator.stop();
		this.stop();
		for(Chef c : mediator.getChefs()) {
			c.stop();
		}
		for(Customer c : mediator.getCustomers()) {
			c.stop();
		}
		for(Waiter c : mediator.getWaiters()) {
			c.stop();
		}
		Highscore.addNewScore(name, score);
	}
	public String getRestaurantName() {
		return name;
	}
	public void setRestaurantName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getSeats() {
		return seats;
	}
	public void addSeat() {
		if (this.seats <= 13 && this.money >= 400) {
			this.seats++;
			this.money -= 400;
			System.out.println("Seat increased to " + seats);
		}
		else if (money < 400) {
			System.out.println("Not enough money");
		}
		else if (seats > 13) {
			System.out.println("Max seats");
		}
		scan.nextLine();
	}
	public int getScore() {
		return score;
	}
	public void addScore(int score) {
		this.score += score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
