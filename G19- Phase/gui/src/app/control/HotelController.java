package app.control;

import app.access.FileManager;
import app.entity.Booking;
import app.entity.Client;
import app.entity.FoodOrder;
import app.entity.Hotel;
import app.entity.ServiceOrder;
import app.entity.employee.Employee;
import app.entity.room.Room;
import app.exceptions.InvalidLoginException;

import java.util.ArrayList;

public class HotelController {

    private Hotel hotel;
    private FileManager fileManager;

    public HotelController(Hotel hotel, FileManager fileManager) {
        this.hotel       = hotel;
        this.fileManager = fileManager;
    }

    // Throws InvalidLoginException if the ID, password, or expected role don't match.
    public Employee authenticateEmployee(int employeeId, String password, String expectedRole)
            throws InvalidLoginException {

        Employee employee = findEmployeeById(employeeId);

        if (employee == null) {
            throw new InvalidLoginException(
                "No employee found with ID: " + employeeId);
        }

        if (!employee.getPassword().equals(password)) {
            throw new InvalidLoginException(
                "Incorrect password for employee ID: " + employeeId);
        }

        if (!employee.getRole().equalsIgnoreCase(expectedRole)) {
            throw new InvalidLoginException(
                "Employee #" + employeeId + " does not have the role: " + expectedRole);
        }

        return employee;
    }

    public Client authenticateClient(int clientId, String password)
            throws InvalidLoginException {

        Client client = findClientById(clientId);

        if (client == null) {
            throw new InvalidLoginException(
                "No client found with ID: " + clientId);
        }

        if (!client.getPassword().equals(password)) {
            throw new InvalidLoginException(
                "Incorrect password for client ID: " + clientId);
        }

        return client;
    }

    // Re-attaches every loaded employee to this controller after a load from disk.
    public void connectEmployeesToController() {
        if (hotel == null || hotel.getEmployees() == null) {
            return;
        }
        for (Employee emp : hotel.getEmployees()) {
            if (emp != null) {
                emp.setHotelController(this);
            }
        }
    }

    public void addClient(Client client) {
        if (hotel == null || client == null) {
            return;
        }
        hotel.addClient(client);
    }

    public void updateClient(int clientId, String newName, String newPhone, String newEmail) {
        Client client = findClientById(clientId);
        if (client == null) {
            System.out.println("Client #" + clientId + " not found.");
            return;
        }
        client.manageAccount(newName, newPhone, newEmail);
    }

    public ArrayList<Booking> viewClientBookings(int clientId) {
        ArrayList<Booking> clientBookings = new ArrayList<>();

        if (hotel == null || hotel.getBookings() == null) {
            return clientBookings;
        }

        for (Booking booking : hotel.getBookings()) {
            if (booking != null
                    && booking.getClient() != null
                    && booking.getClient().getClientId() == clientId) {
                clientBookings.add(booking);
            }
        }

        if (clientBookings.isEmpty()) {
            System.out.println("No bookings found for client #" + clientId + ".");
        } else {
            System.out.println("===== Bookings for Client #" + clientId + " =====");
            for (Booking booking : clientBookings) {
                System.out.println(booking);
            }
        }

        return clientBookings;
    }

    public void addEmployee(Employee employee) {
        if (hotel == null || employee == null) {
            return;
        }
        hotel.addEmployee(employee);
    }

    public void removeEmployee(int employeeId) {
        if (hotel == null || hotel.getEmployees() == null) {
            System.out.println("Cannot remove employee: hotel data is unavailable.");
            return;
        }

        Employee target = findEmployeeById(employeeId);
        if (target == null) {
            System.out.println("Employee #" + employeeId + " not found.");
            return;
        }

        hotel.removeEmployee(employeeId);
        System.out.println("Employee #" + employeeId
                + " (" + target.getName() + ") removed successfully.");
    }

    // Empty/zero values mean "leave this field alone".
    public void updateEmployee(int employeeId, String newName, double newSalary) {
        Employee employee = findEmployeeById(employeeId);
        if (employee == null) {
            System.out.println("Employee #" + employeeId + " not found.");
            return;
        }

        if (newName != null && !newName.isEmpty()) {
            employee.setName(newName);
        }

        if (newSalary > 0) {
            employee.setSalary(newSalary);
        }

        System.out.println("Employee #" + employeeId + " updated: name="
                + employee.getName() + ", salary=" + employee.getSalary());
    }

    public void addRoom(Room room) {
        if (hotel == null || room == null) {
            return;
        }
        hotel.addRoom(room);
    }

