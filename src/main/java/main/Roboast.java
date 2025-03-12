package main;

import diskio.Storage;
import item.TaskManager;
import ui.RoboastParser;
import ui.UI;

public class Roboast {
    private static final String BOT_NAME = "Roboast";
    private static final String LINE = "_".repeat(50);

    private UI ui;
    private TaskManager taskManager;
    private RoboastParser roboastParser;

    public void start() {

        taskManager = new TaskManager(Storage.loadFromCSV("./data/roboast.csv"));
        ui = new UI(taskManager);
        roboastParser = new RoboastParser(taskManager);

        ui.printHello();
        roboastParser.itemManage(taskManager);
        ui.printGoodbye();

        Storage.saveToCSV("./data/roboast.csv", taskManager.getItemList());
    }


}
