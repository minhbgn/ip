package Main;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import Item.Item;

public class Roboast {
    private static final String BOT_NAME = "Roboast";
    private static final String LINE = "_".repeat(50);

    public static void main(String[] args) {
        printHello();
        itemManage();
        printGoodbye();
    }

    public static void printHello(){
        System.out.println(LINE);
        System.out.println("Hello! I'm " + BOT_NAME + "!");
        System.out.println("What can I do for you?");
        System.out.println(LINE);
    }

    public static void printGoodbye(){
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public static void echo(){
        Scanner sc = new Scanner(System.in);
        String echo;
        echo = sc.nextLine();
        while (!echo.equals("bye")){
            System.out.println("REPEATING COMMANDS: ");
            System.out.println(LINE + "\n" + echo + "\n" + LINE);
            echo = sc.nextLine();
        }
        System.out.println(LINE);
    }

    public static void itemManage(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Item> itemList = new ArrayList<>();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                System.out.println(LINE);
                for (int i = 0; i < itemList.size(); i++) {
                    System.out.println(i + 1 + ". " + itemList.get(i));
                }
            }
            else if (input.contains("mark")){
                String posString = input.substring(input.indexOf(" ")+1);
                try{
                    int posInt = Integer.parseInt(posString);
                    Item item = itemList.get(posInt-1);
                    if (input.contains("unmark")){
                        item.mark(false);
                        System.out.println(LINE);
                        System.out.println("marked: " + item.getName() + "\n" + LINE);
                    }
                    else{
                        item.mark(true);
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
                        input = sc.nextLine();
                        continue;
                    }
                    System.out.println(LINE);
                    System.out.println("Incorrect format for command \"mark\" or \"unmark\"");
                    System.out.println("Correct format for command \"mark\" is \"mark {Positive Integer}\", max = " + (itemList.size()));
                    System.out.println("Correct format for command \"unmark\" is \"unmark {Positive Integer}\", max = " + (itemList.size()));
                    System.out.println("Would you want to add " + input + " to the list?");
                    System.out.println("Choose Y or N");
                    String answer = sc.nextLine();
                    while (!answer.equals("Y") & !answer.equals("N")){
                        System.out.println("Choose Y or N only");
                        answer = sc.nextLine();
                    }
                    if (answer.equals("Y")){
                        Item item = new Item(input, false);
                        itemList.add(item);
                        System.out.println(LINE + "\n added: " + item.getName() + "\n" + LINE);
                    }
                    System.out.println("What else do you want to do?");
                }
            }
            else{
                System.out.println(LINE);
                Item item = new Item(input, false);
                itemList.add(item);
                System.out.println("added: " + item.getName() + "\n" + LINE);
            }
            input = sc.nextLine();
        }
        System.out.println(LINE);
    }
}
