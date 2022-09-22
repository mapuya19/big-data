package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * WordCount
 */
public class WordCount {
    public static void main(String[] args) {
        String[] words = {"hackathon", "dec", "chicago", "java", "engineers" };
        int hackMatch = 0;
        int decMatch = 0;
        int chiMatch = 0;
        int jaMatch = 0;
        int engMatch = 0;

        try {
            File file = new File("input_hw_3.txt");
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String data = read.nextLine();
                System.out.println(data);
                for (int i = 0; i <= words.length - 1; i++) {
                    String wordCheck = words[i];
                    if (data.toLowerCase().contains(wordCheck)) {
                        switch (words[i]) {
                            case "hackathon" -> hackMatch++;
                            case "dec" -> decMatch++;
                            case "chicago" -> chiMatch++;
                            case "java" -> jaMatch++;
                            case "engineers" -> engMatch++;
                        }
                    }
                }
            }

            System.out.println("Chicago " + chiMatch);
            System.out.println("Dec " + decMatch);
            System.out.println("Java " + jaMatch);
            System.out.println("Hackathon " + hackMatch);
            System.out.println("Engineers " + engMatch);

            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}