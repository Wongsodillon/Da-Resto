package Main;

import java.util.Scanner;
import Highscore.Highscore;
import Util.Utilities;

public class Main {
	Scanner scan = new Scanner(System.in);
	Utilities util = Utilities.getInstance();
	Highscore highscore = Highscore.getInstance();
	Facade facade = new Facade();
	public Main() {
		highscore.readScore();
		startMenu();
	}
	public void startMenu() {
		util.cls();
		int menu;
		System.out.println("1. Play New Restaurant");
		System.out.println("2. High Score");
		System.out.println("3. Exit");
		do
		{
			System.out.print(">> ");
			menu = scan.nextInt();
			scan.nextLine();
		}
		while (menu < 1 || menu > 3);
		if (menu == 1) {
			util.cls();
			String name;
			do
			{
				System.out.print("Input Restaurant Name: ");
				name = scan.nextLine();
			}
			while(name.length() < 3 || name.length() > 15);
			Game.getInstance(name);
		}
		else if (menu == 2) {
			highscore.displayScore();
			scan.nextLine();
			new Main();
		}
		else if (menu == 3) {
			return;
		}
	}
	public static void main(String[] args) {
		new Main();
	}
}