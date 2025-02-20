package item;

public class Todo extends Item{

    public Todo(){

    }

    public Todo(String name, boolean done){
        super(name, done);
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
