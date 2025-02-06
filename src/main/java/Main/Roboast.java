package Main;
import java.util.Scanner;

public class Roboast {
    private static final String BOT_NAME = "Roboast";
    private static final String LINE = "_".repeat(50);

    public static void main(String[] args) {
        printHello();
        echo();
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
        String echo;
        Scanner sc = new Scanner(System.in);
        echo = sc.nextLine();
        while (!echo.equals("bye")){
            System.out.println("REPEATING COMMANDS: ");
            System.out.println(LINE + "\n" + echo + "\n" + LINE);
            echo = sc.nextLine();
        }
        System.out.println(LINE);
    }
}
