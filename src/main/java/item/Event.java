package item;

public class Event extends Item{

    public Event() {
        super();
    }

    public Event(String name, boolean done) {
        super(name, done);
        String newname;
        newname = name.replace("/from","(from:")
                      .replace("/to","to:");
        if (!newname.equals(name)){
            newname = newname + ")";
        }
        super.setItemName(newname);
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

}
