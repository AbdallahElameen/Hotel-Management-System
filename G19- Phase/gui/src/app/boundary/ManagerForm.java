package app.boundary;

import app.control.HotelController;
import app.entity.Booking;
import app.entity.employee.Employee;
import app.entity.employee.Manager;
import app.entity.employee.Receptionist;
import app.entity.employee.ServiceStaff;
import app.entity.room.Room;
import app.exceptions.InvalidBookingException;

import javax.swing.table.DefaultTableModel;

public class ManagerForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(ManagerForm.class.getName());

    private final HotelController controller;
    private final Manager manager;
    private final HotelSystemUI coordinator;

    public ManagerForm(HotelController controller, Manager manager, HotelSystemUI coordinator) {
        this.controller  = controller;
        this.manager     = manager;
        this.coordinator = coordinator;
        initComponents();
        welcomeLabel.setText("Welcome, Manager " + manager.getName()
                + "  (ID " + manager.getEmployeeId() + ")");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebarPanel = new javax.swing.JPanel();
        sidebarTitleLabel = new javax.swing.JLabel();
        sidebarSubtitleLabel = new javax.swing.JLabel();
        reportBtn = new javax.swing.JButton();
        addStaffBtn = new javax.swing.JButton();
        manageStaffBtn = new javax.swing.JButton();
        listRoomsBtn = new javax.swing.JButton();
        manageRoomBtn = new javax.swing.JButton();
        approveBookingBtn = new javax.swing.JButton();
        menuPricesBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
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
        setTitle("Manager Dashboard");
        setBackground(new java.awt.Color(244, 246, 250));
        getContentPane().setBackground(new java.awt.Color(244, 246, 250));

        sidebarPanel.setBackground(new java.awt.Color(26, 42, 74));

        sidebarTitleLabel.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        sidebarTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        sidebarTitleLabel.setText("Manager");

        sidebarSubtitleLabel.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        sidebarSubtitleLabel.setForeground(new java.awt.Color(200, 208, 230));
        sidebarSubtitleLabel.setText("Administration & Oversight");

        styleSidebarButton(reportBtn, "View Hotel Report");
        reportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportBtnActionPerformed(evt);
            }
        });

        styleSidebarButton(addStaffBtn, "Add Staff");
        addStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStaffBtnActionPerformed(evt);
            }
        });

        styleSidebarButton(manageStaffBtn, "Manage Staff");
        manageStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStaffBtnActionPerformed(evt);
            }
        });

        styleSidebarButton(listRoomsBtn, "List All Rooms");
        listRoomsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listRoomsBtnActionPerformed(evt);
            }
        });

        styleSidebarButton(manageRoomBtn, "Set Room Availability");
        manageRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRoomBtnActionPerformed(evt);
            }
        });

        styleSidebarButton(approveBookingBtn, "Approve Booking");
        approveBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBookingBtnActionPerformed(evt);
            }
        });

        styleSidebarButton(menuPricesBtn, "Manage Menu Prices");
        menuPricesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPricesBtnActionPerformed(evt);
            }
        });

        styleSidebarButton(clearBtn, "Clear Output");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidebarTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sidebarSubtitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listRoomsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(approveBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuPricesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(sidebarTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(sidebarSubtitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(reportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(addStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(manageStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(listRoomsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(manageRoomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(approveBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(menuPricesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        mainPanel.setBackground(new java.awt.Color(244, 246, 250));

        titleLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(26, 42, 74));
        titleLabel.setText("Manager Dashboard");

        welcomeLabel.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(108, 117, 125));
        welcomeLabel.setText("Welcome, Manager");

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

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tableHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(loadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(tableHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(tableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(outputHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(outputScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportBtnActionPerformed
        if (controller.getHotel() == null) {
            showOutput("Hotel data is unavailable.");
            return;
        }
        int totalRooms  = safeSize(controller.getHotel().getRooms());
        int bookedRooms = 0;
        if (controller.getHotel().getRooms() != null) {
            for (Room r : controller.getHotel().getRooms()) {
                if (r != null && r.getIsBooked()) { bookedRooms++; }
            }
        }

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Metric", "Value"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        model.addRow(new Object[]{"Hotel Name",       controller.getHotel().getHotelName()});
        model.addRow(new Object[]{"Viewed By",        "Manager " + manager.getName()});
        model.addRow(new Object[]{"Total Rooms",      totalRooms});
        model.addRow(new Object[]{"Booked Rooms",     bookedRooms});
        model.addRow(new Object[]{"Available Rooms",  totalRooms - bookedRooms});
        model.addRow(new Object[]{"Total Clients",    safeSize(controller.getHotel().getClients())});
        model.addRow(new Object[]{"Active Bookings",  safeSize(controller.getHotel().getBookings())});
        model.addRow(new Object[]{"Total Employees",  safeSize(controller.getHotel().getEmployees())});
        model.addRow(new Object[]{"Approved by Me",   manager.getApprovedBookingIds().size()});

        tableHeaderLabel.setText("Hotel Report");
        dataTable.setModel(model);
        autoSizeColumns();
        showOutput("Report generated for " + controller.getHotel().getHotelName() + ".");
    }//GEN-LAST:event_reportBtnActionPerformed

    private void addStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStaffBtnActionPerformed
        try {
            String[] roles = { "Manager", "Receptionist", "ServiceStaff" };
            String role = (String) javax.swing.JOptionPane.showInputDialog(this,
                    "Select the new staff role:", "Add Staff",
                    javax.swing.JOptionPane.QUESTION_MESSAGE, null, roles, roles[1]);
            if (role == null) { return; }

            String idText = javax.swing.JOptionPane.showInputDialog(this, "Enter Employee ID:");
            if (idText == null) { return; }
            String name = javax.swing.JOptionPane.showInputDialog(this, "Enter Full Name:");
            if (name == null) { return; }
            String salaryText = javax.swing.JOptionPane.showInputDialog(this, "Enter Monthly Salary:");
            if (salaryText == null) { return; }

            int empId     = Integer.parseInt(idText.trim());
            double salary = Double.parseDouble(salaryText.trim());

            Employee emp;
            switch (role) {
                case "Manager":      emp = new Manager(empId, name, salary); break;
                case "Receptionist": emp = new Receptionist(empId, name, salary); break;
                default:             emp = new ServiceStaff(empId, name, salary); break;
            }
            emp.setHotelController(controller);
            manager.addStaff(emp);
            showOutput("Staff added: " + emp);
        } catch (NumberFormatException ex) {
            showOutput("Error adding staff: ID and salary must be numeric.");
        }
    }//GEN-LAST:event_addStaffBtnActionPerformed

    private void manageStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStaffBtnActionPerformed
        if (controller.getHotel() == null || controller.getHotel().getEmployees() == null
                || controller.getHotel().getEmployees().isEmpty()) {
            showOutput("No staff to manage yet.");
            return;
        }

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Employee ID", "Name", "Role", "Salary"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        for (Employee emp : controller.getHotel().getEmployees()) {
            if (emp != null) {
                model.addRow(new Object[]{
                        emp.getEmployeeId(), emp.getName(), emp.getRole(),
                        String.format("$%.2f", emp.getSalary())
                });
            }
        }

        javax.swing.JTable table = new javax.swing.JTable(model);
        table.setRowHeight(22);
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12));
        table.getTableHeader().setBackground(new java.awt.Color(26, 42, 74));
        table.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.JScrollPane sp = new javax.swing.JScrollPane(table);
        sp.setPreferredSize(new java.awt.Dimension(560, 300));

        while (true) {
            Object[] options = { "Update Selected", "Delete Selected", "Close" };
            int choice = javax.swing.JOptionPane.showOptionDialog(this, sp,
                    "Manage Staff - select a row, then choose an action",
                    javax.swing.JOptionPane.DEFAULT_OPTION,
                    javax.swing.JOptionPane.PLAIN_MESSAGE, null, options, options[2]);

            if (choice == 2 || choice == javax.swing.JOptionPane.CLOSED_OPTION) {
                return;
            }

            int row = table.getSelectedRow();
            if (row < 0) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Please select a staff row first.",
                        "Manage Staff", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                continue;
            }
            int empId = (Integer) model.getValueAt(row, 0);
            String empName = String.valueOf(model.getValueAt(row, 1));

            if (choice == 0) {
                try {
                    String newName = javax.swing.JOptionPane.showInputDialog(this,
                            "New name (leave blank to keep existing):", empName);
                    if (newName == null) { continue; }
                    String salaryText = javax.swing.JOptionPane.showInputDialog(this,
                            "New salary (0 or blank to keep existing):");
                    if (salaryText == null) { salaryText = "0"; }
                    double salary = salaryText.trim().isEmpty()
                            ? 0 : Double.parseDouble(salaryText.trim());
                    manager.updateStaff(empId, newName, salary);
                    showOutput("Update requested for employee #" + empId + ".");
                    return;
                } catch (NumberFormatException ex) {
                    showOutput("Error updating staff: salary must be numeric.");
                    return;
                }
            } else {
                int ok = javax.swing.JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to delete " + empName
                                + " (ID " + empId + ")?",
                        "Confirm Deletion",
                        javax.swing.JOptionPane.YES_NO_OPTION,
                        javax.swing.JOptionPane.WARNING_MESSAGE);
                if (ok == javax.swing.JOptionPane.YES_OPTION) {
                    manager.removeStaff(empId);
                    showOutput("Staff member " + empName + " (ID " + empId + ") removed.");
                    return;
                }
            }
        }
    }//GEN-LAST:event_manageStaffBtnActionPerformed

    private void listRoomsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listRoomsBtnActionPerformed
        if (controller.getHotel() == null || controller.getHotel().getRooms() == null) {
            showOutput("Hotel data is unavailable.");
            return;
        }

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Room #", "Type", "Price/Night", "Status", "Features"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        for (Room r : controller.getHotel().getRooms()) {
            if (r != null) {
                model.addRow(new Object[]{
                        r.getRoomNumber(), r.getRoomType(),
                        String.format("$%.2f", r.getPricePerNight()),
                        r.getIsBooked() ? "Booked" : "Available",
                        r.getFeatures()
                });
            }
        }

        tableHeaderLabel.setText("All Rooms (" + model.getRowCount() + ")");
        dataTable.setModel(model);
        autoSizeColumns();
        showOutput(model.getRowCount() + " room(s) loaded.");
    }//GEN-LAST:event_listRoomsBtnActionPerformed

    private void manageRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRoomBtnActionPerformed
        try {
            String roomText = javax.swing.JOptionPane.showInputDialog(this, "Enter Room Number:");
            if (roomText == null) { return; }
            Object[] states = { "Booked", "Available" };
            Object state = javax.swing.JOptionPane.showInputDialog(this,
                    "Set room status to:", "Room Status",
                    javax.swing.JOptionPane.QUESTION_MESSAGE, null, states, states[1]);
            if (state == null) { return; }
            int roomNum = Integer.parseInt(roomText.trim());
            manager.manageRoomAvailability(roomNum, "Booked".equals(state));
            showOutput("Room #" + roomNum + " set to " + state + ".");
        } catch (NumberFormatException ex) {
            showOutput("Error setting room status: Room number must be numeric.");
        }
    }//GEN-LAST:event_manageRoomBtnActionPerformed

    private void approveBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBookingBtnActionPerformed
        try {
            String idText = javax.swing.JOptionPane.showInputDialog(this, "Enter Booking ID to approve:");
            if (idText == null) { return; }
            long bookingId  = Long.parseLong(idText.trim());
            Booking booking = controller.findBookingById(bookingId);
            manager.approveBooking(booking);
            showOutput("Booking #" + bookingId + " approved by Manager " + manager.getName() + ".");
        } catch (NumberFormatException ex) {
            showOutput("Error approving booking: booking ID must be numeric.");
        } catch (InvalidBookingException ex) {
            showOutput("Approval failed: " + ex.getMessage());
        }
    }//GEN-LAST:event_approveBookingBtnActionPerformed

    private void menuPricesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPricesBtnActionPerformed
        String[] scopes = { "Food Menu", "Service Menu" };
        String scope = (String) javax.swing.JOptionPane.showInputDialog(this,
                "Which menu do you want to edit?", "Manage Menu Prices",
                javax.swing.JOptionPane.QUESTION_MESSAGE, null, scopes, scopes[0]);
        if (scope == null) { return; }

        boolean food = scopes[0].equals(scope);
        java.util.List<MenuCatalog.Item> items = food
                ? MenuCatalog.getFoodItems() : MenuCatalog.getServiceItems();

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"#", "Item", "Current Price"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        for (int i = 0; i < items.size(); i++) {
            model.addRow(new Object[]{ i + 1, items.get(i).name,
                    String.format("$%.2f", items.get(i).price) });
        }

        javax.swing.JTable table = new javax.swing.JTable(model);
        table.setRowHeight(22);
        table.getTableHeader().setBackground(new java.awt.Color(26, 42, 74));
        table.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.JScrollPane sp = new javax.swing.JScrollPane(table);
        sp.setPreferredSize(new java.awt.Dimension(480, 280));

        int res = javax.swing.JOptionPane.showOptionDialog(this, sp,
                scope + " - select an item and press Edit Price",
                javax.swing.JOptionPane.DEFAULT_OPTION,
                javax.swing.JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"Edit Price", "Close"}, "Close");
        if (res != 0) { return; }

        int row = table.getSelectedRow();
        if (row < 0) {
            showOutput("No item selected.");
            return;
        }
        String newPriceText = javax.swing.JOptionPane.showInputDialog(this,
                "New price for \"" + items.get(row).name + "\":");
        if (newPriceText == null) { return; }
        try {
            double newPrice = Double.parseDouble(newPriceText.trim());
            if (food) { MenuCatalog.setFoodPrice(row, newPrice); }
            else      { MenuCatalog.setServicePrice(row, newPrice); }
            showOutput("Updated price for \"" + items.get(row).name
                    + "\" to $" + String.format("%.2f", newPrice) + ".");
        } catch (NumberFormatException ex) {
            showOutput("Error updating price: value must be numeric.");
        }
    }//GEN-LAST:event_menuPricesBtnActionPerformed

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

    private void styleSidebarButton(javax.swing.JButton btn, String text) {
        btn.setText(text);
        btn.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
        btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn.setBackground(new java.awt.Color(255, 255, 255));
        btn.setForeground(new java.awt.Color(26, 42, 74));
        btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 14, 6, 12));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
    }

    private void showOutput(String text) {
        outputArea.setText(text);
        outputArea.setCaretPosition(0);
    }

    private int safeSize(java.util.List<?> list) {
        return (list == null) ? 0 : list.size();
    }

    private void autoSizeColumns() {
        if (dataTable.getColumnCount() > 0) {
            dataTable.getColumnModel().getColumn(0).setPreferredWidth(140);
        }
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
    private javax.swing.JButton addStaffBtn;
    private javax.swing.JButton approveBookingBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTable dataTable;
    private javax.swing.JButton listRoomsBtn;
    private javax.swing.JButton loadBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton manageRoomBtn;
    private javax.swing.JButton manageStaffBtn;
    private javax.swing.JButton menuPricesBtn;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JLabel outputHeaderLabel;
    private javax.swing.JScrollPane outputScroll;
    private javax.swing.JButton reportBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JLabel sidebarSubtitleLabel;
    private javax.swing.JLabel sidebarTitleLabel;
    private javax.swing.JLabel tableHeaderLabel;
    private javax.swing.JScrollPane tableScroll;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
