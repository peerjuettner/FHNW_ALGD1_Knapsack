import java.util.ArrayList;

public class Backpack {
    private ArrayList<Item> items;
    private int weight, value;

    public Backpack() {
        this.items = new ArrayList<>();
        this.weight = 0;
        this.value = 0;
    }

    public void addItem(Item item) {
        this.weight += item.getWeight();
        this.value += item.getValue();
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.weight -= item.getWeight();
        this.value -= item.getValue();
        this.items.remove(item);
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {

        String sItems = "";
        for (Item i : items) {
            sItems += " " + i.getType() + ", ";
        }
        return "Backpack contains: " + sItems;
    }
}
