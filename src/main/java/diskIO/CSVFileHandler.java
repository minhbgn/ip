package diskIO;

import item.Item;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CSVFileHandler {
    public static void saveToCSV(String filename, ArrayList<Item> items) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Item item : items) {
                writer.println(item.toCSVString());
            }
        } catch (IOException e) {
            System.out.println("Error while writing to csv file");
        }
    }

    public static ArrayList<Item> loadFromCSV(String filename) {
        ArrayList<Item> items = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            try {
                File directory = new File("./data/");
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                file = new File("./data/roboast.csv");
                file.createNewFile();
                System.out.println("File not found. Created new file at: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return items;
            }
        }

        // Read file if it exists
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                items.add(Item.fromCSVString(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return items;
    }
}
