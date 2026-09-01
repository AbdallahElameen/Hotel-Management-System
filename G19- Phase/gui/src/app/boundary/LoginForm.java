package app.boundary;

import app.control.HotelController;
import app.entity.Client;
import app.entity.employee.Employee;
import app.entity.employee.Manager;
import app.entity.employee.Receptionist;
import app.entity.employee.ServiceStaff;
import app.exceptions.InvalidLoginException;

public class LoginForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(LoginForm.class.getName());

    private static final int MAX_ATTEMPTS = 3;

    private final HotelController controller;
    private final HotelSystemUI coordinator;
    private int loginAttempts = 0;

    public LoginForm(HotelController controller, HotelSystemUI coordinator) {
        this.controller  = controller;
        this.coordinator = coordinator;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brandPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        subtitleLabel = new javax.swing.JLabel();
        accentStrip = new javax.swing.JPanel();
        formPanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        roleCombo = new javax.swing.JComboBox<>();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        errorLabel = new javax.swing.JLabel();
        attemptsLabel = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Management System - Login");
        setBackground(new java.awt.Color(244, 246, 250));
        setResizable(false);
        getContentPane().setBackground(new java.awt.Color(244, 246, 250));

        brandPanel.setBackground(new java.awt.Color(26, 42, 74));

        titleLabel.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Hotel Management System");

        subtitleLabel.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        subtitleLabel.setForeground(new java.awt.Color(220, 226, 240));
        subtitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtitleLabel.setText("Welcome - please sign in to continue");

        javax.swing.GroupLayout brandPanelLayout = new javax.swing.GroupLayout(brandPanel);
        brandPanel.setLayout(brandPanelLayout);
        brandPanelLayout.setHorizontalGroup(
            brandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(brandPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(brandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        brandPanelLayout.setVerticalGroup(
            brandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(brandPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(subtitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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

        formPanel.setBackground(new java.awt.Color(255, 255, 255));
        formPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 226, 233), 1));

        welcomeLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(26, 42, 74));
        welcomeLabel.setText("Sign in to your account");

        roleLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(26, 42, 74));
        roleLabel.setText("Role");

        roleCombo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        roleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Receptionist", "ServiceStaff", "Client" }));

        idLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(26, 42, 74));
        idLabel.setText("User ID");

        idField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        idField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 226, 233), 1),
                javax.swing.BorderFactory.createEmptyBorder(6, 8, 6, 8)));

        passwordLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(26, 42, 74));
        passwordLabel.setText("Password");

        passwordField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        passwordField.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 226, 233), 1),
                javax.swing.BorderFactory.createEmptyBorder(6, 8, 6, 8)));

        errorLabel.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(192, 57, 43));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorLabel.setText(" ");

        attemptsLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        attemptsLabel.setForeground(new java.awt.Color(108, 117, 125));
        attemptsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        attemptsLabel.setText("Attempts remaining: 3");

        loginBtn.setBackground(new java.awt.Color(26, 42, 74));
        loginBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("LOGIN");
        loginBtn.setBorderPainted(false);
        loginBtn.setFocusPainted(false);
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(108, 117, 125));
        exitBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setText("EXIT");
        exitBtn.setBorderPainted(false);
        exitBtn.setFocusPainted(false);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attemptsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(roleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(attemptsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(brandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(accentStrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(brandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(accentStrip, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String idText   = idField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String role     = (String) roleCombo.getSelectedItem();

        if (idText.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please enter your ID and password.");
            return;
        }

        int userId;
        try {
            userId = Integer.parseInt(idText);
        } catch (NumberFormatException ex) {
            errorLabel.setText("User ID must be a number.");
            return;
        }

        try {
            if ("Client".equals(role)) {
                Client client = controller.authenticateClient(userId, password);
                coordinator.showClientDashboard(client);
            } else {
                Employee emp = controller.authenticateEmployee(userId, password, role);
                switch (role) {
                    case "Manager":
                        coordinator.showManagerDashboard((Manager) emp);
                        break;
                    case "Receptionist":
                        coordinator.showReceptionistDashboard((Receptionist) emp);
                        break;
                    default:
                        coordinator.showServiceStaffDashboard((ServiceStaff) emp);
                        break;
                }
            }
            loginAttempts = 0;
            errorLabel.setText(" ");

        } catch (InvalidLoginException ex) {
            // Failed login counts toward the lockout limit.
            loginAttempts++;
            int remaining = MAX_ATTEMPTS - loginAttempts;
            errorLabel.setText("Login failed: " + ex.getMessage());
            attemptsLabel.setText("Attempts remaining: " + remaining);

            if (loginAttempts >= MAX_ATTEMPTS) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Too many failed login attempts. The system will now exit.",
                        "Access Denied", javax.swing.JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
                "Are you sure you want to exit?", "Exit",
                javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitBtnActionPerformed

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
    private javax.swing.JLabel attemptsLabel;
    private javax.swing.JPanel brandPanel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel formPanel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JComboBox<String> roleCombo;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
