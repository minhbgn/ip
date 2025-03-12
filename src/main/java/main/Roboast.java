package main;

import diskio.Storage;
import item.TaskManager;
import ui.RoboastParser;
import ui.UI;

/**
 * Roboast - Your robo assistant.
 * This class is the central class to call every other functions to correctly run Roboast
 * Only consist of one function - start
 */
public class Roboast {
    private static final String BOT_NAME = "Roboast";
    private static final String LINE = "_".repeat(50);

    private UI ui;
    private TaskManager taskManager;
    private RoboastParser roboastParser;

    /**
     * Load data from disk into itemList and parse into Task Manager.
     * Start the Roboast. Call every other classes to run Roboast
     */
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
