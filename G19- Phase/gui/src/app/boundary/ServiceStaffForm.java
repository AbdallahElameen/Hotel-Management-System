package app.boundary;

import app.control.HotelController;
import app.entity.Booking;
import app.entity.FoodOrder;
import app.entity.ServiceOrder;
import app.entity.employee.ServiceStaff;

import javax.swing.table.DefaultTableModel;

public class ServiceStaffForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(ServiceStaffForm.class.getName());

    private final HotelController controller;
    private final ServiceStaff staff;
    private final HotelSystemUI coordinator;

    private boolean onDuty = false;

    public ServiceStaffForm(HotelController controller, ServiceStaff staff, HotelSystemUI coordinator) {
        this.controller  = controller;
        this.staff       = staff;
        this.coordinator = coordinator;
        initComponents();
        welcomeLabel.setText("Welcome, Service Staff " + staff.getName()
                + "  (ID " + staff.getEmployeeId() + ")");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        accentStrip = new javax.swing.JPanel();
        assignBookingBtn = new javax.swing.JButton();
        deliverFoodBtn = new javax.swing.JButton();
        performServiceBtn = new javax.swing.JButton();
        viewAssignedBtn = new javax.swing.JButton();
        listBookingsBtn = new javax.swing.JButton();
        viewBookingBtn = new javax.swing.JButton();
        clockInBtn = new javax.swing.JButton();
        clockOutBtn = new javax.swing.JButton();
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
        setTitle("Service Staff Dashboard");
        setBackground(new java.awt.Color(244, 246, 250));
        getContentPane().setBackground(new java.awt.Color(244, 246, 250));

        headerPanel.setBackground(new java.awt.Color(26, 42, 74));

        titleLabel.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Service Staff Dashboard");

        welcomeLabel.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(220, 226, 240));
        welcomeLabel.setText("Welcome, Service Staff");

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

        stylePrimaryButton(assignBookingBtn, "Assign To Booking");
        assignBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBookingBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(deliverFoodBtn, "Deliver Food");
        deliverFoodBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliverFoodBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(performServiceBtn, "Perform Service");
        performServiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performServiceBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(viewAssignedBtn, "View Assigned Booking");
        viewAssignedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAssignedBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(listBookingsBtn, "List All Bookings");
        listBookingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBookingsBtnActionPerformed(evt);
            }
        });

        stylePrimaryButton(viewBookingBtn, "View Booking Details");
        viewBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBookingBtnActionPerformed(evt);
            }
        });

        clockInBtn.setBackground(new java.awt.Color(40, 141, 80));
        clockInBtn.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        clockInBtn.setForeground(new java.awt.Color(255, 255, 255));
        clockInBtn.setText("Clock In");
        clockInBtn.setBorderPainted(false);
        clockInBtn.setFocusPainted(false);
        clockInBtn.setOpaque(true);
        clockInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockInBtnActionPerformed(evt);
            }
        });

        clockOutBtn.setBackground(new java.awt.Color(192, 57, 43));
        clockOutBtn.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        clockOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        clockOutBtn.setText("Clock Out");
        clockOutBtn.setBorderPainted(false);
        clockOutBtn.setFocusPainted(false);
        clockOutBtn.setOpaque(true);
        clockOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockOutBtnActionPerformed(evt);
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
                        .addComponent(assignBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(deliverFoodBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(performServiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(viewAssignedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(viewBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(clockInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(clockOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(assignBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deliverFoodBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(performServiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewAssignedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clockInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clockOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(tableHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(tableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void assignBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBookingBtnActionPerformed
        try {
            String idText = javax.swing.JOptionPane.showInputDialog(this, "Enter Booking ID to assign:");
            if (idText == null) { return; }
            long bookingId = Long.parseLong(idText.trim());
            staff.assignBooking(bookingId);
            Long assigned = staff.getAssignedBookingId();
            if (assigned != null && assigned == bookingId) {
                showOutput("Assigned to booking #" + bookingId + ".");
            } else {
                showOutput("Could not assign booking #" + bookingId + " (not found).");
            }
        } catch (NumberFormatException ex) {
            showOutput("Error assigning booking: ID must be numeric.");
        }
    }//GEN-LAST:event_assignBookingBtnActionPerformed

    // Staff picks the item; price comes from MenuCatalog and isn't editable here.
    private void deliverFoodBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliverFoodBtnActionPerformed
        MenuCatalog.Item picked = pickMenuItem(MenuCatalog.getFoodItems(),
                "Food Menu - select the item to deliver");
        if (picked == null) { return; }

        try {
            String idText = javax.swing.JOptionPane.showInputDialog(this, "Enter Booking ID:");
            if (idText == null) { return; }
            String qtyText = javax.swing.JOptionPane.showInputDialog(this,
                    "Quantity for \"" + picked.name + "\":");
            if (qtyText == null) { return; }

            long bookingId = Long.parseLong(idText.trim());
            int quantity   = Integer.parseInt(qtyText.trim());

            FoodOrder order = new FoodOrder(quantity, picked.name, picked.price);
            staff.deliverFood(bookingId, order);
            showOutput("Food delivered to booking #" + bookingId + ":\n" + order);
        } catch (NumberFormatException ex) {
            showOutput("Error delivering food: numeric fields must be numbers.");
        }
    }//GEN-LAST:event_deliverFoodBtnActionPerformed

    // Staff picks the service; price comes from MenuCatalog and isn't editable here.
    private void performServiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performServiceBtnActionPerformed
        MenuCatalog.Item picked = pickMenuItem(MenuCatalog.getServiceItems(),
                "Service Menu - select the service to perform");
        if (picked == null) { return; }

        try {
            String[] modes = { "Use assigned booking", "Enter booking ID" };
            String mode = (String) javax.swing.JOptionPane.showInputDialog(this,
                    "Choose booking target:", "Perform Service",
                    javax.swing.JOptionPane.QUESTION_MESSAGE, null, modes, modes[0]);
            if (mode == null) { return; }

            String qtyText = javax.swing.JOptionPane.showInputDialog(this,
                    "Quantity for \"" + picked.name + "\":");
            if (qtyText == null) { return; }
            int quantity = Integer.parseInt(qtyText.trim());

            ServiceOrder order = new ServiceOrder(picked.name, picked.price, quantity);

            if (modes[0].equals(mode)) {
                if (staff.getAssignedBookingId() == null) {
                    showOutput("No booking assigned. Assign a booking first.");
                    return;
                }
                staff.performService(order);
                showOutput("Service performed on assigned booking #"
                        + staff.getAssignedBookingId() + ":\n" + order);
            } else {
                String idText = javax.swing.JOptionPane.showInputDialog(this, "Enter Booking ID:");
                if (idText == null) { return; }
                long bookingId = Long.parseLong(idText.trim());
                staff.performService(bookingId, order);
                showOutput("Service performed on booking #" + bookingId + ":\n" + order);
            }
        } catch (NumberFormatException ex) {
            showOutput("Error performing service: numeric fields must be numbers.");
        }
    }//GEN-LAST:event_performServiceBtnActionPerformed

    private void viewAssignedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAssignedBtnActionPerformed
        Long assigned = staff.getAssignedBookingId();
        if (assigned == null) {
            showOutput("No booking currently assigned to you.");
            return;
        }
        Booking booking = controller.findBookingById(assigned);
        if (booking == null) {
            showOutput("Assigned booking #" + assigned + " could not be found in the system.");
            return;
        }
        showOutput("========== YOUR ASSIGNED BOOKING ==========\n" + booking);
    }//GEN-LAST:event_viewAssignedBtnActionPerformed

    private void listBookingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBookingsBtnActionPerformed
        if (controller.getHotel() == null || controller.getHotel().getBookings() == null) {
            showOutput("Hotel data is unavailable.");
            return;
        }
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Booking ID", "Client", "Room #", "Nights", "Guests", "Remarks"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        for (Booking b : controller.getHotel().getBookings()) {
            if (b != null) {
                model.addRow(new Object[]{
                        b.getBookingId(),
                        b.getClient() != null ? b.getClient().getName() : "-",
                        b.getRoom() != null ? b.getRoom().getRoomNumber() : "-",
                        b.getNumberOfNights(),
                        b.getNumberOfGuests(),
                        b.getSpecialRemarks()
                });
            }
        }
        tableHeaderLabel.setText("All Bookings (" + model.getRowCount() + ")");
        dataTable.setModel(model);
        showOutput(model.getRowCount() == 0
                ? "No bookings in the system."
                : model.getRowCount() + " booking(s) loaded.");
    }//GEN-LAST:event_listBookingsBtnActionPerformed

    private void viewBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBookingBtnActionPerformed
        try {
            String idText = javax.swing.JOptionPane.showInputDialog(this, "Enter Booking ID:");
            if (idText == null) { return; }
            long bookingId  = Long.parseLong(idText.trim());
            Booking booking = controller.findBookingById(bookingId);
            if (booking == null) {
                showOutput("No booking found with ID " + bookingId + ".");
                return;
            }
            showOutput("========== BOOKING #" + bookingId + " ==========\n" + booking);
        } catch (NumberFormatException ex) {
            showOutput("Error viewing booking: ID must be numeric.");
        }
    }//GEN-LAST:event_viewBookingBtnActionPerformed

    private void clockInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockInBtnActionPerformed
        if (onDuty) {
            showOutput("You are already clocked in.");
            return;
        }
        onDuty = true;
        staff.performDuty();
        showOutput("Service Staff " + staff.getName() + " clocked in at "
                + new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date()) + ".");
    }//GEN-LAST:event_clockInBtnActionPerformed

    private void clockOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockOutBtnActionPerformed
        if (!onDuty) {
            showOutput("You are not currently clocked in.");
            return;
        }
        onDuty = false;
        showOutput("Service Staff " + staff.getName() + " clocked out at "
                + new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date())
                + ". Have a good rest!");
    }//GEN-LAST:event_clockOutBtnActionPerformed

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

    // Pops up a table of menu items and returns the one the staff selected,
    // or null if they cancelled. Keeps prices read-only.
    private MenuCatalog.Item pickMenuItem(java.util.List<MenuCatalog.Item> items, String title) {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Item", "Price (set by Manager)"}, 0) {
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
                new Object[]{"Choose", "Cancel"}, "Cancel");
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
    private javax.swing.JButton assignBookingBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton clockInBtn;
    private javax.swing.JButton clockOutBtn;
    private javax.swing.JTable dataTable;
    private javax.swing.JButton deliverFoodBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton listBookingsBtn;
    private javax.swing.JButton loadBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JLabel outputHeaderLabel;
    private javax.swing.JScrollPane outputScroll;
    private javax.swing.JButton performServiceBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel tableHeaderLabel;
    private javax.swing.JScrollPane tableScroll;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton viewAssignedBtn;
    private javax.swing.JButton viewBookingBtn;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
