package Main;

import java.util.Scanner;

import Restaurant.Restaurant;

public class Facade {

	Scanner scan = new Scanner(System.in);
	Restaurant restaurant;
	public Facade() {
		restaurant = Restaurant.getInstance();
	}
	public void pauseRestaurant() {
		restaurant.pauseMenu();
		System.out.println("1. Continue Businesss");
		System.out.println("2. Upgrade Restaurant");
		System.out.println("3. Close Business");
		restaurant.pauseRestaurant();
	}
	public void menuMain() {
		int menu;
		restaurant.pauseMenu();
		System.out.println("1. Continue Businesss");
		System.out.println("2. Upgrade Restaurant");
		System.out.println("3. Close Business");
		do {
			menu = scan.nextInt(); scan.nextLine();
		}
		while (menu < 1 || menu > 3);
		if (menu == 1) {
			resumeRestaurant();
		}
		else if (menu == 3) {
			stopBusiness();
		}
		else if (menu == 2) {
			upgradeMenu();
		}
	}
	public void upgradeMenu() {
		restaurant.pauseMenu();
		int menu;
		System.out.println("1. Increase Restaurant's Seat <Rp. 400>");
		System.out.println("2. Hire New Employee");
		System.out.println("3. Back to Pause Menu");
		do
		{
			System.out.print("Input [1..3]: ");
			menu = scan.nextInt(); scan.nextLine();
		}
		while (menu < 1 || menu > 3);
		if (menu == 3) {
			menuMain();
		}
		else if (menu == 1) {
			restaurant.addSeat();
			resumeRestaurant();
		}
		else if (menu == 2) {
			hireEmployee();
		}
	}
	public void hireEmployee() {
		restaurant.pauseMenu();
		System.out.println("HIRE NEW EMPLOYEE");
		System.out.println("1. Hire New Waiter <Rp. 300>");
		System.out.println("2. Hire New Cook <Rp. 400>");
		System.out.println("3. Back to upgrade Menu");
		int menu;
		do {
			System.out.print("Input [1..3]: ");
			menu = scan.nextInt(); scan.nextLine();
		}
		while (menu < 1 || menu > 3);
		if (menu == 3) {
			upgradeMenu();
		}
		else if (menu == 1) {
			restaurant.hireWaiter();
			resumeRestaurant();
		}
		else if (menu == 2) {
			restaurant.hireChef();
			resumeRestaurant();
		}
	}
	public void resumeRestaurant() {
		restaurant.resumeRestaurant();
	}
	public void stopBusiness() {
		restaurant.stopBusiness();
		new Main();
	}
}
