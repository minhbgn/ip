package item;

public class Item {
    protected String itemName;
    protected boolean isDone;
    protected String itemType = "Item";

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

    public String toCSVString(){
        return itemType + "," + itemName + "," + isDone;
    }

    public static Item fromCSVString(String csvLine) {
        String[] parts = csvLine.split(",");
        switch (parts[0]){
            case "Item":
                return new Item(parts[1], Boolean.parseBoolean(parts[2]));
            case "Todo":
                return new Todo(parts[1], Boolean.parseBoolean(parts[2]));
            case "Deadline":
                return new Deadline(parts[1], Boolean.parseBoolean(parts[2]));
            case "Event":
                return new Event(parts[1], Boolean.parseBoolean(parts[2]));
            default:
                System.out.println("I don't understand this item type");
                return null;
        }

    }
}
