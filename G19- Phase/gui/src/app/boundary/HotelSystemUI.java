package app.boundary;

import app.control.HotelController;
import app.entity.Client;
import app.entity.employee.Manager;
import app.entity.employee.Receptionist;
import app.entity.employee.ServiceStaff;

// Coordinator that owns navigation between the five JFrame screens. Not a
// JFrame itself - it just opens whichever dashboard the login picked.
public class HotelSystemUI {

    private final HotelController controller;
    private LoginForm loginForm;

    public HotelSystemUI(HotelController controller) {
        this.controller = controller;
    }

    // Called from Main once the hotel data has been seeded.
    public void start() {
        java.awt.EventQueue.invokeLater(() -> {
            loginForm = new LoginForm(controller, this);
            loginForm.setVisible(true);
        });
    }

    public void showManagerDashboard(Manager manager) {
        if (loginForm != null) { loginForm.dispose(); }
        new ManagerForm(controller, manager, this).setVisible(true);
    }

    public void showReceptionistDashboard(Receptionist receptionist) {
        if (loginForm != null) { loginForm.dispose(); }
        new ReceptionistForm(controller, receptionist, this).setVisible(true);
    }

    public void showServiceStaffDashboard(ServiceStaff staff) {
        if (loginForm != null) { loginForm.dispose(); }
        new ServiceStaffForm(controller, staff, this).setVisible(true);
    }

    public void showClientDashboard(Client client) {
        if (loginForm != null) { loginForm.dispose(); }
        new ClientForm(controller, client, this).setVisible(true);
    }

    // Closes whichever dashboard is open and returns to the login screen.
    public void logout(javax.swing.JFrame currentForm) {
        if (currentForm != null) { currentForm.dispose(); }
        loginForm = new LoginForm(controller, this);
        loginForm.setVisible(true);
    }

    public HotelController getController() { return controller; }
}
