package app.entity;

public class ServiceOrder {

    private String serviceName;
    private double servicePrice;
    private int quantity;

    // Negative quantity or price gets clamped to zero so bills stay sensible.
    public ServiceOrder(String serviceName, double servicePrice, int quantity) {
        this.serviceName  = (serviceName  != null) ? serviceName  : "Unknown Service";
        this.servicePrice = (servicePrice > 0)      ? servicePrice : 0.0;
        this.quantity     = (quantity     > 0)      ? quantity     : 0;
    }

    public double calculateCost() {
        try {
            return servicePrice * quantity;
        } catch (Exception e) {
            System.out.println("[ServiceOrder] Error calculating cost: " + e.getMessage());
            return 0.0;
        }
    }

    public double getPrice() {
        return calculateCost();
    }

    @Override
    public String toString() {
        return "ServiceOrder{"
                + "serviceName='"   + serviceName  + '\''
                + ", servicePrice=$" + servicePrice
                + ", quantity="      + quantity
                + ", totalCost=$"    + calculateCost()
                + '}';
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = (serviceName != null) ? serviceName : "Unknown Service";
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = (servicePrice > 0) ? servicePrice : 0.0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = (quantity > 0) ? quantity : 0;
    }
}
