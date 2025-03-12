package ui;

import diskio.Storage;
import exception.RoboastException;
import item.TaskManager;

import java.util.Scanner;

public class RoboastParser {

    private TaskManager taskManager;

    public RoboastParser(){}

    public RoboastParser(TaskManager taskManager){
        this.taskManager = taskManager;
    }

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
