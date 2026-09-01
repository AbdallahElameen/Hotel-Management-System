package app.entity;

import app.entity.employee.Employee;
import app.entity.room.Room;
import java.util.ArrayList;

public class Hotel {

    private String hotelName;
    private ArrayList<Room> rooms;
    private ArrayList<Client> clients;
    private ArrayList<Booking> bookings;
    private ArrayList<Employee> employees;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        this.rooms     = new ArrayList<>();
        this.clients   = new ArrayList<>();
        this.bookings  = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public void addRoom(Room room) {
        try {
            if (room != null) {
                rooms.add(room);
            }
        } catch (Exception e) {
            System.out.println("[Hotel] Error adding room: " + e.getMessage());
        }
    }

    public void addClient(Client client) {
        try {
            if (client != null) {
                clients.add(client);
            }
        } catch (Exception e) {
            System.out.println("[Hotel] Error adding client: " + e.getMessage());
        }
    }

    public void addBooking(Booking booking) {
        try {
            if (booking != null) {
                bookings.add(booking);
            }
        } catch (Exception e) {
            System.out.println("[Hotel] Error adding booking: " + e.getMessage());
        }
    }

    // Walks the list backwards so removing while iterating is safe.
    public void removeBooking(long bookingId) {
        try {
            for (int i = bookings.size() - 1; i >= 0; i--) {
                Booking booking = bookings.get(i);
                if (booking != null && booking.getBookingId() == bookingId) {
                    bookings.remove(i);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("[Hotel] Error removing booking: " + e.getMessage());
        }
    }

    public void addEmployee(Employee employee) {
        try {
            if (employee != null) {
                employees.add(employee);
            }
        } catch (Exception e) {
            System.out.println("[Hotel] Error adding employee: " + e.getMessage());
        }
    }

    // Walks the list backwards so removing while iterating is safe.
    public void removeEmployee(int employeeId) {
        try {
            for (int i = employees.size() - 1; i >= 0; i--) {
                Employee employee = employees.get(i);
                if (employee != null && employee.getEmployeeId() == employeeId) {
                    employees.remove(i);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("[Hotel] Error removing employee: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        int availableCount = 0;
        String roomDetails = "";

        try {
            if (rooms != null) {
                for (Room room : rooms) {
                    if (room == null || room.getIsBooked()) {
                        continue;
                    }
                    availableCount++;
                    roomDetails += "  - Room #" + room.getRoomNumber()
                            + " (" + room.getRoomType() + ")"
                            + " | $" + room.getPricePerNight() + "/night"
                            + " | " + room.getFeatures() + "\n";
                }
            }
        } catch (Exception e) {
            System.out.println("[Hotel] Error building room summary: " + e.getMessage());
        }

        String result = "========== HOTEL OVERVIEW ==========\n"
                + "Hotel Name       : " + hotelName + "\n"
                + "Total Rooms      : " + (rooms     == null ? 0 : rooms.size())     + "\n"
                + "Available Rooms  : " + availableCount                              + "\n"
                + "Total Clients    : " + (clients   == null ? 0 : clients.size())   + "\n"
                + "Active Bookings  : " + (bookings  == null ? 0 : bookings.size())  + "\n"
                + "Total Employees  : " + (employees == null ? 0 : employees.size()) + "\n"
                + "=====================================\n"
                + "Available Rooms:\n";

        if (availableCount == 0) {
            result += "  No rooms currently available.\n";
        } else {
            result += roomDetails;
        }

        return result;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
