package main;

import diskio.Storage;
import item.TaskList;
import ui.RoboastParser;
import ui.UI;

public class Roboast {
    private static final String BOT_NAME = "Roboast";
    private static final String LINE = "_".repeat(50);

    private UI ui;
    private TaskList taskList;
    private RoboastParser roboastParser;

    public void start() {

        taskList = new TaskList(Storage.loadFromCSV("./data/roboast.csv"));
        ui = new UI();
        roboastParser = new RoboastParser(taskList);

        ui.printHello();
        roboastParser.itemManage(taskList);
        ui.printGoodbye();

        Storage.saveToCSV("./data/roboast.csv", taskList.getItemList());
    }


}
