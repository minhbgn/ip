package item;

public class Todo extends Item{

    public Todo(){

    }

    public Todo(String name, boolean done){
        super(name, done);
    }

    @Override
    public String toString(){
        if (super.done){
            return "[T][X] " + super.name;
        }
        else{
            return "[T][ ] " + super.name;
        }
    }

}
