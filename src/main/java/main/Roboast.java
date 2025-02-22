package main;
import java.util.ArrayList;
import java.util.Scanner;

import diskIO.CSVFileHandler;
import exception.RoboastException;
import item.Item;
import item.ItemManage;

public class Roboast {
    private static final String BOT_NAME = "Roboast";
    private static final String LINE = "_".repeat(50);
    private static final String[] COMMAND_LIST = {"list","mark","unmark","todo","deadline","event","deleteAll"};

    private ArrayList<Item> itemList = new ArrayList<>();

    public void start() {

        try {
            itemList = CSVFileHandler.loadFromCSV("./data/roboast.csv");
        }
        catch (Exception e) {

        }
        printHello();
        itemManage();
        printGoodbye();
        CSVFileHandler.saveToCSV("./data/roboast.csv", itemList);
    }

    public void printHello() {
        System.out.println(LINE);
        System.out.println("Hello! I'm " + BOT_NAME + "!");
        System.out.println("What can I do for you?");
        System.out.println(LINE);
    }

    public void printGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public void itemManage() {

        ItemManage itemManager = new ItemManage(itemList);

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("bye")) {
            try {
                itemManager.action(input);
            }
            catch(RoboastException e) {
                System.out.println(e.getMessage());
                itemManager.showCommandError();
            }
            input = sc.nextLine();
            CSVFileHandler.saveToCSV("./data/roboast.csv", itemList);
        }

    }

}
