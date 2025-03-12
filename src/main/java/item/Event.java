package item;

/**
 * Used to hold Events
 */
public class Event extends Item{

    private String eventStartTime;
    private String eventEndTime;

    /**
     * Initializer for Events
     * @param name name of the Event
     * @param isDone True if the Event has finished, False otherwise
     */
    public Event(String name, boolean isDone) {
        super(name, isDone);
        String newname;
        newname = name.replace("/from","(from:")
                      .replace("/to","to:");

        try {
            eventStartTime = newname.substring(newname.indexOf("(from:") + 6, newname.indexOf("to:") - 1);
            eventEndTime = newname.substring(newname.indexOf("to:") + 4);;
        }
        catch (StringIndexOutOfBoundsException e) {
            eventStartTime = null;
            eventEndTime = null;
        }

        if (!newname.equals(name)){
            newname = newname + ")";
        }
        super.setItemName(newname);
        super.itemType = "Event";
    }

    /**
     * For printing purposes
     * @return The printing string
     */
    @Override
    public String toString() {
        if (super.isDone){
            return "[E][X] " + super.itemName;
        }
        else{
            return "[E][ ] " + super.itemName;
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
