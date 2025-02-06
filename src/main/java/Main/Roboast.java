package Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Item.Item;
import Item.Todo;
import Item.Event;
import Item.Deadline;

public class Roboast {
    private static final String BOT_NAME = "Roboast";
    private static final String LINE = "_".repeat(50);
    private static final String[] COMMAND_LIST = {"list","mark","unmark","todo","deadline","event","deleteAll"};

    private final ArrayList<Item> itemList = new ArrayList<Item>();

    public void start() {
        printHello();
        itemManage();
        printGoodbye();
    }

    public void printHello(){
        System.out.println(LINE);
        System.out.println("Hello! I'm " + BOT_NAME + "!");
        System.out.println("What can I do for you?");
        System.out.println(LINE);
    }

    public void printGoodbye(){
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public void itemManage(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equals("bye")) {

            int space = input.indexOf(' ');
            boolean foundSpace = (space > 0);
            boolean isSpaceAtEnd = (space == input.length() - 1);

            if (foundSpace && !isSpaceAtEnd) {
                String command = input.substring(0, space);
                String content = input.substring(space+1);
                if (command.equals("mark")){
                    mark(content, true);
                }
                else if (command.equals("unmark")){
                    mark(content, false);
                }
                else if (command.equals("todo")){
                    addTodo(content);
                }
                else if (command.equals("deadline")){
                    addDeadlines(content);
                }
                else if (command.equals("event")){
                    addEvents(content);
                }
                else{
                    showCommandError();
                }
            }

            else{
                if (input.equals("list")) {
                    showItemList();
                }
                else if (input.equals("deleteAll")){
                    deleteAll();
                }
                else{
                    showCommandError();
                }
            }

            input = sc.nextLine();
        }

        System.out.println(LINE);
    }

    public void mark(String content, boolean isDone){
        try{
            int posInt = Integer.parseInt(content);
            Item item = itemList.get(posInt-1);

            if (isDone){
                item.mark(true);
                System.out.println(LINE);
                System.out.println("mark: " + item.getName() + "\n" + LINE);
            }
            else{
                item.mark(false);
                System.out.println(LINE);
                System.out.println("unmarked: " + item.getName() + "\n" + LINE);
            }
        }

        catch (Exception e){
            if (itemList.isEmpty()){
                System.out.println(LINE);
                System.out.println("Please add an item before marking!");
                System.out.println("What else do you want to do?");
                System.out.println(LINE);
                return;
            }

            System.out.println(LINE);
            System.out.println("Incorrect format for command \"mark\" or \"unmark\"");
            System.out.println("Correct format for command \"mark\" is \"mark {Positive Integer}\", max = " + (itemList.size()));
            System.out.println("Correct format for command \"unmark\" is \"unmark {Positive Integer}\", max = " + (itemList.size()));
            System.out.println("What else do you want to do?");
        }
    }

    public void addTodo(String content){
        System.out.println(LINE);
        Item item = new Todo(content, false);
        itemList.add(item);
        System.out.println("added: " + item.getName() + "\n" +
                "You now have " + itemList.size() + " tasks\n" + LINE);
    }

    public void addDeadlines(String content){
        System.out.println(LINE);
        Item item = new Deadline(content, false);
        itemList.add(item);
        System.out.println("added: " + item.getName() + "\n" +
                "You now have " + itemList.size() + " tasks\n" + LINE);
    }

    public void addEvents(String content){
        System.out.println(LINE);
        Item item = new Event(content, false);
        itemList.add(item);
        System.out.println("added: " + item.getName() + "\n" +
                "You now have " + itemList.size() + " tasks\n" + LINE);
    }

    public void showCommandError(){
        System.out.println(LINE);
        System.out.println("I don't understand this command");
        System.out.println("Please choose from the following commands: ");
        System.out.println(Arrays.toString(COMMAND_LIST));
        System.out.println(LINE);
    }

    public void showItemList(){
        System.out.println(LINE);
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(i + 1 + ". " + itemList.get(i));
        }
        System.out.println(LINE);
    }

    public void deleteAll(){
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
        System.out.println("All mark items have been deleted");
        System.out.println(LINE);
    }
}
