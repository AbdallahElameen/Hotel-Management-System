package app.entity.room;

public class SuiteRoom extends Room {

    private static final double PRICE_PER_NIGHT = 300.0;
    private static final String FEATURES =
            "King bed, separate living room, free Wi-Fi, smart TV, "
            + "minibar, jacuzzi, balcony, premium toiletries";

    public SuiteRoom(int roomNumber) {
        super(roomNumber, PRICE_PER_NIGHT, FEATURES);
    }

    @Override
    public String getRoomType() {
        return "Suite";
    }
}
