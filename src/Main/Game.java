package Main;

import java.util.Scanner;

import Restaurant.Restaurant;

public class Game {
	Restaurant restaurant;
	private static Game instance = null;
	Scanner scan  = new Scanner(System.in);
	Facade facade = new Facade();
	private Game(String name) {
		restaurant = Restaurant.getInstance();
		restaurant.setName(name);
		restaurant.init();
		new Thread(restaurant).start();
		startGame();
	}
	public static Game getInstance(String name) {
		if (instance == null) {
			instance = new Game(name);
		}
		return instance;
	}
	public void startGame() {
		while (true) {
			scan.nextLine();
			int menu;
			if (!restaurant.isPaused()) {
				facade.pauseRestaurant();
			}
			menu = scan.nextInt();
			scan.nextLine();
			if (menu == 1) {
				facade.resumeRestaurant();
			}
			else if (menu == 2) {
				facade.upgradeMenu();
			}
			else if (menu == 3) {
				facade.stopBusiness();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
