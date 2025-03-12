package item;

/**
 * A parent class, used to hold all items in the item list using polymorphism
 */
public class Item {
    protected String itemName;
    protected boolean isDone;
    protected String itemType = "Item";

    /**
     * Initializer for Item
     * @param name the name of the item
     * @param isDone True if the user has finished/marked the item, False if the user has
     *               not finished/not marked/unmarked the item
     */
    public Item(String name, boolean isDone) {
        this.itemName = name;
        this.isDone = isDone;
    }

    /**
     *
     * @return the Item's name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Set the Item's name
     * @param itemName the Item's name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     *
     * @return True if the Item has been finished/marked, False if it has not been finished/not marked/unmarked
     *
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Used to mark/unmark the Item
     * @param done True to mark the Item, False to unmark the Item
     */
    public void setDone(boolean done) {
        this.isDone = done;
    }

    /**
     * For printing usages
     * @return isDone attribute as crosses and the name of the Item
     */
    @Override
    public String toString() {
        if (isDone){
            return "[X] " + itemName;
        }
        else{
            return "[ ] " + itemName;
        }
    }

    /**
     * Serialize the Item to save into CSV files
     * @return item types, item name, and if the Item is done
     */
    public String toCSVString(){
        return itemType + "," + itemName + "," + isDone;
    }

    /**
     * Hydrate (Load) the Item to parse into Item List from the CSV file
     * @param csvLine Serialized information that was saved into the CSV File
     * @return the new Item loaded
     */
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
