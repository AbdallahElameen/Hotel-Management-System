package app.entity.room;

public class StandardRoom extends Room {

    private static final double PRICE_PER_NIGHT = 100.0;
    private static final String FEATURES =
            "Queen bed, free Wi-Fi, air conditioning, TV, private bathroom";

    public StandardRoom(int roomNumber) {
        super(roomNumber, PRICE_PER_NIGHT, FEATURES);
    }

    @Override
    public String getRoomType() {
        return "Standard";
    }
}
