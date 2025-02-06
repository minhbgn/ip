package Item;

public class Item {
    private String name;
    private boolean done;

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

    public void mark(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        if (done){
            return "[X]" + name;
        }
        else{
            return "[ ]" + name;
        }
    }
}
