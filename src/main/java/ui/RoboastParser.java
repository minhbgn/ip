package ui;

import diskio.Storage;
import exception.RoboastException;
import item.TaskManager;

import java.util.Scanner;

/**
 * This class is used to parse user's input to the Task Manager to perform functions
 */
public class RoboastParser {

    private TaskManager taskManager;

    /**
     * Initializer for RoboastParser
     * @param taskManager the Task Manager that performs every function. Given here to catch the input from the Parser
     */
    public RoboastParser(TaskManager taskManager){
        this.taskManager = taskManager;
    }

    /**
     * Continously get the input from the user to perform task
     * @param taskManager the Task Manager that performs every function. Given here to catch the input from the Parser
     */
    public void itemManage(TaskManager taskManager) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("bye")) {
            try {
                taskManager.action(input);
            }
            catch(RoboastException e) {
                System.out.println(e.getMessage());
                UI.showCommandError();
            }
            input = sc.nextLine();
            Storage.saveToCSV("./data/roboast.csv", taskManager.getItemList());
        }

    }
}
