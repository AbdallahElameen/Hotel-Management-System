package app.access;

import app.entity.Booking;
import app.entity.Client;
import app.entity.FoodOrder;
import app.entity.Hotel;
import app.entity.ServiceOrder;
import app.entity.employee.Employee;
import app.entity.employee.Manager;
import app.entity.employee.Receptionist;
import app.entity.employee.ServiceStaff;
import app.entity.room.DeluxeRoom;
import app.entity.room.Room;
import app.entity.room.StandardRoom;
import app.entity.room.SuiteRoom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileManager {

    private static final String DATA_DIR = "data";

    private static final String ROOMS_FILE    = DATA_DIR + File.separator + "rooms.txt";
    private static final String CLIENTS_FILE  = DATA_DIR + File.separator + "clients.txt";
    private static final String EMPLOYEES_FILE= DATA_DIR + File.separator + "employees.txt";
    private static final String BOOKINGS_FILE = DATA_DIR + File.separator + "bookings.txt";
    private static final String FOOD_FILE     = DATA_DIR + File.separator + "foodorders.txt";
    private static final String SERVICE_FILE  = DATA_DIR + File.separator + "serviceorders.txt";
    private static final String HOTEL_FILE    = DATA_DIR + File.separator + "hotel.txt";

    // Pipe is used as the field separator so commas inside names/remarks don't break parsing.
    private static final String SEP = "|";

    private String fileName;

    public FileManager() {
        this.fileName = "hotel_data";
    }

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public void saveHotel(Hotel hotel) {
        if (hotel == null) {
            System.out.println("[FileManager] Cannot save: hotel is null.");
            return;
        }

        File dir = new File(DATA_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        saveHotelName(hotel.getHotelName());
        saveRooms(hotel.getRooms());
        saveClients(hotel.getClients());
        saveEmployees(hotel.getEmployees());
        saveBookings(hotel.getBookings());
        saveFoodOrders(hotel.getBookings());
        saveServiceOrders(hotel.getBookings());

        System.out.println("[FileManager] Hotel data saved successfully to '" + DATA_DIR + "'.");
    }

    private void saveHotelName(String hotelName) {
        try (PrintWriter writer = new PrintWriter(HOTEL_FILE)) {
            writer.println(hotelName);
        } catch (IOException e) {
            System.out.println("[FileManager] Error saving hotel name: " + e.getMessage());
        }
    }

    // Format per line: roomNumber|roomType|isBooked
    private void saveRooms(ArrayList<Room> rooms) {
        if (rooms == null) {
            return;
        }

        try (PrintWriter writer = new PrintWriter(ROOMS_FILE)) {
            for (Room room : rooms) {
                if (room != null) {
                    writer.println(room.getRoomNumber() + SEP
                            + room.getRoomType() + SEP
                            + room.getIsBooked());
                }
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error saving rooms: " + e.getMessage());
        }
    }

    // Format per line: clientId|name|phone|email|password
    private void saveClients(ArrayList<Client> clients) {
        if (clients == null) {
            return;
        }

        try (PrintWriter writer = new PrintWriter(CLIENTS_FILE)) {
            for (Client client : clients) {
                if (client != null) {
                    writer.println(client.getClientId() + SEP
                            + client.getName()     + SEP
                            + client.getPhone()    + SEP
                            + client.getEmail()    + SEP
                            + client.getPassword());
                }
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error saving clients: " + e.getMessage());
        }
    }

    // Format per line: employeeId|name|role|salary|password
    private void saveEmployees(ArrayList<Employee> employees) {
        if (employees == null) {
            return;
        }

        try (PrintWriter writer = new PrintWriter(EMPLOYEES_FILE)) {
            for (Employee emp : employees) {
                if (emp != null) {
                    writer.println(emp.getEmployeeId() + SEP
                            + emp.getName()     + SEP
                            + emp.getRole()     + SEP
                            + emp.getSalary()   + SEP
                            + emp.getPassword());
                }
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error saving employees: " + e.getMessage());
        }
    }

    // Format per line: bookingId|clientId|roomNumber|nights|guests|remarks|checkInDate
    private void saveBookings(ArrayList<Booking> bookings) {
        if (bookings == null) {
            return;
        }

        try (PrintWriter writer = new PrintWriter(BOOKINGS_FILE)) {
            for (Booking booking : bookings) {
                if (booking != null && booking.getClient() != null
                        && booking.getRoom() != null) {
                    writer.println(booking.getBookingId()           + SEP
                            + booking.getClient().getClientId()     + SEP
                            + booking.getRoom().getRoomNumber()     + SEP
                            + booking.getNumberOfNights()           + SEP
                            + booking.getNumberOfGuests()           + SEP
                            + booking.getSpecialRemarks()           + SEP
                            + booking.getCheckInDate());
                }
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error saving bookings: " + e.getMessage());
        }
    }

    // Format per line: bookingId|quantity|itemName|unitPrice
    private void saveFoodOrders(ArrayList<Booking> bookings) {
        if (bookings == null) {
            return;
        }

        try (PrintWriter writer = new PrintWriter(FOOD_FILE)) {
            for (Booking booking : bookings) {
                if (booking == null || booking.getFoodOrders() == null) {
                    continue;
                }
                for (FoodOrder order : booking.getFoodOrders()) {
                    if (order != null) {
                        writer.println(booking.getBookingId() + SEP
                                + order.getQuantity()  + SEP
                                + order.getItemName()  + SEP
                                + order.getUnitPrice());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error saving food orders: " + e.getMessage());
        }
    }

    // Format per line: bookingId|serviceName|servicePrice|quantity
    private void saveServiceOrders(ArrayList<Booking> bookings) {
        if (bookings == null) {
            return;
        }

        try (PrintWriter writer = new PrintWriter(SERVICE_FILE)) {
            for (Booking booking : bookings) {
                if (booking == null || booking.getServiceOrders() == null) {
                    continue;
                }
                for (ServiceOrder order : booking.getServiceOrders()) {
                    if (order != null) {
                        writer.println(booking.getBookingId() + SEP
                                + order.getServiceName()  + SEP
                                + order.getServicePrice() + SEP
                                + order.getQuantity());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error saving service orders: " + e.getMessage());
        }
    }

    // Returns null if there's no saved data on disk yet (first run).
    // Order matters: rooms and clients must be loaded before bookings, since
    // bookings reference them by ID.
    public Hotel loadHotel() {
        File hotelFile = new File(HOTEL_FILE);
        if (!hotelFile.exists()) {
            System.out.println("[FileManager] No saved data found. Starting fresh.");
            return null;
        }

        String hotelName = loadHotelName();
        if (hotelName == null) {
            return null;
        }

        Hotel hotel = new Hotel(hotelName);

        loadRooms(hotel);
        loadClients(hotel);
        loadEmployees(hotel);
        loadBookings(hotel);
        loadFoodOrders(hotel);
        loadServiceOrders(hotel);

        System.out.println("[FileManager] Hotel data loaded successfully.");
        return hotel;
    }

    private String loadHotelName() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HOTEL_FILE))) {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("[FileManager] Error loading hotel name: " + e.getMessage());
            return null;
        }
    }

    private void loadRooms(Hotel hotel) {
        File file = new File(ROOMS_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ROOMS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\" + SEP, -1);
                if (parts.length < 3) {
                    continue;
                }

                int    roomNumber = Integer.parseInt(parts[0].trim());
                String roomType   = parts[1].trim();
                boolean isBooked  = Boolean.parseBoolean(parts[2].trim());

                // Pick the right Room subclass based on the saved type label.
                Room room;
                switch (roomType) {
                    case "Deluxe":
                        room = new DeluxeRoom(roomNumber);
                        break;
                    case "Suite":
                        room = new SuiteRoom(roomNumber);
                        break;
                    default:
                        room = new StandardRoom(roomNumber);
                        break;
                }

                room.setIsBooked(isBooked);
                hotel.addRoom(room);
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error loading rooms: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("[FileManager] Invalid room data format: " + e.getMessage());
        }
    }

    private void loadClients(Hotel hotel) {
        File file = new File(CLIENTS_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(CLIENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\" + SEP, -1);
                if (parts.length < 5) {
                    continue;
                }

                int    clientId = Integer.parseInt(parts[0].trim());
                String name     = parts[1].trim();
                String phone    = parts[2].trim();
                String email    = parts[3].trim();
                String password = parts[4].trim();

                Client client = new Client(clientId, name, phone, email, password);
                hotel.addClient(client);
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error loading clients: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("[FileManager] Invalid client data format: " + e.getMessage());
        }
    }

    // The HotelController link is wired up later by connectEmployeesToController().
    private void loadEmployees(Hotel hotel) {
        File file = new File(EMPLOYEES_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\" + SEP, -1);
                if (parts.length < 5) {
                    continue;
                }

                int    empId    = Integer.parseInt(parts[0].trim());
                String name     = parts[1].trim();
                String role     = parts[2].trim();
                double salary   = Double.parseDouble(parts[3].trim());
                String password = parts[4].trim();

                Employee emp;
                switch (role) {
                    case "Manager":
                        emp = new Manager(empId, name, salary);
                        break;
                    case "Receptionist":
                        emp = new Receptionist(empId, name, salary);
                        break;
                    default:
                        emp = new ServiceStaff(empId, name, salary);
                        break;
                }

                emp.setPassword(password);
                hotel.addEmployee(emp);
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error loading employees: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("[FileManager] Invalid employee data format: " + e.getMessage());
        }
    }

    private void loadBookings(Hotel hotel) {
        File file = new File(BOOKINGS_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKINGS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\" + SEP, -1);
                if (parts.length < 7) {
                    continue;
                }

                long   bookingId  = Long.parseLong(parts[0].trim());
                int    clientId   = Integer.parseInt(parts[1].trim());
                int    roomNumber = Integer.parseInt(parts[2].trim());
                int    nights     = Integer.parseInt(parts[3].trim());
                int    guests     = Integer.parseInt(parts[4].trim());
                String remarks    = parts[5].trim();
                LocalDate checkIn = LocalDate.parse(parts[6].trim());

                Client client = findClientById(hotel, clientId);
                Room   room   = findRoomByNumber(hotel, roomNumber);

                if (client == null || room == null) {
                    System.out.println("[FileManager] Skipping booking #" + bookingId
                            + ": client or room not found.");
                    continue;
                }

                Booking booking = new Booking(bookingId, client, room, nights, guests, remarks);
                booking.setCheckInDate(checkIn);

                hotel.addBooking(booking);
                client.addBooking(booking);
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error loading bookings: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[FileManager] Invalid booking data format: " + e.getMessage());
        }
    }

    private void loadFoodOrders(Hotel hotel) {
        File file = new File(FOOD_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FOOD_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\" + SEP, -1);
                if (parts.length < 4) {
                    continue;
                }

                long   bookingId = Long.parseLong(parts[0].trim());
                int    quantity  = Integer.parseInt(parts[1].trim());
                String itemName  = parts[2].trim();
                double unitPrice = Double.parseDouble(parts[3].trim());

                Booking booking = findBookingById(hotel, bookingId);
                if (booking != null) {
                    booking.addFoodOrder(new FoodOrder(quantity, itemName, unitPrice));
                }
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error loading food orders: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("[FileManager] Invalid food order data format: " + e.getMessage());
        }
    }

    private void loadServiceOrders(Hotel hotel) {
        File file = new File(SERVICE_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(SERVICE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\" + SEP, -1);
                if (parts.length < 4) {
                    continue;
                }

                long   bookingId    = Long.parseLong(parts[0].trim());
                String serviceName  = parts[1].trim();
                double servicePrice = Double.parseDouble(parts[2].trim());
                int    quantity     = Integer.parseInt(parts[3].trim());

                Booking booking = findBookingById(hotel, bookingId);
                if (booking != null) {
                    booking.addServiceOrder(new ServiceOrder(serviceName, servicePrice, quantity));
                }
            }
        } catch (IOException e) {
            System.out.println("[FileManager] Error loading service orders: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("[FileManager] Invalid service order data format: " + e.getMessage());
        }
    }

    private Client findClientById(Hotel hotel, int clientId) {
        for (Client client : hotel.getClients()) {
            if (client != null && client.getClientId() == clientId) {
                return client;
            }
        }
        return null;
    }

    private Room findRoomByNumber(Hotel hotel, int roomNumber) {
        for (Room room : hotel.getRooms()) {
            if (room != null && room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    private Booking findBookingById(Hotel hotel, long bookingId) {
        for (Booking booking : hotel.getBookings()) {
            if (booking != null && booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        return null;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
