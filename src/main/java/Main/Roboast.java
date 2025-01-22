package Main;

public class Roboast {
    private static final String BOT_NAME = "Roboast";
    private static final String LINE = "_".repeat(50);

    public static void main(String[] args) {
        printHello();
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

}
