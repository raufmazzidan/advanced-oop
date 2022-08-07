package tk3;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.Arrays;

public class RegistrationForm extends JFrame {
  JPanel panel = new JPanel();

  JLabel userNameLabel;
  JTextField userNameField;

  JLabel passwordLabel;
  JPasswordField passwordField;

  JLabel confirmPasswordLabel;
  JPasswordField confirmPasswordField;

  JLabel emailLabel;
  JTextField emailField;

  JPanel dobPanel = new JPanel();
  JLabel dobLabel;
  JComboBox<String> dateField;
  JComboBox<String> monthField;
  JComboBox<String> yearField;

  JButton buttonReset;
  JButton buttonSubmit;

  String dateOption[] = { "", "1", "2", "3", "4", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
      "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
  String monthOption[] = { "", "1", "2", "3", "4", "6", "7", "8", "9", "10", "11", "12" };
  String yearOption[] = { "", "1995", "1996", "1997", "1998", "1999", "2001", "2002", "2003", "2004", "2005" };

  RegistrationForm() {
    panel.setBorder(new EmptyBorder(32, 32, 32, 32));
    panel.setLayout(new GridLayout(0, 2, 16, 16));

    userNameLabel = new JLabel("Nama Pengguna");
    userNameField = new JTextField();
    panel.add(userNameLabel);
    panel.add(userNameField);

    passwordLabel = new JLabel("Kata Sandi");
    passwordField = new JPasswordField();
    panel.add(passwordLabel);
    panel.add(passwordField);

    confirmPasswordLabel = new JLabel("Konfirmasi Kata Sandi");
    confirmPasswordField = new JPasswordField();
    panel.add(confirmPasswordLabel);
    panel.add(confirmPasswordField);

    emailLabel = new JLabel("Email");
    emailField = new JTextField();
    panel.add(emailLabel);
    panel.add(emailField);

    dobLabel = new JLabel("Tanggal Lahir");
    dateField = new JComboBox<String>(dateOption);
    monthField = new JComboBox<String>(monthOption);
    yearField = new JComboBox<String>(yearOption);

    dobPanel.setLayout(new FlowLayout());
    dobPanel.add(dateField);
    dobPanel.add(monthField);
    dobPanel.add(yearField);
    panel.add(dobLabel);
    panel.add(dobPanel);

    buttonReset = new JButton("Reset");
    buttonReset.setPreferredSize(new Dimension(200, 0));
    buttonSubmit = new JButton("Login");
    panel.add(buttonReset);
    panel.add(buttonSubmit);

    add(panel);

    buttonReset.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda yakin?",
            "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
          userNameField.setText(null);
          passwordField.setText(null);
          confirmPasswordField.setText(null);
          emailField.setText(null);
          dateField.setSelectedIndex(0);
          monthField.setSelectedIndex(0);
          yearField.setSelectedIndex(0);
        }
      }
    });

    buttonSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String errorMessage = "";

        if (userNameField.getText().length() == 0) {
          errorMessage = "Nama Pengguna Harus Diisi!";
        } else if (passwordField.getPassword().length == 0) {
          errorMessage = "Kata Sandi Harus Diisi!";
        } else if (!(Arrays.equals(passwordField.getPassword(), confirmPasswordField.getPassword()))) {
          errorMessage = "Kata Sandi dan Konfirmasi Kata Sandi Harus Sama!";
        } else if (emailField.getText().length() == 0) {
          errorMessage = "Email Harus Diisi!";
        } else if (!(emailField.getText().contains("@") && emailField.getText().contains("."))) {
          errorMessage = "Format Email Salah!";
        } else if (dateField.getSelectedItem().equals("")) {
          errorMessage = "Tanggal Harus Dipilih!";
        } else if (monthField.getSelectedItem().equals("")) {
          errorMessage = "Bulan Harus Dipilih!";
        } else if (yearField.getSelectedItem().equals("")) {
          errorMessage = "Tahun Harus Dipilih!";
        }

        if (errorMessage.equals("")) {
          JOptionPane.showMessageDialog(null, "Sukses Login", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, errorMessage, "Informasi", JOptionPane.ERROR_MESSAGE);
        }

      }
    });
  }

  public static void main(String args[]) {
    JFrame frame = new RegistrationForm();
    frame.setTitle("Program Pendaftaran");
    frame.setSize(600, 400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
