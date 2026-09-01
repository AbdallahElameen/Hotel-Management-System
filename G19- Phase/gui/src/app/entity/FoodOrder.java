package app.entity;

public class FoodOrder {

    private String itemName;
    private int quantity;
    private double unitPrice;

    // Negative quantity or price gets clamped to zero so bills stay sensible.
    public FoodOrder(int quantity, String itemName, double unitPrice) {
        this.itemName  = (itemName != null) ? itemName : "Unknown Item";
        this.quantity  = (quantity  > 0)    ? quantity  : 0;
        this.unitPrice = (unitPrice > 0)    ? unitPrice : 0.0;
    }

    public double calculateCost() {
        try {
            return unitPrice * quantity;
        } catch (Exception e) {
            System.out.println("[FoodOrder] Error calculating cost: " + e.getMessage());
            return 0.0;
        }
    }

    public double getPrice() {
        return calculateCost();
    }

    @Override
    public String toString() {
        return "FoodOrder{"
                + "itemName='"  + itemName  + '\''
                + ", quantity=" + quantity
                + ", unitPrice=$" + unitPrice
                + ", totalCost=$" + calculateCost()
                + '}';
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = (itemName != null) ? itemName : "Unknown Item";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = (quantity > 0) ? quantity : 0;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = (unitPrice > 0) ? unitPrice : 0.0;
    }
}
