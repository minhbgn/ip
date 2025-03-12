package ui;

import exception.RoboastException;
import item.TaskManager;

import java.util.Arrays;

/**
 * This class is used to print out common terms or long sentences to the User Interface
 */
public class UI {

    private static final String BOT_NAME = "Roboast";
    private static final String LINE = "_".repeat(50);

    private static TaskManager taskManager;

    /**
     * Empty initializer. Used when the information of the Item List is not necessary
     */
    public UI(){}

    /**
     * Filled initializer. Used when the information of the Item List is necessary
     * @param taskManager the Task Manager, used to get the information of the Item List
     */
    public UI(TaskManager taskManager){
        UI.taskManager = taskManager;
    }

    /**
     * Print Hello when the user starts the application
     */
    public static void printHello() {
        System.out.println(LINE);
        System.out.println("Hello! I'm " + BOT_NAME + "!");
        System.out.println("What can I do for you?");
        System.out.println(LINE);
    }

    /**
     * Print Goodbye when the user exits the application
     */
    public static void printGoodbye() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    /**
     * Print Error when the user tries to add nothing to the list
     */
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

    /**
     * Print Error when the user tries to do a command not implemented yet
     */
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
        System.out.println(Arrays.toString(TaskManager.COMMAND_LIST));
        System.out.println(LINE);
    }

    /**
     * Announce that the Item List is empty
     */
    public static void showEmptyItemListError(){
        System.out.println(LINE);
        System.out.println("List is empty");
        System.out.println(LINE);
    }

    /**
     * Show Error when the user tries to mark/unmark non-existing items or when they do not use item's number position to mark
     */
    public static void showWrongMarkFormatError(){
        System.out.println(LINE);
        System.out.println("Incorrect format for command \"mark\" or \"unmark\"");
        System.out.println("Correct format for command \"mark\" is \"mark {Positive Integer}\", max = " + taskManager.getItemList().size());
        System.out.println("Correct format for command \"unmark\" is \"unmark {Positive Integer}\", max = " + taskManager.getItemList().size());
        System.out.println("What else do you want to do?");
    }
}
