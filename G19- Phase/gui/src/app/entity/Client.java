package app.entity;

import java.util.ArrayList;

public class Client {

    private int clientId;
    private String name;
    private String phone;
    private String email;
    private String password;
    private ArrayList<Booking> bookings;

    public Client(int clientId, String name, String phone, String email) {
        this.clientId = clientId;
        this.name     = name;
        this.phone    = phone;
        this.email    = email;
        this.password = "password123";
        this.bookings = new ArrayList<>();
    }

    public Client(int clientId, String name, String phone, String email, String password) {
        this(clientId, name, phone, email);
        this.password = password;
    }

    // Updates whichever fields the caller provides; blank/null values are ignored.
    public void manageAccount(String newName, String newPhone, String newEmail) {
        if (newName != null && !newName.isEmpty()) {
            this.name = newName;
        }
        if (newPhone != null && !newPhone.isEmpty()) {
            this.phone = newPhone;
        }
        if (newEmail != null && !newEmail.isEmpty()) {
            this.email = newEmail;
        }
        System.out.println("Account updated for client: " + name);
    }

    public void addBooking(Booking booking) {
        if (booking != null) {
            bookings.add(booking);
        }
    }

    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found for client: " + name);
            return;
        }
        System.out.println("===== Bookings for " + name + " =====");
        for (Booking booking : bookings) {
            if (booking != null) {
                System.out.println(booking);
            }
        }
    }

    @Override
    public String toString() {
        return "Client{"
                + "clientId=" + clientId
                + ", name='" + name + '\''
                + ", phone='" + phone + '\''
                + ", email='" + email + '\''
                + '}';
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}
