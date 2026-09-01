package app.entity.room;

import app.exceptions.RoomAlreadyBooked;

public abstract class Room {

    private int roomNumber;
    private double pricePerNight;
    private boolean isBooked;
    private String features;

    public Room(int roomNumber, double pricePerNight, String features) {
        this.roomNumber    = roomNumber;
        this.pricePerNight = pricePerNight;
        this.features      = features;
        this.isBooked      = false;
    }

    // Throws RoomAlreadyBooked if someone tries to double-book the same room.
    public void bookRoom() {
        if (isBooked) {
            throw new RoomAlreadyBooked(
                "Room #" + roomNumber
                + " is already booked and cannot be reserved again."
            );
        }
        isBooked = true;
    }

    public void vacateRoom() {
        try {
            isBooked = false;
        } catch (Exception e) {
            System.out.println("[Room] Error vacating room #" + roomNumber
                    + ": " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Room #"          + roomNumber
                + " | Type: "   + getRoomType()
                + " | Price: $" + pricePerNight + "/night"
                + " | Booked: " + isBooked
                + " | "         + features;
    }

    // Each room subclass returns its own type label.
    public abstract String getRoomType();

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }
}
