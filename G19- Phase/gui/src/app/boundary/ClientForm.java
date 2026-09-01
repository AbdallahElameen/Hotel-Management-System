package app.boundary;

import app.control.HotelController;
import app.entity.Booking;
import app.entity.Client;
import app.entity.FoodOrder;
import app.entity.ServiceOrder;

import javax.swing.table.DefaultTableModel;

public class ClientForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(ClientForm.class.getName());

    private final HotelController controller;
    private final Client client;
    private final HotelSystemUI coordinator;

    public ClientForm(HotelController controller, Client client, HotelSystemUI coordinator) {
        this.controller  = controller;
        this.client      = client;
        this.coordinator = coordinator;
        initComponents();
        welcomeLabel.setText("Welcome, " + client.getName()
                + "  (Client #" + client.getClientId() + ")");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        accentStrip = new javax.swing.JPanel();
        viewBookingsBtn = new javax.swing.JButton();
        viewBillBtn = new javax.swing.JButton();
        orderFoodBtn = new javax.swing.JButton();
        orderServiceBtn = new javax.swing.JButton();
        updateAccountBtn = new javax.swing.JButton();
        changePasswordBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        tableHeaderLabel = new javax.swing.JLabel();
        tableScroll = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        outputHeaderLabel = new javax.swing.JLabel();
        outputScroll = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        saveBtn = new javax.swing.JButton();
        loadBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Dashboard");
        setBackground(new java.awt.Color(244, 246, 250));
        getContentPane().setBackground(new java.awt.Color(244, 246, 250));

        headerPanel.setBackground(new java.awt.Color(26, 42, 74));

        titleLabel.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Client Dashboard");

        welcomeLabel.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(220, 226, 240));
        welcomeLabel.setText("Welcome, Guest");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        accentStrip.setBackground(new java.awt.Color(182, 136, 60));

        javax.swing.GroupLayout accentStripLayout = new javax.swing.GroupLayout(accentStrip);
        accentStrip.setLayout(accentStripLayout);
        accentStripLayout.setHorizontalGroup(
            accentStripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        accentStripLayout.setVerticalGroup(
            accentStripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        stylePrimaryButton(viewBookingsBtn, "My Bookings");
        viewBookingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBookingsBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(viewBillBtn, "View My Bill");
        viewBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBillBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(orderFoodBtn, "Order Food");
        orderFoodBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderFoodBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(orderServiceBtn, "Order Service");
        orderServiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderServiceBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(updateAccountBtn, "Update Account");
        updateAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAccountBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(changePasswordBtn, "Change Password");
        changePasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(clearBtn, "Clear Output");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        tableHeaderLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tableHeaderLabel.setForeground(new java.awt.Color(26, 42, 74));
        tableHeaderLabel.setText("Data");

        dataTable.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {}, new String[] { "Info" }));
        dataTable.setFillsViewportHeight(true);
        dataTable.setRowHeight(22);
        dataTable.getTableHeader().setFont(new java.awt.Font("SansSerif", 1, 12));
        dataTable.getTableHeader().setBackground(new java.awt.Color(26, 42, 74));
        dataTable.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        tableScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 226, 233), 1));
        tableScroll.setViewportView(dataTable);

        outputHeaderLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        outputHeaderLabel.setForeground(new java.awt.Color(26, 42, 74));
        outputHeaderLabel.setText("Output");

        outputArea.setColumns(20);
        outputArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        outputArea.setRows(5);
        outputArea.setEditable(false);
        outputArea.setBackground(new java.awt.Color(255, 255, 255));
        outputScroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 226, 233), 1));
        outputScroll.setViewportView(outputArea);

        saveBtn.setBackground(new java.awt.Color(40, 141, 80));
        saveBtn.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save Data");
        saveBtn.setBorderPainted(false);
        saveBtn.setFocusPainted(false);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        loadBtn.setBackground(new java.awt.Color(23, 126, 192));
        loadBtn.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        loadBtn.setForeground(new java.awt.Color(255, 255, 255));
        loadBtn.setText("Load Data");
        loadBtn.setBorderPainted(false);
        loadBtn.setFocusPainted(false);
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(192, 57, 43));
        logoutBtn.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Logout");
        logoutBtn.setBorderPainted(false);
        logoutBtn.setFocusPainted(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(accentStrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(viewBillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(orderFoodBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(orderServiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(changePasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(loadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(accentStrip, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewBillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderFoodBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderServiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(tableHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(tableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(outputHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(outputScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewBookingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBookingsBtnActionPerformed
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Booking ID", "Room #", "Nights", "Guests", "Remarks"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        java.util.List<Booking> list = client.getBookings();
        if (list != null) {
            for (Booking b : list) {
                if (b != null) {
                    model.addRow(new Object[]{
                            b.getBookingId(),
                            b.getRoom() != null ? b.getRoom().getRoomNumber() : "-",
                            b.getNumberOfNights(),
                            b.getNumberOfGuests(),
                            b.getSpecialRemarks()
                    });
                }
            }
        }
        tableHeaderLabel.setText("Your Bookings (" + model.getRowCount() + ")");
        dataTable.setModel(model);
        showOutput(model.getRowCount() == 0
                ? "You have no bookings yet."
                : model.getRowCount() + " booking(s) shown above.");
    }//GEN-LAST:event_viewBookingsBtnActionPerformed

    private void viewBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBillBtnActionPerformed
        try {
            String idText = javax.swing.JOptionPane.showInputDialog(this,
                    "Enter Booking ID to view bill:");
            if (idText == null) { return; }
            long bookingId  = Long.parseLong(idText.trim());
            Booking booking = controller.findBookingById(bookingId);
            if (booking == null) {
                showOutput("No booking found with ID " + bookingId + ".");
                return;
            }
            if (booking.getClient() == null
                    || booking.getClient().getClientId() != client.getClientId()) {
                showOutput("This booking does not belong to your account.");
                return;
            }
            double total = controller.calculateBill(bookingId);
            StringBuilder sb = new StringBuilder();
            sb.append("========== BILL FOR BOOKING #").append(bookingId).append(" ==========\n");
            sb.append(booking).append('\n');
            sb.append("TOTAL DUE: $").append(String.format("%.2f", total)).append('\n');
            showOutput(sb.toString());
        } catch (NumberFormatException ex) {
            showOutput("Error viewing bill: booking ID must be numeric.");
        }
    }//GEN-LAST:event_viewBillBtnActionPerformed

    // Client picks an item; price comes from MenuCatalog and isn't editable here.
    private void orderFoodBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderFoodBtnActionPerformed
        MenuCatalog.Item picked = pickMenuItem(MenuCatalog.getFoodItems(),
                "Food Menu - select an item to order");
        if (picked == null) { return; }

        try {
            String idText = javax.swing.JOptionPane.showInputDialog(this,
                    "Enter your Booking ID:");
            if (idText == null) { return; }
            String qtyText = javax.swing.JOptionPane.showInputDialog(this,
                    "Quantity for \"" + picked.name + "\" at $"
                            + String.format("%.2f", picked.price) + " each:");
            if (qtyText == null) { return; }

            long bookingId = Long.parseLong(idText.trim());
            if (!ownsBooking(bookingId)) {
                showOutput("Booking #" + bookingId + " does not belong to your account.");
                return;
            }
            int qty = Integer.parseInt(qtyText.trim());
            FoodOrder order = new FoodOrder(qty, picked.name, picked.price);
            controller.orderFood(bookingId, order);
            showOutput("Food order placed on booking #" + bookingId + ":\n" + order);
        } catch (NumberFormatException ex) {
            showOutput("Error ordering food: numeric fields must be numbers.");
        }
    }//GEN-LAST:event_orderFoodBtnActionPerformed

    // Client picks a service; price comes from MenuCatalog and isn't editable here.
    private void orderServiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderServiceBtnActionPerformed
        MenuCatalog.Item picked = pickMenuItem(MenuCatalog.getServiceItems(),
                "Service Menu - select a service to order");
        if (picked == null) { return; }

        try {
            String idText = javax.swing.JOptionPane.showInputDialog(this,
                    "Enter your Booking ID:");
            if (idText == null) { return; }
            String qtyText = javax.swing.JOptionPane.showInputDialog(this,
                    "Quantity for \"" + picked.name + "\" at $"
                            + String.format("%.2f", picked.price) + " each:");
            if (qtyText == null) { return; }

            long bookingId = Long.parseLong(idText.trim());
            if (!ownsBooking(bookingId)) {
                showOutput("Booking #" + bookingId + " does not belong to your account.");
                return;
            }
            int qty = Integer.parseInt(qtyText.trim());
            ServiceOrder order = new ServiceOrder(picked.name, picked.price, qty);
            controller.orderService(bookingId, order);
            showOutput("Service order placed on booking #" + bookingId + ":\n" + order);
        } catch (NumberFormatException ex) {
            showOutput("Error ordering service: numeric fields must be numbers.");
        }
    }//GEN-LAST:event_orderServiceBtnActionPerformed

    private void updateAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAccountBtnActionPerformed
        String name  = javax.swing.JOptionPane.showInputDialog(this,
                "New name (leave blank to keep current):", client.getName());
        if (name == null) { return; }
        String phone = javax.swing.JOptionPane.showInputDialog(this,
                "New phone (leave blank to keep current):", client.getPhone());
        if (phone == null) { return; }
        String email = javax.swing.JOptionPane.showInputDialog(this,
                "New email (leave blank to keep current):", client.getEmail());
        if (email == null) { return; }

        client.manageAccount(name, phone, email);
        welcomeLabel.setText("Welcome, " + client.getName()
                + "  (Client #" + client.getClientId() + ")");
        showOutput("Account details updated:\n" + client);
    }//GEN-LAST:event_updateAccountBtnActionPerformed

    private void changePasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordBtnActionPerformed
        javax.swing.JPasswordField current = new javax.swing.JPasswordField();
        javax.swing.JPasswordField next    = new javax.swing.JPasswordField();
        Object[] msg = { "Current password:", current, "New password:", next };
        int r = javax.swing.JOptionPane.showConfirmDialog(this, msg,
                "Change Password", javax.swing.JOptionPane.OK_CANCEL_OPTION);
        if (r != javax.swing.JOptionPane.OK_OPTION) { return; }

        String currentText = new String(current.getPassword());
        String nextText    = new String(next.getPassword());
        if (!client.getPassword().equals(currentText)) {
            showOutput("Password change failed: current password is incorrect.");
            return;
        }
        if (nextText.length() < 4) {
            showOutput("Password change failed: new password must be at least 4 characters.");
            return;
        }
        client.setPassword(nextText);
        showOutput("Password updated successfully.");
    }//GEN-LAST:event_changePasswordBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        outputArea.setText("");
        tableHeaderLabel.setText("Data");
        dataTable.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Info"}));
    }//GEN-LAST:event_clearBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            controller.saveData();
            showOutput("Hotel data saved to file successfully.");
        } catch (Exception ex) {
            showOutput("Error saving data: " + ex.getMessage());
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
        try {
            controller.loadData();
            showOutput("Hotel data loaded from file successfully.");
        } catch (Exception ex) {
            showOutput("Error loading data: " + ex.getMessage());
        }
    }//GEN-LAST:event_loadBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        coordinator.logout(this);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private boolean ownsBooking(long bookingId) {
        if (client.getBookings() == null) { return false; }
        for (Booking b : client.getBookings()) {
            if (b != null && b.getBookingId() == bookingId) { return true; }
        }
        return false;
    }

    // Pops up a table of menu items and returns the one the client selected,
    // or null if they cancelled. Keeps prices read-only.
    private MenuCatalog.Item pickMenuItem(java.util.List<MenuCatalog.Item> items, String title) {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Item", "Price"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        for (MenuCatalog.Item it : items) {
            model.addRow(new Object[]{ it.name, String.format("$%.2f", it.price) });
        }
        javax.swing.JTable table = new javax.swing.JTable(model);
        table.setRowHeight(22);
        table.getTableHeader().setBackground(new java.awt.Color(26, 42, 74));
        table.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.JScrollPane sp = new javax.swing.JScrollPane(table);
        sp.setPreferredSize(new java.awt.Dimension(420, 260));

        int res = javax.swing.JOptionPane.showOptionDialog(this, sp, title,
                javax.swing.JOptionPane.DEFAULT_OPTION,
                javax.swing.JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"Confirm", "Cancel"}, "Cancel");
        if (res != 0) { return null; }
        int row = table.getSelectedRow();
        if (row < 0) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Please select an item first.",
                    title, javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        return items.get(row);
    }

    private void stylePrimaryButton(javax.swing.JButton btn, String text) {
        btn.setText(text);
        btn.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        btn.setBackground(new java.awt.Color(26, 42, 74));
        btn.setForeground(new java.awt.Color(255, 255, 255));
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setOpaque(true);
    }

    private void showOutput(String text) {
        outputArea.setText(text);
        outputArea.setCaretPosition(0);
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accentStrip;
    private javax.swing.JButton changePasswordBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTable dataTable;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton loadBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton orderFoodBtn;
    private javax.swing.JButton orderServiceBtn;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JLabel outputHeaderLabel;
    private javax.swing.JScrollPane outputScroll;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel tableHeaderLabel;
    private javax.swing.JScrollPane tableScroll;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton updateAccountBtn;
    private javax.swing.JButton viewBillBtn;
    private javax.swing.JButton viewBookingsBtn;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
