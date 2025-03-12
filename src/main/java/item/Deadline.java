package item;

/**
 * This class holds Deadlines
 */
public class Deadline extends Item{

    private String deadline;

    /**
     * Initializer for Deadline items
     * @param name name of the Deadline
     * @param isDone True if the Deadline is done/passed, False otherwise
     */
    public Deadline(String name, boolean isDone){
        super(name, isDone);
        String newname = name.replace("/by","(by:");
        int byIndex = newname.indexOf("(by:");

        try {
            deadline = newname.substring(byIndex + 5, newname.length() - 1);
        }
        catch (StringIndexOutOfBoundsException e) {
            deadline = null;
        }


        if (!name.equals(newname)){
            newname = newname + ")";
        }
        super.setItemName(newname);
        super.itemType = "Deadline";
    }

    /**
     * For printing purposes
     * @return the String that gets printed
     */
    @Override
    public String toString(){
        if (super.isDone){
            return "[D][X] " + super.itemName;
        }
        else{
            return "[D][ ] " + super.itemName;
        }
    }

    /**
     * Serialize the Item. This function is used for polymorphism
     * @return The serialized Item in CSV format to save into CSV file
     */
    @Override
    public String toCSVString(){
        return super.toCSVString();
    }

}
