package Highscore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import Util.Utilities;

public class Highscore {

	public static Highscore highScore = null;
	public Vector<Score> scoreList;
	public Utilities util = Utilities.getInstance();
	private static final String filePath = "src/highscore.txt";
	private Highscore() {
		scoreList = new Vector<Score>();
		readScore();
	}
	public static Highscore getInstance() {
		if (highScore == null) {
			highScore = new Highscore();
		}
		return highScore;
	}
	public void displayScore() {
		util.cls();
		sort();
		System.out.println("================================================");
		System.out.printf("| %-4s | %-28s| %-7s |\n", "Rank", "Restaurant Name", "Score");
		System.out.println("------------------------------------------------");
		for (int i = 0; i < scoreList.size(); i++) {
			System.out.printf("| %-4d | %-28s| %-7d |\n", i+1, scoreList.get(i).getName(), scoreList.get(i).getScore());
			if (i == 10) break;
		}
		System.out.println("================================================");
	}
	public void readScore() {
		File file = new File(filePath);
		Scanner reader;
		scoreList.clear();
		try {
			reader = new Scanner(file);
			String line;
			while(reader.hasNextLine()) {
				line = reader.nextLine();
				String[] data = line.split("#");
				scoreList.add(new Score(data[0], Integer.parseInt(data[1])));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void addNewScore(String name, int score) {
		try {
			FileWriter writer = new FileWriter(filePath, true);
			writer.write(String.format("%s#%d\n", name, score));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void sort() {
		
	}
}
