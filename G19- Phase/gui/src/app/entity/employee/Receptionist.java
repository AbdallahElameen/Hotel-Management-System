package app.entity.employee;

import app.entity.Booking;
import app.entity.Client;
import app.entity.room.Room;
import app.exceptions.InvalidBookingException;
import java.util.ArrayList;

public class Receptionist extends Employee {

    private final ArrayList<Client> registeredClients;
    private final ArrayList<Booking> createdBookings;

    public Receptionist(int employeeId, String name, double salary) {
        super(employeeId, name, salary, "Receptionist");
        this.registeredClients = new ArrayList<>();
        this.createdBookings   = new ArrayList<>();
    }

    @Override
    public void performDuty() {
        System.out.println("Receptionist " + getName() + " is assisting guests at the front desk.");
    }

    public void registerClient(Client client) {
        try {
            if (client == null) {
                System.out.println("Cannot register a null client.");
                return;
            }
            if (hotelController == null) {
                System.out.println("Cannot register client: receptionist is not connected to the system.");
                return;
            }
            if (hotelController.findClientById(client.getClientId()) != null) {
                System.out.println("Client #" + client.getClientId() + " is already registered.");
                return;
            }
            hotelController.addClient(client);
            if (!isClientTracked(client.getClientId())) {
                registeredClients.add(client);
            }
            System.out.println("Client registered by Receptionist " + getName() + ": " + client);
        } catch (Exception e) {
            System.out.println("Error registering client: " + e.getMessage());
        }
    }

    // Convenience overload that defaults to one guest and no remarks.
    public Booking createBooking(Client client, Room room, int numberOfNights) {
        return createBooking(client, room, numberOfNights, 1, "");
    }

    public Booking createBooking(Client client, Room room, int numberOfNights,
                                 int numberOfGuests, String specialRemarks) {
        try {
            if (client == null || room == null || numberOfNights <= 0) {
                System.out.println("Invalid booking request: missing client, room, or nights.");
                return null;
            }
            if (hotelController == null) {
                System.out.println("Cannot create booking: receptionist is not connected to the system.");
                return null;
            }

            if (hotelController.findClientById(client.getClientId()) == null) {
                hotelController.addClient(client);
                if (!isClientTracked(client.getClientId())) {
                    registeredClients.add(client);
                }
            }

            if (hotelController.findRoomByNumber(room.getRoomNumber()) == null) {
                hotelController.addRoom(room);
            }

            Booking booking = hotelController.bookRoom(
                    client.getClientId(),
                    room.getRoomNumber(),
                    numberOfNights,
                    numberOfGuests,
                    specialRemarks
            );

            if (booking == null) {
                System.out.println("Booking failed: room #"
                        + room.getRoomNumber() + " may already be booked.");
                return null;
            }

            createdBookings.add(booking);
            System.out.println("Booking created by Receptionist " + getName() + ":");
            System.out.println(booking);
            return booking;

        } catch (Exception e) {
            System.out.println("Error creating booking: " + e.getMessage());
            return null;
        }
    }

    // Stricter version used by the console tests - throws on bad input so the
    // caller is forced to handle the failure explicitly.
    public Booking createBookingChecked(Client client, Room room, int numberOfNights,
                                        int numberOfGuests, String specialRemarks)
            throws InvalidBookingException {

        if (client == null) {
            throw new InvalidBookingException(
                "Cannot create booking: client must not be null.");
        }
        if (room == null) {
            throw new InvalidBookingException(
                "Cannot create booking: room must not be null.");
        }
        if (numberOfNights <= 0) {
            throw new InvalidBookingException(
                "Cannot create booking: number of nights must be greater than zero. "
                + "Provided: " + numberOfNights);
        }
        if (numberOfGuests <= 0) {
            throw new InvalidBookingException(
                "Cannot create booking: number of guests must be at least one. "
                + "Provided: " + numberOfGuests);
        }
        if (hotelController == null) {
            throw new InvalidBookingException(
                "Cannot create booking: receptionist is not connected to the system.");
        }

        Booking booking = createBooking(client, room, numberOfNights, numberOfGuests, specialRemarks);
        if (booking == null) {
            throw new InvalidBookingException(
                "Booking creation failed: room #" + room.getRoomNumber()
                + " may already be booked.");
        }
        return booking;
    }

    public void cancelBooking(long bookingId) {
        try {
            if (hotelController == null) {
                System.out.println("Cannot cancel booking: receptionist is not connected to the system.");
                return;
            }
            if (hotelController.findBookingById(bookingId) == null) {
                System.out.println("Booking #" + bookingId + " was not found.");
                return;
            }
            hotelController.cancelBooking(bookingId);
            createdBookings.removeIf(b -> b != null && b.getBookingId() == bookingId);
            System.out.println("Booking #" + bookingId
                    + " cancelled by Receptionist " + getName() + ".");
        } catch (Exception e) {
            System.out.println("Error cancelling booking: " + e.getMessage());
        }
    }

    // Pass -1 for nights/guests or null for remarks to leave that field alone.
    public void updateBooking(long bookingId, int newNights,
                              int newGuests, String newRemarks) {
        try {
            if (hotelController == null) {
                System.out.println("Cannot update booking: receptionist is not connected to the system.");
                return;
            }
            hotelController.updateBooking(bookingId, newNights, newGuests, newRemarks);
            System.out.println("Booking #" + bookingId
                    + " update processed by Receptionist " + getName() + ".");
        } catch (Exception e) {
            System.out.println("Error updating booking: " + e.getMessage());
        }
    }

    public void viewClientBookings(int clientId) {
        try {
            if (hotelController == null) {
                System.out.println("Cannot view bookings: receptionist is not connected to the system.");
                return;
            }
            System.out.println("Bookings requested by Receptionist "
                    + getName() + " for client #" + clientId + ":");
            hotelController.viewClientBookings(clientId);
        } catch (Exception e) {
            System.out.println("Error viewing client bookings: " + e.getMessage());
        }
    }

    public ArrayList<Booking> getCreatedBookings() {
        return new ArrayList<>(createdBookings);
    }

    public ArrayList<Client> getRegisteredClients() {
        return new ArrayList<>(registeredClients);
    }

    private boolean isClientTracked(int clientId) {
        for (Client c : registeredClients) {
            if (c != null && c.getClientId() == clientId) {
                return true;
            }
        }
        return false;
    }
}
