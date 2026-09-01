package app.entity.room;

public class DeluxeRoom extends Room {

    private static final double PRICE_PER_NIGHT = 180.0;
    private static final String FEATURES =
            "King bed, free Wi-Fi, air conditioning, smart TV, "
            + "minibar, city view, premium toiletries";

    public DeluxeRoom(int roomNumber) {
        super(roomNumber, PRICE_PER_NIGHT, FEATURES);
    }

    @Override
    public String getRoomType() {
        return "Deluxe";
    }
}
