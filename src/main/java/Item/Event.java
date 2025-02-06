package Item;

public class Event extends Item{

    public Event(){
        super();
    }

    public Event(String name, boolean done){
        super(name, done);
        String newname;
        newname = name.replace("/from","(from:")
                      .replace("/to","to:");
        if (!newname.equals(name)){
            newname = newname + ")";
        }
        super.setName(newname);
    }

    @Override
    public String toString(){
        if (super.done){
            return "[E][X] " + super.name;
        }
        else{
            return "[E][ ] " + super.name;
        }
    }

}
