package item;

import exception.RoboastException;
import ui.UI;

import java.util.ArrayList;

public class TaskManager {
    private static final String LINE = "_".repeat(50);
    public static final String[] COMMAND_LIST = {"list","mark","unmark","todo","deadline","event","deleteAll","delete","find"};

    private UI ui = new UI();
    private final ArrayList<Item> itemList;

    public TaskManager(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

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

    public void mark(String content, boolean isDone) {
        try{
            int posInt = Integer.parseInt(content);
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

    public int countDone() {
        int i = 0;
        while (i < itemList.size()) {
            if (itemList.get(i).isDone()){
                i = i + 1;
            }
        }
        return i;
    }

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

    public void delete(String content) {
        try {
            if (content.isEmpty()){
                throw new RoboastException("Errr I don't know what to delete");
            }
            Integer.parseInt(content);
            Item item = itemList.get(Integer.parseInt(content) - 1);
            itemList.remove(Integer.parseInt(content) - 1);
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

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void findItem(String name){
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemName().equals(name)) {
                System.out.println(LINE);
                System.out.println(i + 1 + ". " + itemList.get(i));
                System.out.println(LINE);
            }
        }
    }
}
