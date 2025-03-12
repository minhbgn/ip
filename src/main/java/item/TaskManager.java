package item;

import exception.RoboastException;
import ui.UI;

import java.util.ArrayList;

/**
 * Task Manager. Handles all the commands for Roboast. The central processing class for Roboast
 */
public class TaskManager {
    /**
     * LINE constant for ease when printing as it is repeatedly used throughout the project.
     */
    private static final String LINE = "_".repeat(50);

    /**
     * COMMAND_LIST constant to show the legal commands for Roboast
     */
    public static final String[] COMMAND_LIST = {"list","mark","unmark","todo","deadline","event","deleteAll","delete","find"};

    private UI ui = new UI();
    private final ArrayList<Item> itemList;

    /**
     * Filled Initializer for Task Manager
     * @param itemList The list of items (Todo/ Event/ Deadline) of the user
     */
    public TaskManager(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    /**
     * Parse the command from the RoboastParser to meaningful functions
     * @param input the input of the user, parsed through RoboastParser
     * @throws RoboastException handles error related specifically to Roboast
     */
    public void action(String input) throws RoboastException {

        String command;
        String content;
        int spaceIndex = input.indexOf(' ');

        try {
            command = input.substring(0, spaceIndex);
            content = input.substring(spaceIndex + 1);
        }
        catch (IndexOutOfBoundsException e) {
            command = input;
            content = "";
        }
        if (command.equals("mark")) {
            mark(content, true);
        }
        else if (command.equals("unmark")) {
            mark(content, false);
        }
        else if (command.equals("todo")) {
            addTodo(content);
        }
        else if (command.equals("deadline")) {
            addDeadlines(content);
        }
        else if (command.equals("event")) {
            addEvents(content);
        }
        else if (command.equals("list")) {
            showItemList();
        }
        else if (command.equals("deleteAll")) {
            deleteAll();
        }
        else if (command.equals("delete")) {
            delete(content);
        }
        else if (command.equals("find")){
            findItem(content);
        }
        else {
            throw new RoboastException("Invalid command");
        }

    }

    /**
     * Mark the item as done or not done.
     * @param itemNo The item number in the list
     * @param isDone True to mark the item as done, False to mark the item as not done
     */
    public void mark(String itemNo, boolean isDone) {
        try{
            int posInt = Integer.parseInt(itemNo);
            Item item = itemList.get(posInt-1);

            if (isDone){
                item.setDone(true);
                System.out.println(LINE);
                System.out.println("mark: " + item.getItemName() + "\n" + LINE);
            }
            else{
                item.setDone(false);
                System.out.println(LINE);
                System.out.println("unmarked: " + item.getItemName() + "\n" + LINE);
            }
        }

        catch (Exception e){
            if (itemList.isEmpty()) {
                ui.showEmptyItemListError();
                return;
            }

            ui.showWrongMarkFormatError();

        }
    }

    /**
     * Add a Todo task into the list
     * @param content name of the Todo task
     */
    public void addTodo(String content) {
        if (content.isEmpty()){
            ui.showAddEmptyError();
            return;
        }
        System.out.println(LINE);
        Item item = new Todo(content, false);
        itemList.add(item);
        System.out.println("added: " + item.getItemName() + "\n" +
                "You now have " + itemList.size() + " tasks\n" + LINE);
    }

    /**
     * Add a Deadline into the list
     * @param content content of the Deadline including name and the date/time the task ends
     */
    public void addDeadlines(String content) {
        if (content.isEmpty()){
            ui.showAddEmptyError();
            return;
        }
        System.out.println(LINE);
        Item item = new Deadline(content, false);
        itemList.add(item);
        System.out.println("added: " + item.getItemName() + "\n" +
                "You now have " + itemList.size() + " tasks\n" + LINE);
    }

    /**
     * Add an Event into the list
     * @param content content of the Event including name and the date/time the event starts/ends
     */
    public void addEvents(String content) {
        if (content.isEmpty()) {
            ui.showAddEmptyError();
            return;
        }
        System.out.println(LINE);
        Item item = new Event(content, false);
        itemList.add(item);
        System.out.println("added: " + item.getItemName() + "\n" +
                "You now have " + itemList.size() + " tasks\n" + LINE);
    }

    /**
     * Show all the items (todo/deadline/event) in the list.
     */
    public void showItemList() {
        if (itemList.isEmpty()){
            ui.showEmptyItemListError();
        }
        System.out.println(LINE);
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(i + 1 + ". " + itemList.get(i));
        }
        System.out.println(LINE);
    }

    /**
     * Count how many task/deadline/event has finished
     * @return the number of tasks/deadline/event that has finished
     */
    public int countDone() {
        int i = 0;
        while (i < itemList.size()) {
            if (itemList.get(i).isDone()){
                i = i + 1;
            }
        }
        return i;
    }

    /**
     * Delete all the items in the list that has been done
     */
    public void deleteAll() {

        try{
            if (itemList.isEmpty()) {
                throw new RoboastException("List is empty");
            }

            else if (countDone() == 0) {
                throw new RoboastException("All setDone items have been deleted");
            }
        }
        catch (RoboastException e) {
            System.out.println(e);
            return;
        }

        int i = 0;
        while (i < itemList.size()) {
            if (itemList.get(i).isDone()){
                itemList.remove(i);
            }
            else{
                i = i + 1;
            }
        }

        System.out.println(LINE);
        System.out.println("All setDone items have been deleted");
        System.out.println(LINE);
    }

    /**
     * Delete a specific item
     * @param itemNo The item number in the list
     */
    public void delete(String itemNo) {
        try {
            if (itemNo.isEmpty()){
                throw new RoboastException("Errr I don't know what to delete");
            }
            Integer.parseInt(itemNo);
            Item item = itemList.get(Integer.parseInt(itemNo) - 1);
            itemList.remove(Integer.parseInt(itemNo) - 1);
            System.out.println(LINE);
            System.out.println("Item deleted successfully: " + item.getItemName() + "\n" + LINE);
        }
        catch (NumberFormatException e) {
            System.out.println(LINE);
            System.out.println("Please use an integer after the delete command as in the format 'delete integer'");
            System.out.println(LINE);
        }
        catch (RoboastException e) {
            System.out.println(LINE);
            System.out.println(e.getMessage());
            System.out.println("Please include what you want to delete");
            System.out.println(LINE);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(LINE);
            System.out.println("Please choose a number in the range 1 to " + itemList.size() + ".");
            System.out.println(LINE);
        }
    }

    /**
     * Get the whole item list, used when the information about the item list such as length/content, etc. are needed
     * @return itemList the whole item list
     */
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    /**
     * Find a specific item in the list. List all the items that contains what needed to be found
     * @param name the name of the item the user wants to find
     */
    public void findItem(String name){
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemName().contains(name)) {
                System.out.println(LINE);
                System.out.println(i + 1 + ". " + itemList.get(i));
                System.out.println(LINE);
            }
        }
    }
}
