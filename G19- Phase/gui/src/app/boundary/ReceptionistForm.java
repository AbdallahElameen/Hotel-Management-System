package app.boundary;

import app.control.HotelController;
import app.entity.Booking;
import app.entity.Client;
import app.entity.employee.Receptionist;
import app.entity.room.Room;
import app.exceptions.InvalidBookingException;

import javax.swing.table.DefaultTableModel;

public class ReceptionistForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(ReceptionistForm.class.getName());

    private final HotelController controller;
    private final Receptionist receptionist;
    private final HotelSystemUI coordinator;

    public ReceptionistForm(HotelController controller, Receptionist receptionist, HotelSystemUI coordinator) {
        this.controller   = controller;
        this.receptionist = receptionist;
        this.coordinator  = coordinator;
        initComponents();
        welcomeLabel.setText("Welcome, Receptionist " + receptionist.getName()
                + "  (ID " + receptionist.getEmployeeId() + ")");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        accentStrip = new javax.swing.JPanel();
        registerClientBtn = new javax.swing.JButton();
        createBookingBtn = new javax.swing.JButton();
        cancelBookingBtn = new javax.swing.JButton();
        viewBookingsBtn = new javax.swing.JButton();
        listRoomsBtn = new javax.swing.JButton();
        listClientsBtn = new javax.swing.JButton();
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
        setTitle("Receptionist Dashboard");
        setBackground(new java.awt.Color(244, 246, 250));
        getContentPane().setBackground(new java.awt.Color(244, 246, 250));

        headerPanel.setBackground(new java.awt.Color(26, 42, 74));

        titleLabel.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Receptionist Dashboard");

        welcomeLabel.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(220, 226, 240));
        welcomeLabel.setText("Welcome, Receptionist");

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

        stylePrimaryButton(registerClientBtn, "Register Client");
        registerClientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerClientBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(createBookingBtn, "Create Booking");
        createBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBookingBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(cancelBookingBtn, "Cancel Booking");
        cancelBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBookingBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(viewBookingsBtn, "View Client Bookings");
        viewBookingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBookingsBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(listRoomsBtn, "List Available Rooms");
        listRoomsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listRoomsBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(listClientsBtn, "List All Clients");
        listClientsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listClientsBtnActionPerformed(evt);
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
                        .addComponent(registerClientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(createBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cancelBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(viewBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listRoomsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(listClientsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(registerClientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listRoomsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listClientsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(tableHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(tableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void registerClientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerClientBtnActionPerformed
        try {
            String idText = javax.swing.JOptionPane.showInputDialog(this, "Enter Client ID:");
            if (idText == null) { return; }
            String name = javax.swing.JOptionPane.showInputDialog(this, "Enter Full Name:");
            if (name == null) { return; }
            String phone = javax.swing.JOptionPane.showInputDialog(this, "Enter Phone:");
            if (phone == null) { return; }
            String email = javax.swing.JOptionPane.showInputDialog(this, "Enter Email:");
            if (email == null) { return; }

            int clientId = Integer.parseInt(idText.trim());
            Client client = new Client(clientId, name, phone, email);
            receptionist.registerClient(client);
            showOutput("Client registration processed: " + client);
        } catch (NumberFormatException ex) {
            showOutput("Error registering client: ID must be numeric.");
        }
    }//GEN-LAST:event_registerClientBtnActionPerformed

    private void createBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBookingBtnActionPerformed
        try {
            String clientIdText = javax.swing.JOptionPane.showInputDialog(this, "Enter Client ID:");
            if (clientIdText == null) { return; }
            String roomText = javax.swing.JOptionPane.showInputDialog(this, "Enter Room Number:");
            if (roomText == null) { return; }
            String nightsText = javax.swing.JOptionPane.showInputDialog(this, "Number of Nights:");
            if (nightsText == null) { return; }
            String guestsText = javax.swing.JOptionPane.showInputDialog(this, "Number of Guests:");
            if (guestsText == null) { return; }
            String remarks = javax.swing.JOptionPane.showInputDialog(this, "Special Remarks (optional):");
            if (remarks == null) { remarks = ""; }

            int clientId = Integer.parseInt(clientIdText.trim());
            int roomNum  = Integer.parseInt(roomText.trim());
            int nights   = Integer.parseInt(nightsText.trim());
            int guests   = Integer.parseInt(guestsText.trim());

            Client client = controller.findClientById(clientId);
            Room room     = controller.findRoomByNumber(roomNum);
            if (client == null) { showOutput("No client found with ID " + clientId + "."); return; }
            if (room == null)   { showOutput("No room found with number " + roomNum + ".");  return; }

            Booking booking = receptionist.createBookingChecked(client, room, nights, guests, remarks);
            showOutput("Booking created successfully:\n" + booking);
        } catch (NumberFormatException ex) {
            showOutput("Error creating booking: numeric fields must be numbers.");
        } catch (InvalidBookingException ex) {
            showOutput("Booking failed: " + ex.getMessage());
        }
    }//GEN-LAST:event_createBookingBtnActionPerformed

    private void cancelBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBookingBtnActionPerformed
        try {
            String idText = javax.swing.JOptionPane.showInputDialog(this, "Enter Booking ID to cancel:");
            if (idText == null) { return; }
            long bookingId = Long.parseLong(idText.trim());
            receptionist.cancelBooking(bookingId);
            showOutput("Cancellation requested for booking #" + bookingId + ".");
        } catch (NumberFormatException ex) {
            showOutput("Error cancelling booking: ID must be numeric.");
        }
    }//GEN-LAST:event_cancelBookingBtnActionPerformed

    // Shows the client's bookings in the table, then offers the original
    // update-booking dialog as a follow-up action.
    private void viewBookingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBookingsBtnActionPerformed
        try {
            String idText = javax.swing.JOptionPane.showInputDialog(this, "Enter Client ID:");
            if (idText == null) { return; }
            int clientId = Integer.parseInt(idText.trim());
            Client client = controller.findClientById(clientId);
            if (client == null) { showOutput("No client found with ID " + clientId + "."); return; }

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
            tableHeaderLabel.setText("Bookings for " + client.getName()
                    + " (" + model.getRowCount() + ")");
            dataTable.setModel(model);
            showOutput(model.getRowCount() + " booking(s) shown above. "
                    + "Choose 'Update Booking' in the next dialog to edit one.");

            if (model.getRowCount() == 0) { return; }

            Object[] options = { "Update Booking", "Close" };
            int choice = javax.swing.JOptionPane.showOptionDialog(this,
                    "The bookings above belong to " + client.getName()
                            + ". Press 'Update Booking' to enter a booking ID to update.",
                    "View Client Bookings",
                    javax.swing.JOptionPane.DEFAULT_OPTION,
                    javax.swing.JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
            if (choice != 0) { return; }

            String idField = javax.swing.JOptionPane.showInputDialog(this,
                    "Enter the Booking ID (from the table above) to update:");
            if (idField == null) { return; }
            try {
                long bookingId = Long.parseLong(idField.trim());
                if (controller.findBookingById(bookingId) == null) {
                    showOutput("No booking found with ID " + bookingId + ".");
                    return;
                }
                promptUpdateBooking(bookingId);
            } catch (NumberFormatException nx) {
                showOutput("Error updating booking: ID must be numeric.");
            }

        } catch (NumberFormatException ex) {
            showOutput("Error viewing bookings: client ID must be numeric.");
        }
    }//GEN-LAST:event_viewBookingsBtnActionPerformed

    private void listRoomsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listRoomsBtnActionPerformed
        if (controller.getHotel() == null || controller.getHotel().getRooms() == null) {
            showOutput("Hotel data is unavailable.");
            return;
        }
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Room #", "Type", "Price/Night", "Features"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        for (Room r : controller.getHotel().getRooms()) {
            if (r != null && !r.getIsBooked()) {
                model.addRow(new Object[]{
                        r.getRoomNumber(), r.getRoomType(),
                        String.format("$%.2f", r.getPricePerNight()),
                        r.getFeatures()
                });
            }
        }
        tableHeaderLabel.setText("Available Rooms (" + model.getRowCount() + ")");
        dataTable.setModel(model);
        showOutput(model.getRowCount() == 0
                ? "No available rooms right now."
                : model.getRowCount() + " available room(s) loaded.");
    }//GEN-LAST:event_listRoomsBtnActionPerformed

    private void listClientsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listClientsBtnActionPerformed
        if (controller.getHotel() == null || controller.getHotel().getClients() == null) {
            showOutput("Hotel data is unavailable.");
            return;
        }
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Client ID", "Name", "Phone", "Email"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        for (Client c : controller.getHotel().getClients()) {
            if (c != null) {
                model.addRow(new Object[]{
                        c.getClientId(), c.getName(), c.getPhone(), c.getEmail()
                });
            }
        }
        tableHeaderLabel.setText("All Clients (" + model.getRowCount() + ")");
        dataTable.setModel(model);
        showOutput(model.getRowCount() == 0
                ? "No clients registered."
                : model.getRowCount() + " client(s) loaded.");
    }//GEN-LAST:event_listClientsBtnActionPerformed

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

    // The original Update Booking popup, factored out so it can be triggered
    // from inside View Client Bookings.
    private void promptUpdateBooking(long bookingId) {
        try {
            String nightsText = javax.swing.JOptionPane.showInputDialog(this,
                    "New number of nights (-1 to keep current):");
            if (nightsText == null) { nightsText = "-1"; }
            String guestsText = javax.swing.JOptionPane.showInputDialog(this,
                    "New number of guests (-1 to keep current):");
            if (guestsText == null) { guestsText = "-1"; }
            String remarks = javax.swing.JOptionPane.showInputDialog(this,
                    "New remarks (blank to keep current):");

            int nights     = Integer.parseInt(nightsText.trim());
            int guests     = Integer.parseInt(guestsText.trim());
            String newRem  = (remarks == null || remarks.isEmpty()) ? null : remarks;
            receptionist.updateBooking(bookingId, nights, guests, newRem);
            showOutput("Update requested for booking #" + bookingId + ".");
        } catch (NumberFormatException ex) {
            showOutput("Error updating booking: numeric fields must be numbers.");
        }
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
    private javax.swing.JButton cancelBookingBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton createBookingBtn;
    private javax.swing.JTable dataTable;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton listClientsBtn;
    private javax.swing.JButton listRoomsBtn;
    private javax.swing.JButton loadBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JLabel outputHeaderLabel;
    private javax.swing.JScrollPane outputScroll;
    private javax.swing.JButton registerClientBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel tableHeaderLabel;
    private javax.swing.JScrollPane tableScroll;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton viewBookingsBtn;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
