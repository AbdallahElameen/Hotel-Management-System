package app.entity;

import app.entity.interfaces.Billable;
import app.entity.room.Room;
import java.time.LocalDate;
import java.util.ArrayList;

public class Booking implements Billable {

    private long bookingId;
    private Client client;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfNights;
    private int numberOfGuests;
    private String specialRemarks;
    private ArrayList<FoodOrder> foodOrders;
    private ArrayList<ServiceOrder> serviceOrders;

    public Booking(long bookingId, Client client, Room room, int numberOfNights) {
        this.bookingId    = bookingId;
        this.client       = client;
        this.room         = room;
        this.numberOfNights = numberOfNights;
        this.numberOfGuests = 1;
        this.specialRemarks = "";
        this.checkInDate  = LocalDate.now();
        this.checkOutDate = checkInDate.plusDays(numberOfNights);
        this.foodOrders   = new ArrayList<>();
        this.serviceOrders = new ArrayList<>();
    }

    public Booking(long bookingId, Client client, Room room,
                   int numberOfNights, int numberOfGuests, String specialRemarks) {
        this(bookingId, client, room, numberOfNights);
        this.numberOfGuests = numberOfGuests;
        this.specialRemarks = (specialRemarks != null) ? specialRemarks : "";
    }

    public void addFoodOrder(FoodOrder order) {
        if (order != null) {
            foodOrders.add(order);
        }
    }

    public void addServiceOrder(ServiceOrder order) {
        if (order != null) {
            serviceOrders.add(order);
        }
    }

    @Override
    public double calculateBill() {
        return calculateRoomCost() + calculateFoodCost() + calculateServiceCost();
    }

    @Override
    public void printBill() {
        System.out.println(toString());
    }

    private double calculateRoomCost() {
        if (room == null) {
            return 0.0;
        }
        return room.getPricePerNight() * numberOfNights;
    }

    private double calculateFoodCost() {
        double total = 0.0;
        for (FoodOrder order : foodOrders) {
            if (order != null) {
                total += order.calculateCost();
            }
        }
        return total;
    }

    private double calculateServiceCost() {
        double total = 0.0;
        for (ServiceOrder order : serviceOrders) {
            if (order != null) {
                total += order.calculateCost();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "========== BOOKING DETAILS ==========\n"
                + "Booking ID      : " + bookingId + "\n"
                + "Client          : " + (client != null ? client.getName() : "N/A") + "\n"
                + "Room            : #" + (room != null ? room.getRoomNumber() : "N/A")
                + " (" + (room != null ? room.getRoomType() : "N/A") + ")\n"
                + "Check-in Date   : " + checkInDate + "\n"
                + "Check-out Date  : " + checkOutDate + "\n"
                + "Nights          : " + numberOfNights + "\n"
                + "Guests          : " + numberOfGuests + "\n"
                + "Special Remarks : " + (specialRemarks.isEmpty() ? "None" : specialRemarks) + "\n"
                + "Food Orders     : " + foodOrders.size() + "\n"
                + "Service Orders  : " + serviceOrders.size() + "\n"
                + "Room Cost       : $" + calculateRoomCost() + "\n"
                + "Food Cost       : $" + calculateFoodCost() + "\n"
                + "Service Cost    : $" + calculateServiceCost() + "\n"
                + "TOTAL BILL      : $" + calculateBill() + "\n"
                + "=====================================";
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
        if (checkInDate != null) {
            this.checkOutDate = checkInDate.plusDays(numberOfNights);
        }
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
        if (checkInDate != null) {
            this.checkOutDate = checkInDate.plusDays(numberOfNights);
        }
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getSpecialRemarks() {
        return specialRemarks;
    }

    public void setSpecialRemarks(String specialRemarks) {
        this.specialRemarks = (specialRemarks != null) ? specialRemarks : "";
    }

    public ArrayList<FoodOrder> getFoodOrders() {
        return foodOrders;
    }

    public void setFoodOrders(ArrayList<FoodOrder> foodOrders) {
        this.foodOrders = foodOrders;
    }

    public ArrayList<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(ArrayList<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
