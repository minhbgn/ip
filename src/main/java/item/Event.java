package item;

public class Event extends Item{

    private String eventStartTime;
    private String eventEndTime;

    public Event() {
        super();
        super.itemType = "Event";
    }

    public Event(String name, boolean done) {
        super(name, done);
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

    @Override
    public String toString() {
        if (super.isDone){
            return "[E][X] " + super.itemName;
        }
        else{
            return "[E][ ] " + super.itemName;
        }
    }

    @Override
    public String toCSVString(){
        return super.toCSVString();
    }

}
