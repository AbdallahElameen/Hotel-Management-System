package app.entity.employee;

import app.entity.Booking;
import app.entity.FoodOrder;
import app.entity.ServiceOrder;

public class ServiceStaff extends Employee {

    private Long assignedBookingId;

    public ServiceStaff(int employeeId, String name, double salary) {
        super(employeeId, name, salary, "ServiceStaff");
        this.assignedBookingId = null;
    }

    @Override
    public void performDuty() {
        System.out.println("Service Staff " + getName() + " is handling guest requests.");
    }

    public void assignBooking(long bookingId) {
        try {
            if (hotelController == null) {
                System.out.println("Cannot assign booking: staff is not connected to the system.");
                return;
            }
            Booking booking = hotelController.findBookingById(bookingId);
            if (booking == null) {
                System.out.println("Cannot assign: booking #" + bookingId + " was not found.");
                return;
            }
            this.assignedBookingId = bookingId;
            System.out.println("Service Staff " + getName()
                    + " assigned to booking #" + bookingId + ".");
        } catch (Exception e) {
            System.out.println("Error assigning booking: " + e.getMessage());
        }
    }

    public void deliverFood(long bookingId, FoodOrder foodOrder) {
        try {
            if (hotelController == null) {
                System.out.println("Cannot deliver food: staff is not connected to the system.");
                return;
            }
            if (foodOrder == null) {
                System.out.println("Cannot deliver food: no food order provided.");
                return;
            }
            Booking booking = hotelController.findBookingById(bookingId);
            if (booking == null) {
                System.out.println("Cannot deliver food: booking #"
                        + bookingId + " was not found.");
                return;
            }
            hotelController.orderFood(bookingId, foodOrder);
            System.out.println("Food delivered by " + getName()
                    + " to booking #" + bookingId + ": " + foodOrder);
        } catch (Exception e) {
            System.out.println("Error delivering food: " + e.getMessage());
        }
    }

    // Overload that uses whichever booking is currently assigned to this staff member.
    public void performService(ServiceOrder order) {
        if (assignedBookingId == null) {
            System.out.println("No booking assigned. Please assign a booking first.");
            return;
        }
        performService(assignedBookingId, order);
    }

    public void performService(long bookingId, ServiceOrder order) {
        try {
            if (hotelController == null) {
                System.out.println("Cannot perform service: staff is not connected to the system.");
                return;
            }
            if (order == null) {
                System.out.println("Cannot perform service: no service order provided.");
                return;
            }
            Booking booking = hotelController.findBookingById(bookingId);
            if (booking == null) {
                System.out.println("Cannot perform service: booking #"
                        + bookingId + " was not found.");
                return;
            }
            hotelController.orderService(bookingId, order);
            System.out.println("Service performed by " + getName()
                    + " for booking #" + bookingId + ": " + order);
        } catch (Exception e) {
            System.out.println("Error performing service: " + e.getMessage());
        }
    }

    public Long getAssignedBookingId() {
        return assignedBookingId;
    }

    public void setAssignedBookingId(Long assignedBookingId) {
        this.assignedBookingId = assignedBookingId;
    }
}
