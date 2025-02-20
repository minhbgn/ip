package item;

public class Deadline extends Item{

    private String deadline;

    public Deadline(){
        super();
    }

    public Deadline(String name, boolean done){
        super(name, done);
        String newname = name.replace("/by","(by:");
        int byIndex = newname.indexOf("(by:");
        deadline = newname.substring(byIndex+5,newname.length()-1);
        if (!name.equals(newname)){
            newname = newname + ")";
        }
        super.setItemName(newname);
    }

    @Override
    public String toString(){
        if (super.isDone){
            return "[D][X] " + super.itemName;
        }
        else{
            return "[D][ ] " + super.itemName;
        }
    }

}
