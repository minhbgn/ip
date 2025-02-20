package item;

public class Item {
    protected String name;
    protected boolean done;

    public Item(){
        name = "NO NAME";
        done = false;
    }

    public Item(String name, boolean done) {
        this.name = name;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        if (done){
            return "[X] " + name;
        }
        else{
            return "[ ] " + name;
        }
    }
}
