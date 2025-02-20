package item;

public class Deadline extends Item{

    public Deadline(){
        super();
    }

    public Deadline(String name, boolean done){
        super(name, done);
        String newname = name.replace("/by","(by:");
        if (!name.equals(newname)){
            newname = newname + ")";
        }
        super.setName(newname);
    }

    @Override
    public String toString(){
        if (super.done){
            return "[D][X] " + super.name;
        }
        else{
            return "[D][ ] " + super.name;
        }
    }

}
