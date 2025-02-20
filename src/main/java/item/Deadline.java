package item;

public class Deadline extends Item{

    private String deadline;

    public Deadline(){

        super();
        super.itemType = "Deadline";
    }

    public Deadline(String name, boolean done){
        super(name, done);
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

    @Override
    public String toString(){
        if (super.isDone){
            return "[D][X] " + super.itemName;
        }
        else{
            return "[D][ ] " + super.itemName;
        }
    }

    @Override
    public String toCSVString(){
        return super.toCSVString();
    }

}
