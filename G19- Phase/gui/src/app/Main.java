package app;

import app.access.FileManager;
import app.boundary.HotelSystemUI;
import app.control.HotelController;
import app.entity.Booking;
import app.entity.Client;
import app.entity.FoodOrder;
import app.entity.Hotel;
import app.entity.Payment;
import app.entity.ServiceOrder;
import app.entity.employee.Manager;
import app.entity.employee.Receptionist;
import app.entity.employee.ServiceStaff;
import app.entity.room.DeluxeRoom;
import app.entity.room.Room;
import app.entity.room.StandardRoom;
import app.entity.room.SuiteRoom;
import app.enums.PaymentMethod;
import app.exceptions.InvalidBookingException;
import app.exceptions.RoomAlreadyBooked;

// Main for the Hotel Management System.
// Run console tests
// then Phase 2 GUI.
public class Main {

    public static void main(String[] args) {

        //console test
        System.out.println("=============================================");
        System.out.println("   HOTEL MANAGEMENT SYSTEM - PHASE 1 TEST   ");
        System.out.println("=============================================");

        Hotel hotel = new Hotel("Manang Hotel");
        FileManager fileManager = new FileManager();
        HotelController controller = new HotelController(hotel, fileManager);

        //SECTION 1: ADD ROOMS
        System.out.println("\n SECTION 1: ADD ROOMS ");
        StandardRoom room101 = new StandardRoom(101);
        StandardRoom room102 = new StandardRoom(102);
        DeluxeRoom   room201 = new DeluxeRoom(201);
        DeluxeRoom   room202 = new DeluxeRoom(202);
        SuiteRoom    room301 = new SuiteRoom(301);

        controller.addRoom(room101);
        controller.addRoom(room102);
        controller.addRoom(room201);
        controller.addRoom(room202);
        controller.addRoom(room301);
        
        // remind me to write more detailed comments because these are too basic
        
        // getRoomType() which returns different type depending on the class of the parent (polymorphism)
        System.out.println("Room 101 type : " + room101.getRoomType());
        System.out.println("Room 201 type : " + room201.getRoomType());
        System.out.println("Room 301 type : " + room301.getRoomType());

        // SECTION 2: CREATE AND CONNECT EMPLOYEES
        System.out.println("\n  SECTION 2: CREATE EMPLOYEES  ");
        Manager manager = new Manager(1, "Abdullah", 7500.0);
        Receptionist receptionist = new Receptionist(2, "Omar", 4200.0);
        ServiceStaff serviceStaff = new ServiceStaff(3, "Yahya", 3500.0);

        // GUI login details
        manager.setPassword("manager123");
        receptionist.setPassword("receptionist123");
        serviceStaff.setPassword("staff123");

        manager.setHotelController(controller);
        receptionist.setHotelController(controller);
        serviceStaff.setHotelController(controller);

        controller.addEmployee(manager);
        controller.addEmployee(receptionist);
        controller.addEmployee(serviceStaff);

        // Test performDuty() which is abstract
        manager.performDuty();
        receptionist.performDuty();
        serviceStaff.performDuty();

        //  SECTION 3: REGISTER CLIENTS 
        System.out.println("\n--- SECTION 3: REGISTER CLIENTS ---");
        Client client1 = new Client(1001, "Ali Hassan",  "01000000001", "ali@mail.com",   "ali123");
        Client client2 = new Client(1002, "Mona Adel",   "01000000002", "mona@mail.com",  "mona123");
        Client client3 = new Client(1003, "Karim Nabil", "01000000003", "karim@mail.com", "karim123");
        
        //receptionist registers clients
        receptionist.registerClient(client1);
        receptionist.registerClient(client2);
        receptionist.registerClient(client3);

        // Test duplicate registration which is not allowed
        System.out.println("\nTesting duplicate client registration:");
        receptionist.registerClient(client1);

        // SECTION 4: HOTEL OVERVIEW BEFORE BOOKING
        System.out.println("\n  SECTION 4: HOTEL OVERVIEW BEFORE BOOKING ");
        System.out.println(hotel);

        //  SECTION 5: CREATE BOOKINGS 
        System.out.println("\n  SECTION 5: CREATE BOOKINGS  ");

        // Basic booking - 1 guest, no remarks.
        Booking booking1 = receptionist.createBooking(client1, room101, 3);

        // Full booking with guests and special remarks (we missed this in the feedback pls fix).
        //FIXED
        Booking booking2 = receptionist.createBooking(client2, room201, 2, 2, "Sea view preferred");
        Booking booking3 = receptionist.createBooking(client3, room301, 5, 3, "Breakfast only, late checkout");

        // SECTION 6: EXCEPTION HANDLING - RoomAlreadyBooked 
        System.out.println("\n  SECTION 6: RoomAlreadyBooked EXCEPTION  ");
        System.out.println("Testing RoomAlreadyBooked on room 101 (already booked):");
        try {
            room101.bookRoom();
            System.out.println("ERROR: Exception was not thrown.");
        } catch (RoomAlreadyBooked e) {
            System.out.println("Caught correctly: " + e.getMessage());
        }
        
        //the e.get message() prints the message i opu tin the throw new exception, imporetant do not forget

        // Test booking an occupied room through controller.
        System.out.println("\nTesting occupied room booking via receptionist:");
        Booking failedBooking = receptionist.createBooking(client2, room101, 1);
        if (failedBooking == null) {
            System.out.println("Correctly rejected: room 101 is occupied.");
        }

        // SECTION 7: EXCEPTION HANDLING  InvalidBookingException 
        System.out.println("\n  SECTION 7: InvalidBookingException ");
        System.out.println("Testing InvalidBookingException with 0 nights:");
        try {
            receptionist.createBookingChecked(client2, room102, 0, 1, "");
        } catch (InvalidBookingException e) {
            System.out.println("Caught correctly: " + e.getMessage());
        }

        System.out.println("\nTesting InvalidBookingException with null client:");
        try {
            receptionist.createBookingChecked(null, room102, 2, 1, "");
        } catch (InvalidBookingException e) {
            System.out.println("Caught correctly: " + e.getMessage());
        }

        //  SECTION 8: MANAGER APPROVES BOOKINGS 
        System.out.println("\n  SECTION 8: MANAGER APPROVES BOOKINGS  ");
        try {
            if (booking1 != null) { manager.approveBooking(booking1); }
            if (booking2 != null) { manager.approveBooking(booking2); }
            if (booking3 != null) { manager.approveBooking(booking3); }
        } catch (InvalidBookingException e) {
            System.out.println("Booking approval error: " + e.getMessage());
        }
        System.out.println("Approved booking IDs: " + manager.getApprovedBookingIds());

        //  SECTION 9: MANAGER STAFF OPERATIONS 
        System.out.println("\n SECTION 9: MANAGER STAFF OPERATIONS ");
        ServiceStaff newStaff = new ServiceStaff(4, "Hassan", 3200.0);
        manager.addStaff(newStaff);
        System.out.println("Total employees after add: " + hotel.getEmployees().size());

        manager.updateStaff(4, "Hassan Mostafa", 3400.0);
        manager.removeStaff(4);
        System.out.println("Total employees after remove: " + hotel.getEmployees().size());

        //  SECTION 10: MANAGE ROOM AVAILABILITY 
        System.out.println("\n SECTION 10: MANAGE ROOM AVAILABILITY ");
        manager.manageRoomAvailability(102, true);
        System.out.println("Room 102 booked: " + room102.getIsBooked());
        manager.manageRoomAvailability(102, false);
        System.out.println("Room 102 booked after reset: " + room102.getIsBooked());

        // SECTION 11: UPDATE BOOKING 
        System.out.println("\n SECTION 11: UPDATE BOOKING ");
        if (booking1 != null) {
            System.out.println("Before: nights=" + booking1.getNumberOfNights() + ", guests=" + booking1.getNumberOfGuests() + ", remarks=" + booking1.getSpecialRemarks());
            receptionist.updateBooking(booking1.getBookingId(), 5, 2, "Extra pillows requested");
            System.out.println("After:  nights=" + booking1.getNumberOfNights() + ", guests=" + booking1.getNumberOfGuests() + ", remarks=" + booking1.getSpecialRemarks());
        }

        // SECTION 12: VIEW CLIENT BOOKINGS 
        System.out.println("\n SECTION 12: VIEW CLIENT BOOKINGS ");
        receptionist.viewClientBookings(client1.getClientId());

        //  SECTION 13: CLIENT ACCOUNT MANAGEMENT 
        System.out.println("\n SECTION 13: CLIENT ACCOUNT MANAGEMENT");
        System.out.println("Client 2 before: " + client2);
        client2.manageAccount("Mona Adel Mohamed", "01099999999", "mona.new@mail.com");
        System.out.println("Client 2 after:  " + client2);
        controller.updateClient(1003, "Karim Nabil Ahmed", null, "karim.new@mail.com");
        System.out.println("\nClient 1 booking history:");
        client1.viewBookings();

        // SECTION 14: SERVICE STAFF OPERATIONS 
        System.out.println("\n SECTION 14: SERVICE STAFF OPERATIONS ");
        if (booking1 != null) {
            serviceStaff.assignBooking(booking1.getBookingId());

            FoodOrder food1 = new FoodOrder(2, "Breakfast Tray", 15.0);
            FoodOrder food2 = new FoodOrder(1, "Club Sandwich", 22.5);
            serviceStaff.deliverFood(booking1.getBookingId(), food1);
            serviceStaff.deliverFood(booking1.getBookingId(), food2);

            ServiceOrder svc1 = new ServiceOrder("Laundry", 8.0, 3);
            ServiceOrder svc2 = new ServiceOrder("Spa", 50.0, 1);
            serviceStaff.performService(svc1);
            serviceStaff.performService(svc2);
        }
        //service testing on roon 2
        if (booking2 != null) {
            ServiceOrder roomClean = new ServiceOrder("Room Cleaning", 20.0, 1);
            serviceStaff.performService(booking2.getBookingId(), roomClean);
        }

        // SECTION 15: BILLING AND PAYMENT 
        System.out.println("\n SECTION 15: BILLING AND PAYMENT ");
        if (booking1 != null) {
            controller.displayBill(booking1.getBookingId());
            // who named it bill1, why not bill_1??
            double bill1 = controller.calculateBill(booking1.getBookingId());
            System.out.println("Total bill for booking 1: $" + bill1);

            Payment payment1 = new Payment(5001, bill1, PaymentMethod.Cash);
            payment1.processPayment(booking1);
            payment1.printBill();
        }
        if (booking2 != null) {
            double bill2 = controller.calculateBill(booking2.getBookingId());
            Payment payment2 = new Payment(5002, bill2, PaymentMethod.Credit_Card);
            payment2.processPayment(booking2);
            payment2.printBill();
        }

        // Test failed payment amount too low (when the client is broke).
        if (booking3 != null) {
            System.out.println("\nTesting failed payment (insufficient amount):");
            Payment failedPayment = new Payment(5003, 1.0, PaymentMethod.Online);
            failedPayment.processPayment(booking3);
            System.out.println("Status: " + failedPayment.getStatus());
        }

        // SECTION 16: CANCEL BOOKING
        System.out.println("\n SECTION 16: CANCEL BOOKING");
        //did the before and after thing on all checks to see if the funcs work
        if (booking3 != null) {
            System.out.println("Room 301 booked before cancel: " + room301.getIsBooked());
            receptionist.cancelBooking(booking3.getBookingId());
            System.out.println("Room 301 booked after cancel:  " + room301.getIsBooked());
        }

        //  SECTION 17: HOTEL REPORT (SAME AS HOTEL OVERVIEW BUT FORM NANAGERS POINT OF VIEW )
        System.out.println("\n SECTION 17: HOTEL REPORT ");
        manager.viewHotelReport();

        // SECTION 18: HOTEL OVERVIEW AFTER OPERATIONS 
        System.out.println("\n SECTION 18: HOTEL OVERVIEW AFTER OPERATIONS ");
        System.out.println(hotel);

        // SECTION 19: FILE OPERATIONS ( W3 schools and youtube )
        System.out.println("\n SECTION 19: SAVE AND LOAD DATA ");
        controller.saveData();
        controller.loadData();

        System.out.println("\n=============================================");
        System.out.println("     PHASE 1 CONSOLE TESTS COMPLETE          ");
        System.out.println("=============================================");

       
        // PHASE 2 - LAUNCH GUI
        
        
        System.out.println("\n LAUNCHING PHASE 2 GUI ");

        // Use the same hotel and controller
        HotelSystemUI ui = new HotelSystemUI(controller);
        ui.start();
    }
}