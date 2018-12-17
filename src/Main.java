import java.util.concurrent.CopyOnWriteArrayList;


public class Main {
    private static int maxWeight;
    private static int maxValue;
    private static int allowedWeight = 9;
    private static String maxBackpack;

    public static void main(String[] args) {
        CopyOnWriteArrayList<Item> items = new CopyOnWriteArrayList<>();
        Backpack backpack = new Backpack();
        Item circle = new Item(7, 9, Item.type.Circle);
        Item triangle = new Item(3, 2, Item.type.Triangle);
        Item diamond = new Item(5, 6, Item.type.Diamond);
        Item square = new Item(4, 4, Item.type.Square);
        items.add(circle);
        items.add(triangle);
        items.add(diamond);
        items.add(square);
        packRecursivly(items, backpack);
        System.out.println("------------------");
        System.out.println("The best configuration is as follows:");
        System.out.println("Maxvalue:   " + maxValue);
        System.out.println("Maxweight:  " + maxWeight);
        System.out.println("Config:     " + maxBackpack);
    }

    private static void packRecursivly(CopyOnWriteArrayList<Item> items, Backpack backpack) {
        System.out.println(backpack.toString());
        if (items.size() == 0) {
            return;
        }
        for (Item i : items) {

            // Check if the backpack is already too heavy before adding more items.
            if (backpack.getWeight() > allowedWeight) {
                return;
            }
            backpack.addItem(i);
            items.remove(i);
            if (backpack.getWeight() <= allowedWeight) {
                // Weight is ok
                if (backpack.getValue() >= maxValue) {
                    maxValue = backpack.getValue();
                    maxWeight = backpack.getWeight();
                    maxBackpack = backpack.toString();
                    System.out.println("New maxValue: " + maxValue);
                }
            } else {
                System.out.println("Backpack is too heavy. Weight is " + backpack.getWeight());
            }
            packRecursivly(items, backpack);
            backpack.removeItem(i);
            items.add(i);
        }
    }
}
