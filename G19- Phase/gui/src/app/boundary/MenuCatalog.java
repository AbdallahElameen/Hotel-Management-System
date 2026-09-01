package app.boundary;

import java.util.ArrayList;
import java.util.List;

// In-memory food and service menus. The Manager edits prices here; clients and
// service staff just pick an item and a quantity.
public final class MenuCatalog {

    public static final class Item {
        public String name;
        public double price;
        public Item(String name, double price) {
            this.name  = name;
            this.price = price;
        }
    }

    private static final List<Item> FOOD_ITEMS    = new ArrayList<>();
    private static final List<Item> SERVICE_ITEMS = new ArrayList<>();

    static {
        FOOD_ITEMS.add(new Item("Continental Breakfast", 12.00));
        FOOD_ITEMS.add(new Item("Club Sandwich",         14.50));
        FOOD_ITEMS.add(new Item("Caesar Salad",          11.00));
        FOOD_ITEMS.add(new Item("Margherita Pizza",      16.00));
        FOOD_ITEMS.add(new Item("Grilled Salmon",        24.00));
        FOOD_ITEMS.add(new Item("Chocolate Cake",         8.00));
        FOOD_ITEMS.add(new Item("Bottled Water",          3.00));
        FOOD_ITEMS.add(new Item("Fresh Juice",            5.50));

        SERVICE_ITEMS.add(new Item("Laundry",            20.00));
        SERVICE_ITEMS.add(new Item("Spa Session",        65.00));
        SERVICE_ITEMS.add(new Item("Room Cleaning",      15.00));
        SERVICE_ITEMS.add(new Item("Taxi Booking",       25.00));
        SERVICE_ITEMS.add(new Item("Airport Transfer",   45.00));
        SERVICE_ITEMS.add(new Item("Late Checkout",      30.00));
        SERVICE_ITEMS.add(new Item("Mini-bar Refill",    12.00));
    }

    private MenuCatalog() { }

    public static List<Item> getFoodItems()    { return FOOD_ITEMS; }
    public static List<Item> getServiceItems() { return SERVICE_ITEMS; }

    public static void setFoodPrice(int index, double price) {
        if (index >= 0 && index < FOOD_ITEMS.size() && price >= 0) {
            FOOD_ITEMS.get(index).price = price;
        }
    }

    public static void setServicePrice(int index, double price) {
        if (index >= 0 && index < SERVICE_ITEMS.size() && price >= 0) {
            SERVICE_ITEMS.get(index).price = price;
        }
    }
}
