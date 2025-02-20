package item;

import exception.RoboastException;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemManage {
    private final ArrayList<Item> itemList;
    private static final String LINE = "_".repeat(50);
    private static final String[] COMMAND_LIST = {"list","mark","unmark","todo","deadline","event","deleteAll"};

    public ItemManage(ArrayList<Item> itemList) {
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
                System.out.println("setDone: " + item.getItemName() + "\n" + LINE);
            }
            else{
                item.setDone(false);
                System.out.println(LINE);
                System.out.println("unmarked: " + item.getItemName() + "\n" + LINE);
            }
        }

        catch (Exception e){
            if (itemList.isEmpty()) {
                System.out.println(LINE);
                System.out.println("Please add an item before marking!");
                System.out.println("What else do you want to do?");
                System.out.println(LINE);
                return;
            }

            System.out.println(LINE);
            System.out.println("Incorrect format for command \"setDone\" or \"unmark\"");
            System.out.println("Correct format for command \"setDone\" is \"setDone {Positive Integer}\", max = " + (itemList.size()));
            System.out.println("Correct format for command \"unmark\" is \"unmark {Positive Integer}\", max = " + (itemList.size()));
            System.out.println("What else do you want to do?");
        }
    }

    public void addTodo(String content) {
        if (content.isEmpty()){
            showAddEmptyError();
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
            showAddEmptyError();
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
            showAddEmptyError();
            return;
        }
        System.out.println(LINE);
        Item item = new Event(content, false);
        itemList.add(item);
        System.out.println("added: " + item.getItemName() + "\n" +
                "You now have " + itemList.size() + " tasks\n" + LINE);
    }

    public void showAddEmptyError() {
        try {
            throw new RoboastException("Errr I do not know what to add.");
        }
        catch (RoboastException e) {
            System.out.println(LINE);
            System.out.println(e.getMessage());
            System.out.println("Please include what you want to add after the command in the format 'command content'");
        }
    }
    public void showCommandError() {
        try{
            throw new RoboastException("Oops, I don't understand the command.");
        }
        catch (RoboastException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(LINE);
        System.out.println("I don't understand this command");
        System.out.println("Please choose from the following commands: ");
        System.out.println(Arrays.toString(COMMAND_LIST));
        System.out.println(LINE);
    }

    public void showItemList() {
        if (itemList.isEmpty()){
            System.out.println(LINE);
            System.out.println("List is empty");
            System.out.println(LINE);
            return;
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
}
