package item;

/**
 * To-do object. Handle tasks for the to-do list.
 */
public class Todo extends Item{

    /**
     * Filled initializer for Todo
     * @param name The name of the task
     * @param isDone True if the user has finished/marked the task, False if the user has not finished/unmarked the task
     */
    public Todo(String name, boolean isDone){
        super(name, isDone);
        super.itemType = "Todo";
    }

    /**
     * Function for printing purposes
     */
    @Override
    public String toString(){
        if (super.isDone){
            return "[T][X] " + super.itemName;
        }
        else{
            return "[T][ ] " + super.itemName;
        }
    }

}
