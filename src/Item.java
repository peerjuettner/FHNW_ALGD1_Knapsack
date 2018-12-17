public class Item {
    private int weight;
    private int value;
    private Item.type type;

    public enum type {Circle, Triangle, Diamond, Square}

    public Item(int weight, int value, type type) {
        this.weight = weight;
        this.value = value;
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }


    public int getValue() {
        return value;
    }

    public String getType() {
        return this.type.toString();
    }

}
