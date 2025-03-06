package ui;

import diskio.Storage;
import exception.RoboastException;
import item.Item;
import item.TaskList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {

    private static final String BOT_NAME = "Roboast";
    private static final String LINE = "_".repeat(50);

    public UI(){

    }

    public static void printHello() {
        System.out.println(LINE);
        System.out.println("Hello! I'm " + BOT_NAME + "!");
        System.out.println("What can I do for you?");
        System.out.println(LINE);
    }

    public static void printGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public static void showAddEmptyError() {
        try {
            throw new RoboastException("Errr I do not know what to add.");
        }
        catch (RoboastException e) {
            System.out.println(LINE);
            System.out.println(e.getMessage());
            System.out.println("Please include what you want to add after the command in the format 'command content'");
        }
    }

    public static void showCommandError() {
        try{
            throw new RoboastException("Oops, I don't understand the command.");
        }
        catch (RoboastException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(LINE);
        System.out.println("I don't understand this command");
        System.out.println("Please choose from the following commands: ");
        System.out.println(Arrays.toString(TaskList.COMMAND_LIST));
        System.out.println(LINE);
    }
}
