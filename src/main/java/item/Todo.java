package item;

public class Todo extends Item{

    public Todo(){
        super();
        super.itemType = "Todo";
    }

    public Todo(String name, boolean done){
        super(name, done);
        super.itemType = "Todo";
    }

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