    public void manageRoomAvailability(int roomNumber, boolean setBooked) {
        Room room = findRoomByNumber(roomNumber);
        if (room == null) {
            System.out.println("Room #" + roomNumber + " not found.");
            return;
        }

        room.setIsBooked(setBooked);
        String status = setBooked ? "BOOKED" : "AVAILABLE";
        System.out.println("Room #" + roomNumber + " marked as " + status + ".");
    }

    // Convenience overload - one guest, no remarks.
    public Booking bookRoom(int clientId, int roomNumber, int nights) {
        return bookRoom(clientId, roomNumber, nights, 1, "");
    }

    public Booking bookRoom(int clientId, int roomNumber, int nights,
                            int numberOfGuests, String specialRemarks) {
        if (hotel == null || nights <= 0) {
            return null;
        }

        Client client = findClientById(clientId);
        Room   room   = findRoomByNumber(roomNumber);

        if (client == null || room == null || room.getIsBooked()) {
            return null;
        }

        long newId      = generateNextBookingId();
        Booking booking = new Booking(newId, client, room,
                nights, numberOfGuests, specialRemarks);

        hotel.addBooking(booking);
        client.addBooking(booking);
        room.bookRoom();
        return booking;
    }

    // Pass -1 for nights/guests or null for remarks to leave that field alone.
    public void updateBooking(long bookingId, int newNights,
                              int newGuests, String newRemarks) {
        Booking booking = findBookingById(bookingId);
        if (booking == null) {
            System.out.println("Booking #" + bookingId + " not found.");
            return;
        }

        if (newNights > 0) {
            booking.setNumberOfNights(newNights);
        }

        if (newGuests > 0) {
            booking.setNumberOfGuests(newGuests);
        }

        if (newRemarks != null) {
            booking.setSpecialRemarks(newRemarks);
        }

        System.out.println("Booking #" + bookingId + " updated successfully.");
    }

    public void cancelBooking(long bookingId) {
        if (hotel == null) {
            return;
        }

        Booking booking = findBookingById(bookingId);
        if (booking == null) {
            return;
        }

        Room room = booking.getRoom();
        if (room != null) {
            room.vacateRoom();
        }

        hotel.removeBooking(bookingId);
        System.out.println("Booking #" + bookingId + " cancelled.");
    }

    public void orderFood(long bookingId, FoodOrder order) {
        if (order == null) {
            return;
        }
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            booking.addFoodOrder(order);
        }
    }

    public void orderService(long bookingId, ServiceOrder order) {
        if (order == null) {
            return;
        }
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            booking.addServiceOrder(order);
        }
    }

    public double calculateBill(long bookingId) {
        Booking booking = findBookingById(bookingId);
        if (booking == null) {
            return 0.0;
        }
        return booking.calculateBill();
    }

    public void displayBill(long bookingId) {
        Booking booking = findBookingById(bookingId);
        if (booking == null) {
            System.out.println("Booking #" + bookingId + " not found.");
            return;
        }
        booking.printBill();
    }

    public Client findClientById(int clientId) {
        if (hotel == null || hotel.getClients() == null) {
            return null;
        }
        for (Client client : hotel.getClients()) {
            if (client != null && client.getClientId() == clientId) {
                return client;
            }
        }
        return null;
    }

    public Room findRoomByNumber(int roomNumber) {
        if (hotel == null || hotel.getRooms() == null) {
            return null;
        }
        for (Room room : hotel.getRooms()) {
            if (room != null && room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public Booking findBookingById(long bookingId) {
        if (hotel == null || hotel.getBookings() == null) {
            return null;
        }
        for (Booking booking : hotel.getBookings()) {
            if (booking != null && booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        return null;
    }

    public Employee findEmployeeById(int employeeId) {
        if (hotel == null || hotel.getEmployees() == null) {
            return null;
        }
        for (Employee employee : hotel.getEmployees()) {
            if (employee != null && employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public void saveData() {
        if (fileManager == null) {
            System.out.println("FileManager is not available.");
            return;
        }
        fileManager.saveHotel(hotel);
    }

    // Loads a fresh hotel from disk and re-wires every employee back to this controller.
    public void loadData() {
        if (fileManager == null) {
            System.out.println("FileManager is not available.");
            return;
        }

        Hotel loaded = fileManager.loadHotel();
        if (loaded != null) {
            this.hotel = loaded;
            connectEmployeesToController();
        }
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    private long generateNextBookingId() {
        if (hotel == null
                || hotel.getBookings() == null
                || hotel.getBookings().isEmpty()) {
            return 1L;
        }

        long maxId = 0L;
        for (Booking booking : hotel.getBookings()) {
            if (booking != null && booking.getBookingId() > maxId) {
                maxId = booking.getBookingId();
            }
        }
        return maxId + 1L;
    }
}
