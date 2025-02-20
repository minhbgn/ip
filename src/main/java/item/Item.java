package item;

public class Item {
    protected String itemName;
    protected boolean isDone;

    public Item(){
        itemName = "NO NAME";
        isDone = false;
    }

    public Item(String name, boolean isDone) {
        this.itemName = name;
        this.isDone = isDone;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    @Override
    public String toString() {
        if (isDone){
            return "[X] " + itemName;
        }
        else{
            return "[ ] " + itemName;
        }
    }
}
