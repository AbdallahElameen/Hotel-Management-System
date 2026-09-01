package app.entity.employee;

import app.entity.Booking;
import app.entity.Hotel;
import app.entity.room.Room;
import app.exceptions.InvalidBookingException;
import java.util.ArrayList;

public class Manager extends Employee {

    private final ArrayList<Long> approvedBookingIds;

    public Manager(int employeeId, String name, double salary) {
        super(employeeId, name, salary, "Manager");
        this.approvedBookingIds = new ArrayList<>();
    }

    @Override
    public void performDuty() {
        System.out.println("Manager " + getName() + " is supervising hotel operations.");
    }

    // Throws InvalidBookingException so callers must explicitly handle the case
    // where the booking is missing or the manager isn't wired up to the system.
    public void approveBooking(Booking booking) throws InvalidBookingException {
        if (booking == null) {
            throw new InvalidBookingException(
                "Cannot approve booking: no booking was provided.");
        }

        if (hotelController == null) {
            throw new InvalidBookingException(
                "Cannot approve booking: manager is not connected to the system.");
        }

        Booking existing = hotelController.findBookingById(booking.getBookingId());
        if (existing == null) {
            throw new InvalidBookingException(
                "Cannot approve booking: booking #"
                + booking.getBookingId() + " was not found in the system.");
        }

        if (!approvedBookingIds.contains(existing.getBookingId())) {
            approvedBookingIds.add(existing.getBookingId());
        }

        System.out.println("Booking #" + booking.getBookingId()
                + " approved by Manager " + getName() + ".");
        System.out.println(booking);
    }

    public void addStaff(Employee employee) {
        try {
            if (hotelController == null) {
                System.out.println("Cannot add staff: manager is not connected to the system.");
                return;
            }
            if (employee == null) {
                System.out.println("Cannot add a null staff member.");
                return;
            }
            employee.setHotelController(hotelController);
            hotelController.addEmployee(employee);
            System.out.println("Staff added by Manager " + getName() + ": " + employee);
        } catch (Exception e) {
            System.out.println("Error adding staff: " + e.getMessage());
        }
    }

    public void removeStaff(int employeeId) {
        try {
            if (hotelController == null) {
                System.out.println("Cannot remove staff: manager is not connected to the system.");
                return;
            }
            hotelController.removeEmployee(employeeId);
            System.out.println("Staff removal processed by Manager "
                    + getName() + " for employee #" + employeeId + ".");
        } catch (Exception e) {
            System.out.println("Error removing staff: " + e.getMessage());
        }
    }

    // Pass an empty name or zero salary to leave that field unchanged.
    public void updateStaff(int employeeId, String newName, double newSalary) {
        try {
            if (hotelController == null) {
                System.out.println("Cannot update staff: manager is not connected to the system.");
                return;
            }
            hotelController.updateEmployee(employeeId, newName, newSalary);
            System.out.println("Staff update processed by Manager "
                    + getName() + " for employee #" + employeeId + ".");
        } catch (Exception e) {
            System.out.println("Error updating staff: " + e.getMessage());
        }
    }

    public void manageRoomAvailability(int roomNumber, boolean setBooked) {
        try {
            if (hotelController == null) {
                System.out.println("Cannot manage room: manager is not connected to the system.");
                return;
            }
            hotelController.manageRoomAvailability(roomNumber, setBooked);
            System.out.println("Room availability updated by Manager "
                    + getName() + " for room #" + roomNumber + ".");
        } catch (Exception e) {
            System.out.println("Error managing room availability: " + e.getMessage());
        }
    }

    public void viewHotelReport() {
        try {
            if (hotelController == null || hotelController.getHotel() == null) {
                System.out.println("Cannot view report: manager is not connected to hotel data.");
                return;
            }

            Hotel hotel         = hotelController.getHotel();
            int totalRooms      = hotel.getRooms()     == null ? 0 : hotel.getRooms().size();
            int bookedRooms     = 0;

            if (hotel.getRooms() != null) {
                for (Room room : hotel.getRooms()) {
                    if (room != null && room.getIsBooked()) {
                        bookedRooms++;
                    }
                }
            }

            int totalClients    = hotel.getClients()   == null ? 0 : hotel.getClients().size();
            int totalBookings   = hotel.getBookings()  == null ? 0 : hotel.getBookings().size();
            int totalEmployees  = hotel.getEmployees() == null ? 0 : hotel.getEmployees().size();

            System.out.println("========== HOTEL REPORT ==========");
            System.out.println("Viewed by Manager : " + getName());
            System.out.println("Total Rooms       : " + totalRooms);
            System.out.println("Booked Rooms      : " + bookedRooms);
            System.out.println("Available Rooms   : " + (totalRooms - bookedRooms));
            System.out.println("Total Clients     : " + totalClients);
            System.out.println("Active Bookings   : " + totalBookings);
            System.out.println("Total Employees   : " + totalEmployees);
            System.out.println("Approved Bookings : " + approvedBookingIds.size());
            System.out.println("==================================");
        } catch (Exception e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }

    // Returns a defensive copy so callers can't mutate the internal list.
    public ArrayList<Long> getApprovedBookingIds() {
        return new ArrayList<>(approvedBookingIds);
    }
}
