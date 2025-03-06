package ui;

import diskio.Storage;
import exception.RoboastException;
import item.TaskList;

import java.util.Scanner;

public class RoboastParser {

    private TaskList taskList;

    public RoboastParser(){}

    public RoboastParser(TaskList taskList){
        this.taskList = taskList;
    }

    public void itemManage(TaskList taskList) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("bye")) {
            try {
                taskList.action(input);
            }
            catch(RoboastException e) {
                System.out.println(e.getMessage());
                UI.showCommandError();
            }
            input = sc.nextLine();
            Storage.saveToCSV("./data/roboast.csv", taskList.getItemList());
        }

    }
}
